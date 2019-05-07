package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.PreWarningController;
import com.cloudkeeper.leasing.identity.domain.PreWarning;
import com.cloudkeeper.leasing.identity.dto.prewarning.PreWarningDTO;
import com.cloudkeeper.leasing.identity.dto.prewarning.PreWarningSearchable;
import com.cloudkeeper.leasing.identity.service.PreWarningService;
import com.cloudkeeper.leasing.identity.vo.PreWarningVO;
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
 * 预警信息 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PreWarningControllerImpl implements PreWarningController {

    /** 预警信息 service */
    private final PreWarningService preWarningService;

    @Override
    public Result<PreWarningVO> findOne(@ApiParam(value = "预警信息id", required = true) @PathVariable String id) {
        Optional<PreWarning> preWarningOptional = preWarningService.findOptionalById(id);
        return preWarningOptional.map(preWarning -> Result.of(preWarning.convert(PreWarningVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<PreWarningVO> add(@ApiParam(value = "预警信息 DTO", required = true) @RequestBody @Validated PreWarningDTO preWarningDTO) {
        PreWarning preWarning = preWarningService.save(preWarningDTO.convert(PreWarning.class));
        return Result.ofAddSuccess(preWarning.convert(PreWarningVO.class));
    }

    @Override
    public Result<PreWarningVO> update(@ApiParam(value = "预警信息id", required = true) @PathVariable String id,
        @ApiParam(value = "预警信息 DTO", required = true) @RequestBody @Validated PreWarningDTO preWarningDTO) {
        Optional<PreWarning> preWarningOptional = preWarningService.findOptionalById(id);
        if (!preWarningOptional.isPresent()) {
            return Result.ofLost();
        }
        PreWarning preWarning = preWarningOptional.get();
        BeanUtils.copyProperties(preWarningDTO, preWarning);
        preWarning = preWarningService.save(preWarning);
        return Result.ofUpdateSuccess(preWarning.convert(PreWarningVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "预警信息id", required = true) @PathVariable String id) {
        preWarningService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<PreWarningVO>> list(@ApiParam(value = "预警信息查询条件", required = true) @RequestBody PreWarningSearchable preWarningSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<PreWarning> preWarningList = preWarningService.findAll(preWarningSearchable, sort);
        List<PreWarningVO> preWarningVOList = PreWarning.convert(preWarningList, PreWarningVO.class);
        return Result.of(preWarningVOList);
    }

    @Override
    public Result<Page<PreWarningVO>> page(@ApiParam(value = "预警信息查询条件", required = true) @RequestBody PreWarningSearchable preWarningSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<PreWarning> preWarningPage = preWarningService.findAll(preWarningSearchable, pageable);
        Page<PreWarningVO> preWarningVOPage = PreWarning.convert(preWarningPage, PreWarningVO.class);
        return Result.of(preWarningVOPage);
    }

}