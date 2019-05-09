package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.EmergencyAccidentController;
import com.cloudkeeper.leasing.identity.domain.EmergencyAccident;
import com.cloudkeeper.leasing.identity.dto.emergencyaccident.EmergencyAccidentDTO;
import com.cloudkeeper.leasing.identity.dto.emergencyaccident.EmergencyAccidentSearchable;
import com.cloudkeeper.leasing.identity.service.EmergencyAccidentService;
import com.cloudkeeper.leasing.identity.vo.EmergencyAccidentVO;
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
 * 应急事故 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmergencyAccidentControllerImpl implements EmergencyAccidentController {

    /** 应急事故 service */
    private final EmergencyAccidentService emergencyAccidentService;

    @Override
    public Result<EmergencyAccidentVO> findOne(@ApiParam(value = "应急事故id", required = true) @PathVariable String id) {
        Optional<EmergencyAccident> emergencyAccidentOptional = emergencyAccidentService.findOptionalById(id);
        return emergencyAccidentOptional.map(emergencyAccident -> Result.of(emergencyAccident.convert(EmergencyAccidentVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<EmergencyAccidentVO> add(@ApiParam(value = "应急事故 DTO", required = true) @RequestBody @Validated EmergencyAccidentDTO emergencyAccidentDTO) {
        EmergencyAccident emergencyAccident = emergencyAccidentService.save(emergencyAccidentDTO.convert(EmergencyAccident.class));
        return Result.ofAddSuccess(emergencyAccident.convert(EmergencyAccidentVO.class));
    }

    @Override
    public Result<EmergencyAccidentVO> update(@ApiParam(value = "应急事故id", required = true) @PathVariable String id,
        @ApiParam(value = "应急事故 DTO", required = true) @RequestBody @Validated EmergencyAccidentDTO emergencyAccidentDTO) {
        Optional<EmergencyAccident> emergencyAccidentOptional = emergencyAccidentService.findOptionalById(id);
        if (!emergencyAccidentOptional.isPresent()) {
            return Result.ofLost();
        }
        EmergencyAccident emergencyAccident = emergencyAccidentOptional.get();
        BeanUtils.copyProperties(emergencyAccidentDTO, emergencyAccident);
        emergencyAccident = emergencyAccidentService.save(emergencyAccident);
        return Result.ofUpdateSuccess(emergencyAccident.convert(EmergencyAccidentVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "应急事故id", required = true) @PathVariable String id) {
        emergencyAccidentService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<EmergencyAccidentVO>> list(@ApiParam(value = "应急事故查询条件", required = true) @RequestBody EmergencyAccidentSearchable emergencyAccidentSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<EmergencyAccident> emergencyAccidentList = emergencyAccidentService.findAll(emergencyAccidentSearchable, sort);
        List<EmergencyAccidentVO> emergencyAccidentVOList = EmergencyAccident.convert(emergencyAccidentList, EmergencyAccidentVO.class);
        return Result.of(emergencyAccidentVOList);
    }

    @Override
    public Result<Page<EmergencyAccidentVO>> page(@ApiParam(value = "应急事故查询条件", required = true) @RequestBody EmergencyAccidentSearchable emergencyAccidentSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<EmergencyAccident> emergencyAccidentPage = emergencyAccidentService.findAll(emergencyAccidentSearchable, pageable);
        Page<EmergencyAccidentVO> emergencyAccidentVOPage = EmergencyAccident.convert(emergencyAccidentPage, EmergencyAccidentVO.class);
        return Result.of(emergencyAccidentVOPage);
    }

}