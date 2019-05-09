package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.EmergencyAccidentHandleController;
import com.cloudkeeper.leasing.identity.domain.EmergencyAccidentHandle;
import com.cloudkeeper.leasing.identity.dto.emergencyaccidenthandle.EmergencyAccidentHandleDTO;
import com.cloudkeeper.leasing.identity.dto.emergencyaccidenthandle.EmergencyAccidentHandleSearchable;
import com.cloudkeeper.leasing.identity.service.EmergencyAccidentHandleService;
import com.cloudkeeper.leasing.identity.vo.EmergencyAccidentHandleVO;
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
 * 应急事故处理方案 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmergencyAccidentHandleControllerImpl implements EmergencyAccidentHandleController {

    /** 应急事故处理方案 service */
    private final EmergencyAccidentHandleService emergencyAccidentHandleService;

    @Override
    public Result<EmergencyAccidentHandleVO> findOne(@ApiParam(value = "应急事故处理方案id", required = true) @PathVariable String id) {
        Optional<EmergencyAccidentHandle> emergencyAccidentHandleOptional = emergencyAccidentHandleService.findOptionalById(id);
        return emergencyAccidentHandleOptional.map(emergencyAccidentHandle -> Result.of(emergencyAccidentHandle.convert(EmergencyAccidentHandleVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<EmergencyAccidentHandleVO> add(@ApiParam(value = "应急事故处理方案 DTO", required = true) @RequestBody @Validated EmergencyAccidentHandleDTO emergencyAccidentHandleDTO) {
        EmergencyAccidentHandle emergencyAccidentHandle = emergencyAccidentHandleService.save(emergencyAccidentHandleDTO.convert(EmergencyAccidentHandle.class));
        return Result.ofAddSuccess(emergencyAccidentHandle.convert(EmergencyAccidentHandleVO.class));
    }

    @Override
    public Result<EmergencyAccidentHandleVO> update(@ApiParam(value = "应急事故处理方案id", required = true) @PathVariable String id,
        @ApiParam(value = "应急事故处理方案 DTO", required = true) @RequestBody @Validated EmergencyAccidentHandleDTO emergencyAccidentHandleDTO) {
        Optional<EmergencyAccidentHandle> emergencyAccidentHandleOptional = emergencyAccidentHandleService.findOptionalById(id);
        if (!emergencyAccidentHandleOptional.isPresent()) {
            return Result.ofLost();
        }
        EmergencyAccidentHandle emergencyAccidentHandle = emergencyAccidentHandleOptional.get();
        BeanUtils.copyProperties(emergencyAccidentHandleDTO, emergencyAccidentHandle);
        emergencyAccidentHandle = emergencyAccidentHandleService.save(emergencyAccidentHandle);
        return Result.ofUpdateSuccess(emergencyAccidentHandle.convert(EmergencyAccidentHandleVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "应急事故处理方案id", required = true) @PathVariable String id) {
        emergencyAccidentHandleService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<EmergencyAccidentHandleVO>> list(@ApiParam(value = "应急事故处理方案查询条件", required = true) @RequestBody EmergencyAccidentHandleSearchable emergencyAccidentHandleSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<EmergencyAccidentHandle> emergencyAccidentHandleList = emergencyAccidentHandleService.findAll(emergencyAccidentHandleSearchable, sort);
        List<EmergencyAccidentHandleVO> emergencyAccidentHandleVOList = EmergencyAccidentHandle.convert(emergencyAccidentHandleList, EmergencyAccidentHandleVO.class);
        return Result.of(emergencyAccidentHandleVOList);
    }

    @Override
    public Result<Page<EmergencyAccidentHandleVO>> page(@ApiParam(value = "应急事故处理方案查询条件", required = true) @RequestBody EmergencyAccidentHandleSearchable emergencyAccidentHandleSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<EmergencyAccidentHandle> emergencyAccidentHandlePage = emergencyAccidentHandleService.findAll(emergencyAccidentHandleSearchable, pageable);
        Page<EmergencyAccidentHandleVO> emergencyAccidentHandleVOPage = EmergencyAccidentHandle.convert(emergencyAccidentHandlePage, EmergencyAccidentHandleVO.class);
        return Result.of(emergencyAccidentHandleVOPage);
    }

}