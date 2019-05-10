package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.HiddenNodeController;
import com.cloudkeeper.leasing.identity.domain.HiddenNode;
import com.cloudkeeper.leasing.identity.dto.hiddennode.HiddenNodeDTO;
import com.cloudkeeper.leasing.identity.dto.hiddennode.HiddenNodeSearchable;
import com.cloudkeeper.leasing.identity.service.HiddenNodeService;
import com.cloudkeeper.leasing.identity.vo.HiddenNodeVO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 隐患节点信息 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HiddenNodeControllerImpl implements HiddenNodeController {

    /** 隐患节点信息 service */
    private final HiddenNodeService hiddenNodeService;

    @Override
    public Result<HiddenNodeVO> findOne(@ApiParam(value = "隐患节点信息id", required = true) @PathVariable String id) {
        Optional<HiddenNode> hiddenNodeOptional = hiddenNodeService.findOptionalById(id);
        return hiddenNodeOptional.map(hiddenNode -> Result.of(hiddenNode.convert(HiddenNodeVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<HiddenNodeVO> add(@ApiParam(value = "隐患节点信息 DTO", required = true) @RequestBody @Validated HiddenNodeDTO hiddenNodeDTO) {
        HiddenNode hiddenNode = hiddenNodeService.save(hiddenNodeDTO.convert(HiddenNode.class));
        return Result.ofAddSuccess(hiddenNode.convert(HiddenNodeVO.class));
    }

    @Override
    public Result<HiddenNodeVO> update(@ApiParam(value = "隐患节点信息id", required = true) @PathVariable String id,
        @ApiParam(value = "隐患节点信息 DTO", required = true) @RequestBody @Validated HiddenNodeDTO hiddenNodeDTO) {
        Optional<HiddenNode> hiddenNodeOptional = hiddenNodeService.findOptionalById(id);
        if (!hiddenNodeOptional.isPresent()) {
            return Result.ofLost();
        }
        HiddenNode hiddenNode = hiddenNodeOptional.get();
        BeanUtils.copyProperties(hiddenNodeDTO, hiddenNode);
        hiddenNode = hiddenNodeService.save(hiddenNode);
        return Result.ofUpdateSuccess(hiddenNode.convert(HiddenNodeVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "隐患节点信息id", required = true) @PathVariable String id) {
        hiddenNodeService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<HiddenNodeVO>> list(@ApiParam(value = "隐患节点信息查询条件", required = true) @RequestBody HiddenNodeSearchable hiddenNodeSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<HiddenNode> hiddenNodeList = hiddenNodeService.findAll(hiddenNodeSearchable, sort);
        List<HiddenNodeVO> hiddenNodeVOList = HiddenNode.convert(hiddenNodeList, HiddenNodeVO.class);
        return Result.of(hiddenNodeVOList);
    }

    @Override
    public Result<Page<HiddenNodeVO>> page(@ApiParam(value = "隐患节点信息查询条件", required = true) @RequestBody HiddenNodeSearchable hiddenNodeSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<HiddenNode> hiddenNodePage = hiddenNodeService.findAll(hiddenNodeSearchable, pageable);
        Page<HiddenNodeVO> hiddenNodeVOPage = HiddenNode.convert(hiddenNodePage, HiddenNodeVO.class);
        return Result.of(hiddenNodeVOPage);
    }

}