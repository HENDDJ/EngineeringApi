package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.HiddenIssueController;
import com.cloudkeeper.leasing.identity.domain.HiddenIssue;
import com.cloudkeeper.leasing.identity.dto.hiddenissue.HiddenIssueDTO;
import com.cloudkeeper.leasing.identity.dto.hiddenissue.HiddenIssueSearchable;
import com.cloudkeeper.leasing.identity.service.HiddenIssueService;
import com.cloudkeeper.leasing.identity.vo.HiddenIssueVO;
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
 * 隐患信息 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HiddenIssueControllerImpl implements HiddenIssueController {

    /** 隐患信息 service */
    private final HiddenIssueService hiddenIssueService;

    @Override
    public Result<HiddenIssueVO> findOne(@ApiParam(value = "隐患信息id", required = true) @PathVariable String id) {
        Optional<HiddenIssue> hiddenIssueOptional = hiddenIssueService.findOptionalById(id);
        return hiddenIssueOptional.map(hiddenIssue -> Result.of(hiddenIssue.convert(HiddenIssueVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<HiddenIssueVO> add(@ApiParam(value = "隐患信息 DTO", required = true) @RequestBody @Validated HiddenIssueDTO hiddenIssueDTO) {
        HiddenIssue hiddenIssue = hiddenIssueService.save(hiddenIssueDTO.convert(HiddenIssue.class));
        return Result.ofAddSuccess(hiddenIssue.convert(HiddenIssueVO.class));
    }

    @Override
    public Result<HiddenIssueVO> update(@ApiParam(value = "隐患信息id", required = true) @PathVariable String id,
        @ApiParam(value = "隐患信息 DTO", required = true) @RequestBody @Validated HiddenIssueDTO hiddenIssueDTO) {
        Optional<HiddenIssue> hiddenIssueOptional = hiddenIssueService.findOptionalById(id);
        if (!hiddenIssueOptional.isPresent()) {
            return Result.ofLost();
        }
        HiddenIssue hiddenIssue = hiddenIssueOptional.get();
        BeanUtils.copyProperties(hiddenIssueDTO, hiddenIssue);
        hiddenIssue = hiddenIssueService.save(hiddenIssue);
        return Result.ofUpdateSuccess(hiddenIssue.convert(HiddenIssueVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "隐患信息id", required = true) @PathVariable String id) {
        hiddenIssueService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<HiddenIssueVO>> list(@ApiParam(value = "隐患信息查询条件", required = true) @RequestBody HiddenIssueSearchable hiddenIssueSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<HiddenIssue> hiddenIssueList = hiddenIssueService.findAll(hiddenIssueSearchable, sort);
        List<HiddenIssueVO> hiddenIssueVOList = HiddenIssue.convert(hiddenIssueList, HiddenIssueVO.class);
        return Result.of(hiddenIssueVOList);
    }

    @Override
    public Result<Page<HiddenIssueVO>> page(@ApiParam(value = "隐患信息查询条件", required = true) @RequestBody HiddenIssueSearchable hiddenIssueSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<HiddenIssue> hiddenIssuePage = hiddenIssueService.findAll(hiddenIssueSearchable, pageable);
        Page<HiddenIssueVO> hiddenIssueVOPage = HiddenIssue.convert(hiddenIssuePage, HiddenIssueVO.class);
        return Result.of(hiddenIssueVOPage);
    }

}