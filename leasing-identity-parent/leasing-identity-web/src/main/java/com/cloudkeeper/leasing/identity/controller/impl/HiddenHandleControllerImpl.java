package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.HiddenHandleController;
import com.cloudkeeper.leasing.identity.domain.HiddenHandle;
import com.cloudkeeper.leasing.identity.dto.hiddenhandle.HiddenHandleDTO;
import com.cloudkeeper.leasing.identity.dto.hiddenhandle.HiddenHandleSearchable;
import com.cloudkeeper.leasing.identity.service.HiddenHandleService;
import com.cloudkeeper.leasing.identity.vo.HiddenHandleVO;
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
 * 隐患处理结果 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HiddenHandleControllerImpl implements HiddenHandleController {

    /** 隐患处理结果 service */
    private final HiddenHandleService hiddenHandleService;

    @Override
    public Result<HiddenHandleVO> findOne(@ApiParam(value = "隐患处理结果id", required = true) @PathVariable String id) {
        Optional<HiddenHandle> hiddenHandleOptional = hiddenHandleService.findOptionalById(id);
        return hiddenHandleOptional.map(hiddenHandle -> Result.of(hiddenHandle.convert(HiddenHandleVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<HiddenHandleVO> add(@ApiParam(value = "隐患处理结果 DTO", required = true) @RequestBody @Validated HiddenHandleDTO hiddenHandleDTO) {
        HiddenHandle hiddenHandle = hiddenHandleService.save(hiddenHandleDTO.convert(HiddenHandle.class));
        return Result.ofAddSuccess(hiddenHandle.convert(HiddenHandleVO.class));
    }

    @Override
    public Result<HiddenHandleVO> update(@ApiParam(value = "隐患处理结果id", required = true) @PathVariable String id,
        @ApiParam(value = "隐患处理结果 DTO", required = true) @RequestBody @Validated HiddenHandleDTO hiddenHandleDTO) {
        Optional<HiddenHandle> hiddenHandleOptional = hiddenHandleService.findOptionalById(id);
        if (!hiddenHandleOptional.isPresent()) {
            return Result.ofLost();
        }
        HiddenHandle hiddenHandle = hiddenHandleOptional.get();
        BeanUtils.copyProperties(hiddenHandleDTO, hiddenHandle);
        hiddenHandle = hiddenHandleService.save(hiddenHandle);
        return Result.ofUpdateSuccess(hiddenHandle.convert(HiddenHandleVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "隐患处理结果id", required = true) @PathVariable String id) {
        hiddenHandleService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<HiddenHandleVO>> list(@ApiParam(value = "隐患处理结果查询条件", required = true) @RequestBody HiddenHandleSearchable hiddenHandleSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<HiddenHandle> hiddenHandleList = hiddenHandleService.findAll(hiddenHandleSearchable, sort);
        List<HiddenHandleVO> hiddenHandleVOList = HiddenHandle.convert(hiddenHandleList, HiddenHandleVO.class);
        return Result.of(hiddenHandleVOList);
    }

    @Override
    public Result<Page<HiddenHandleVO>> page(@ApiParam(value = "隐患处理结果查询条件", required = true) @RequestBody HiddenHandleSearchable hiddenHandleSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<HiddenHandle> hiddenHandlePage = hiddenHandleService.findAll(hiddenHandleSearchable, pageable);
        Page<HiddenHandleVO> hiddenHandleVOPage = HiddenHandle.convert(hiddenHandlePage, HiddenHandleVO.class);
        return Result.of(hiddenHandleVOPage);
    }

}