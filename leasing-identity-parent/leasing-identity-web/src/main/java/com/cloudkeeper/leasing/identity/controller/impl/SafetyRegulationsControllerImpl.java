package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SafetyRegulationsController;
import com.cloudkeeper.leasing.identity.domain.SafetyRegulations;
import com.cloudkeeper.leasing.identity.dto.safetyregulations.SafetyRegulationsDTO;
import com.cloudkeeper.leasing.identity.dto.safetyregulations.SafetyRegulationsSearchable;
import com.cloudkeeper.leasing.identity.service.SafetyRegulationsService;
import com.cloudkeeper.leasing.identity.vo.SafetyRegulationsVO;
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
 * 安全生产规定 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SafetyRegulationsControllerImpl implements SafetyRegulationsController {

    /** 安全生产规定 service */
    private final SafetyRegulationsService safetyRegulationsService;

    @Override
    public Result<SafetyRegulationsVO> findOne(@ApiParam(value = "安全生产规定id", required = true) @PathVariable String id) {
        Optional<SafetyRegulations> safetyRegulationsOptional = safetyRegulationsService.findOptionalById(id);
        return safetyRegulationsOptional.map(safetyRegulations -> Result.of(safetyRegulations.convert(SafetyRegulationsVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SafetyRegulationsVO> add(@ApiParam(value = "安全生产规定 DTO", required = true) @RequestBody @Validated SafetyRegulationsDTO safetyRegulationsDTO) {
        SafetyRegulations safetyRegulations = safetyRegulationsService.save(safetyRegulationsDTO.convert(SafetyRegulations.class));
        return Result.ofAddSuccess(safetyRegulations.convert(SafetyRegulationsVO.class));
    }

    @Override
    public Result<SafetyRegulationsVO> update(@ApiParam(value = "安全生产规定id", required = true) @PathVariable String id,
        @ApiParam(value = "安全生产规定 DTO", required = true) @RequestBody @Validated SafetyRegulationsDTO safetyRegulationsDTO) {
        Optional<SafetyRegulations> safetyRegulationsOptional = safetyRegulationsService.findOptionalById(id);
        if (!safetyRegulationsOptional.isPresent()) {
            return Result.ofLost();
        }
        SafetyRegulations safetyRegulations = safetyRegulationsOptional.get();
        BeanUtils.copyProperties(safetyRegulationsDTO, safetyRegulations);
        safetyRegulations = safetyRegulationsService.save(safetyRegulations);
        return Result.ofUpdateSuccess(safetyRegulations.convert(SafetyRegulationsVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "安全生产规定id", required = true) @PathVariable String id) {
        safetyRegulationsService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SafetyRegulationsVO>> list(@ApiParam(value = "安全生产规定查询条件", required = true) @RequestBody SafetyRegulationsSearchable safetyRegulationsSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<SafetyRegulations> safetyRegulationsList = safetyRegulationsService.findAll(safetyRegulationsSearchable, sort);
        List<SafetyRegulationsVO> safetyRegulationsVOList = SafetyRegulations.convert(safetyRegulationsList, SafetyRegulationsVO.class);
        return Result.of(safetyRegulationsVOList);
    }

    @Override
    public Result<Page<SafetyRegulationsVO>> page(@ApiParam(value = "安全生产规定查询条件", required = true) @RequestBody SafetyRegulationsSearchable safetyRegulationsSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SafetyRegulations> safetyRegulationsPage = safetyRegulationsService.findAll(safetyRegulationsSearchable, pageable);
        Page<SafetyRegulationsVO> safetyRegulationsVOPage = SafetyRegulations.convert(safetyRegulationsPage, SafetyRegulationsVO.class);
        return Result.of(safetyRegulationsVOPage);
    }

}