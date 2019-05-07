package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.EmergencyPreventionController;
import com.cloudkeeper.leasing.identity.domain.EmergencyPrevention;
import com.cloudkeeper.leasing.identity.dto.emergencyprevention.EmergencyPreventionDTO;
import com.cloudkeeper.leasing.identity.dto.emergencyprevention.EmergencyPreventionSearchable;
import com.cloudkeeper.leasing.identity.service.EmergencyPreventionService;
import com.cloudkeeper.leasing.identity.vo.EmergencyPreventionVO;
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
 * 应急预防与准备 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmergencyPreventionControllerImpl implements EmergencyPreventionController {

    /** 应急预防与准备 service */
    private final EmergencyPreventionService emergencyPreventionService;

    @Override
    public Result<EmergencyPreventionVO> findOne(@ApiParam(value = "应急预防与准备id", required = true) @PathVariable String id) {
        Optional<EmergencyPrevention> emergencyPreventionOptional = emergencyPreventionService.findOptionalById(id);
        return emergencyPreventionOptional.map(emergencyPrevention -> Result.of(emergencyPrevention.convert(EmergencyPreventionVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<EmergencyPreventionVO> add(@ApiParam(value = "应急预防与准备 DTO", required = true) @RequestBody @Validated EmergencyPreventionDTO emergencyPreventionDTO) {
        EmergencyPrevention emergencyPrevention = emergencyPreventionService.save(emergencyPreventionDTO.convert(EmergencyPrevention.class));
        return Result.ofAddSuccess(emergencyPrevention.convert(EmergencyPreventionVO.class));
    }

    @Override
    public Result<EmergencyPreventionVO> update(@ApiParam(value = "应急预防与准备id", required = true) @PathVariable String id,
        @ApiParam(value = "应急预防与准备 DTO", required = true) @RequestBody @Validated EmergencyPreventionDTO emergencyPreventionDTO) {
        Optional<EmergencyPrevention> emergencyPreventionOptional = emergencyPreventionService.findOptionalById(id);
        if (!emergencyPreventionOptional.isPresent()) {
            return Result.ofLost();
        }
        EmergencyPrevention emergencyPrevention = emergencyPreventionOptional.get();
        BeanUtils.copyProperties(emergencyPreventionDTO, emergencyPrevention);
        emergencyPrevention = emergencyPreventionService.save(emergencyPrevention);
        return Result.ofUpdateSuccess(emergencyPrevention.convert(EmergencyPreventionVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "应急预防与准备id", required = true) @PathVariable String id) {
        emergencyPreventionService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<EmergencyPreventionVO>> list(@ApiParam(value = "应急预防与准备查询条件", required = true) @RequestBody EmergencyPreventionSearchable emergencyPreventionSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<EmergencyPrevention> emergencyPreventionList = emergencyPreventionService.findAll(emergencyPreventionSearchable, sort);
        List<EmergencyPreventionVO> emergencyPreventionVOList = EmergencyPrevention.convert(emergencyPreventionList, EmergencyPreventionVO.class);
        return Result.of(emergencyPreventionVOList);
    }

    @Override
    public Result<Page<EmergencyPreventionVO>> page(@ApiParam(value = "应急预防与准备查询条件", required = true) @RequestBody EmergencyPreventionSearchable emergencyPreventionSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<EmergencyPrevention> emergencyPreventionPage = emergencyPreventionService.findAll(emergencyPreventionSearchable, pageable);
        Page<EmergencyPreventionVO> emergencyPreventionVOPage = EmergencyPrevention.convert(emergencyPreventionPage, EmergencyPreventionVO.class);
        return Result.of(emergencyPreventionVOPage);
    }

}