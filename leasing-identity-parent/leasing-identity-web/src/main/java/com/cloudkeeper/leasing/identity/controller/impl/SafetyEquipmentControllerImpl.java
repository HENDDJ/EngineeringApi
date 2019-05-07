package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SafetyEquipmentController;
import com.cloudkeeper.leasing.identity.domain.SafetyEquipment;
import com.cloudkeeper.leasing.identity.dto.safetyequipment.SafetyEquipmentDTO;
import com.cloudkeeper.leasing.identity.dto.safetyequipment.SafetyEquipmentSearchable;
import com.cloudkeeper.leasing.identity.service.SafetyEquipmentService;
import com.cloudkeeper.leasing.identity.vo.SafetyEquipmentVO;
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
 * 特种设备信息 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SafetyEquipmentControllerImpl implements SafetyEquipmentController {

    /** 特种设备信息 service */
    private final SafetyEquipmentService safetyEquipmentService;

    @Override
    public Result<SafetyEquipmentVO> findOne(@ApiParam(value = "特种设备信息id", required = true) @PathVariable String id) {
        Optional<SafetyEquipment> safetyEquipmentOptional = safetyEquipmentService.findOptionalById(id);
        return safetyEquipmentOptional.map(safetyEquipment -> Result.of(safetyEquipment.convert(SafetyEquipmentVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SafetyEquipmentVO> add(@ApiParam(value = "特种设备信息 DTO", required = true) @RequestBody @Validated SafetyEquipmentDTO safetyEquipmentDTO) {
        SafetyEquipment safetyEquipment = safetyEquipmentService.save(safetyEquipmentDTO.convert(SafetyEquipment.class));
        return Result.ofAddSuccess(safetyEquipment.convert(SafetyEquipmentVO.class));
    }

    @Override
    public Result<SafetyEquipmentVO> update(@ApiParam(value = "特种设备信息id", required = true) @PathVariable String id,
        @ApiParam(value = "特种设备信息 DTO", required = true) @RequestBody @Validated SafetyEquipmentDTO safetyEquipmentDTO) {
        Optional<SafetyEquipment> safetyEquipmentOptional = safetyEquipmentService.findOptionalById(id);
        if (!safetyEquipmentOptional.isPresent()) {
            return Result.ofLost();
        }
        SafetyEquipment safetyEquipment = safetyEquipmentOptional.get();
        BeanUtils.copyProperties(safetyEquipmentDTO, safetyEquipment);
        safetyEquipment = safetyEquipmentService.save(safetyEquipment);
        return Result.ofUpdateSuccess(safetyEquipment.convert(SafetyEquipmentVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "特种设备信息id", required = true) @PathVariable String id) {
        safetyEquipmentService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SafetyEquipmentVO>> list(@ApiParam(value = "特种设备信息查询条件", required = true) @RequestBody SafetyEquipmentSearchable safetyEquipmentSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<SafetyEquipment> safetyEquipmentList = safetyEquipmentService.findAll(safetyEquipmentSearchable, sort);
        List<SafetyEquipmentVO> safetyEquipmentVOList = SafetyEquipment.convert(safetyEquipmentList, SafetyEquipmentVO.class);
        return Result.of(safetyEquipmentVOList);
    }

    @Override
    public Result<Page<SafetyEquipmentVO>> page(@ApiParam(value = "特种设备信息查询条件", required = true) @RequestBody SafetyEquipmentSearchable safetyEquipmentSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SafetyEquipment> safetyEquipmentPage = safetyEquipmentService.findAll(safetyEquipmentSearchable, pageable);
        Page<SafetyEquipmentVO> safetyEquipmentVOPage = SafetyEquipment.convert(safetyEquipmentPage, SafetyEquipmentVO.class);
        return Result.of(safetyEquipmentVOPage);
    }

}