package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.EmergencyAccidentResultController;
import com.cloudkeeper.leasing.identity.domain.EmergencyAccidentResult;
import com.cloudkeeper.leasing.identity.dto.emergencyaccidentresult.EmergencyAccidentResultDTO;
import com.cloudkeeper.leasing.identity.dto.emergencyaccidentresult.EmergencyAccidentResultSearchable;
import com.cloudkeeper.leasing.identity.service.EmergencyAccidentResultService;
import com.cloudkeeper.leasing.identity.vo.EmergencyAccidentResultVO;
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
 * 应急事故处理结果 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmergencyAccidentResultControllerImpl implements EmergencyAccidentResultController {

    /** 应急事故处理结果 service */
    private final EmergencyAccidentResultService emergencyAccidentResultService;

    @Override
    public Result<EmergencyAccidentResultVO> findOne(@ApiParam(value = "应急事故处理结果id", required = true) @PathVariable String id) {
        Optional<EmergencyAccidentResult> emergencyAccidentResultOptional = emergencyAccidentResultService.findOptionalById(id);
        return emergencyAccidentResultOptional.map(emergencyAccidentResult -> Result.of(emergencyAccidentResult.convert(EmergencyAccidentResultVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<EmergencyAccidentResultVO> add(@ApiParam(value = "应急事故处理结果 DTO", required = true) @RequestBody @Validated EmergencyAccidentResultDTO emergencyAccidentResultDTO) {
        EmergencyAccidentResult emergencyAccidentResult = emergencyAccidentResultService.save(emergencyAccidentResultDTO.convert(EmergencyAccidentResult.class));
        return Result.ofAddSuccess(emergencyAccidentResult.convert(EmergencyAccidentResultVO.class));
    }

    @Override
    public Result<EmergencyAccidentResultVO> update(@ApiParam(value = "应急事故处理结果id", required = true) @PathVariable String id,
        @ApiParam(value = "应急事故处理结果 DTO", required = true) @RequestBody @Validated EmergencyAccidentResultDTO emergencyAccidentResultDTO) {
        Optional<EmergencyAccidentResult> emergencyAccidentResultOptional = emergencyAccidentResultService.findOptionalById(id);
        if (!emergencyAccidentResultOptional.isPresent()) {
            return Result.ofLost();
        }
        EmergencyAccidentResult emergencyAccidentResult = emergencyAccidentResultOptional.get();
        BeanUtils.copyProperties(emergencyAccidentResultDTO, emergencyAccidentResult);
        emergencyAccidentResult = emergencyAccidentResultService.save(emergencyAccidentResult);
        return Result.ofUpdateSuccess(emergencyAccidentResult.convert(EmergencyAccidentResultVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "应急事故处理结果id", required = true) @PathVariable String id) {
        emergencyAccidentResultService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<EmergencyAccidentResultVO>> list(@ApiParam(value = "应急事故处理结果查询条件", required = true) @RequestBody EmergencyAccidentResultSearchable emergencyAccidentResultSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<EmergencyAccidentResult> emergencyAccidentResultList = emergencyAccidentResultService.findAll(emergencyAccidentResultSearchable, sort);
        List<EmergencyAccidentResultVO> emergencyAccidentResultVOList = EmergencyAccidentResult.convert(emergencyAccidentResultList, EmergencyAccidentResultVO.class);
        return Result.of(emergencyAccidentResultVOList);
    }

    @Override
    public Result<Page<EmergencyAccidentResultVO>> page(@ApiParam(value = "应急事故处理结果查询条件", required = true) @RequestBody EmergencyAccidentResultSearchable emergencyAccidentResultSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<EmergencyAccidentResult> emergencyAccidentResultPage = emergencyAccidentResultService.findAll(emergencyAccidentResultSearchable, pageable);
        Page<EmergencyAccidentResultVO> emergencyAccidentResultVOPage = EmergencyAccidentResult.convert(emergencyAccidentResultPage, EmergencyAccidentResultVO.class);
        return Result.of(emergencyAccidentResultVOPage);
    }

}