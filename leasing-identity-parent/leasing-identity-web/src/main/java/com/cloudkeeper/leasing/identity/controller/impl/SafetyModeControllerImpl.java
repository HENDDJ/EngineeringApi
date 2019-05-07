package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SafetyModeController;
import com.cloudkeeper.leasing.identity.domain.SafetyMode;
import com.cloudkeeper.leasing.identity.dto.safetymode.SafetyModeDTO;
import com.cloudkeeper.leasing.identity.dto.safetymode.SafetyModeSearchable;
import com.cloudkeeper.leasing.identity.service.SafetyModeService;
import com.cloudkeeper.leasing.identity.vo.SafetyModeVO;
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
 * 安全生产方式 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SafetyModeControllerImpl implements SafetyModeController {

    /** 安全生产方式 service */
    private final SafetyModeService safetyModeService;

    @Override
    public Result<SafetyModeVO> findOne(@ApiParam(value = "安全生产方式id", required = true) @PathVariable String id) {
        Optional<SafetyMode> safetyModeOptional = safetyModeService.findOptionalById(id);
        return safetyModeOptional.map(safetyMode -> Result.of(safetyMode.convert(SafetyModeVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SafetyModeVO> add(@ApiParam(value = "安全生产方式 DTO", required = true) @RequestBody @Validated SafetyModeDTO safetyModeDTO) {
        SafetyMode safetyMode = safetyModeService.save(safetyModeDTO.convert(SafetyMode.class));
        return Result.ofAddSuccess(safetyMode.convert(SafetyModeVO.class));
    }

    @Override
    public Result<SafetyModeVO> update(@ApiParam(value = "安全生产方式id", required = true) @PathVariable String id,
        @ApiParam(value = "安全生产方式 DTO", required = true) @RequestBody @Validated SafetyModeDTO safetyModeDTO) {
        Optional<SafetyMode> safetyModeOptional = safetyModeService.findOptionalById(id);
        if (!safetyModeOptional.isPresent()) {
            return Result.ofLost();
        }
        SafetyMode safetyMode = safetyModeOptional.get();
        BeanUtils.copyProperties(safetyModeDTO, safetyMode);
        safetyMode = safetyModeService.save(safetyMode);
        return Result.ofUpdateSuccess(safetyMode.convert(SafetyModeVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "安全生产方式id", required = true) @PathVariable String id) {
        safetyModeService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SafetyModeVO>> list(@ApiParam(value = "安全生产方式查询条件", required = true) @RequestBody SafetyModeSearchable safetyModeSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<SafetyMode> safetyModeList = safetyModeService.findAll(safetyModeSearchable, sort);
        List<SafetyModeVO> safetyModeVOList = SafetyMode.convert(safetyModeList, SafetyModeVO.class);
        return Result.of(safetyModeVOList);
    }

    @Override
    public Result<Page<SafetyModeVO>> page(@ApiParam(value = "安全生产方式查询条件", required = true) @RequestBody SafetyModeSearchable safetyModeSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SafetyMode> safetyModePage = safetyModeService.findAll(safetyModeSearchable, pageable);
        Page<SafetyModeVO> safetyModeVOPage = SafetyMode.convert(safetyModePage, SafetyModeVO.class);
        return Result.of(safetyModeVOPage);
    }

}