package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.PatrolRecordsController;
import com.cloudkeeper.leasing.identity.domain.PatrolRecords;
import com.cloudkeeper.leasing.identity.dto.patrolrecords.PatrolRecordsDTO;
import com.cloudkeeper.leasing.identity.dto.patrolrecords.PatrolRecordsSearchable;
import com.cloudkeeper.leasing.identity.service.PatrolRecordsService;
import com.cloudkeeper.leasing.identity.vo.PatrolRecordsVO;
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
 * 巡查记录 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PatrolRecordsControllerImpl implements PatrolRecordsController {

    /** 巡查记录 service */
    private final PatrolRecordsService patrolRecordsService;

    @Override
    public Result<PatrolRecordsVO> findOne(@ApiParam(value = "巡查记录id", required = true) @PathVariable String id) {
        Optional<PatrolRecords> patrolRecordsOptional = patrolRecordsService.findOptionalById(id);
        return patrolRecordsOptional.map(patrolRecords -> Result.of(patrolRecords.convert(PatrolRecordsVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<PatrolRecordsVO> add(@ApiParam(value = "巡查记录 DTO", required = true) @RequestBody @Validated PatrolRecordsDTO patrolRecordsDTO) {
        PatrolRecords patrolRecords = patrolRecordsService.save(patrolRecordsDTO.convert(PatrolRecords.class));
        return Result.ofAddSuccess(patrolRecords.convert(PatrolRecordsVO.class));
    }

    @Override
    public Result<PatrolRecordsVO> update(@ApiParam(value = "巡查记录id", required = true) @PathVariable String id,
        @ApiParam(value = "巡查记录 DTO", required = true) @RequestBody @Validated PatrolRecordsDTO patrolRecordsDTO) {
        Optional<PatrolRecords> patrolRecordsOptional = patrolRecordsService.findOptionalById(id);
        if (!patrolRecordsOptional.isPresent()) {
            return Result.ofLost();
        }
        PatrolRecords patrolRecords = patrolRecordsOptional.get();
        BeanUtils.copyProperties(patrolRecordsDTO, patrolRecords);
        patrolRecords = patrolRecordsService.save(patrolRecords);
        return Result.ofUpdateSuccess(patrolRecords.convert(PatrolRecordsVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "巡查记录id", required = true) @PathVariable String id) {
        patrolRecordsService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<PatrolRecordsVO>> list(@ApiParam(value = "巡查记录查询条件", required = true) @RequestBody PatrolRecordsSearchable patrolRecordsSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<PatrolRecords> patrolRecordsList = patrolRecordsService.findAll(patrolRecordsSearchable, sort);
        List<PatrolRecordsVO> patrolRecordsVOList = PatrolRecords.convert(patrolRecordsList, PatrolRecordsVO.class);
        return Result.of(patrolRecordsVOList);
    }

    @Override
    public Result<Page<PatrolRecordsVO>> page(@ApiParam(value = "巡查记录查询条件", required = true) @RequestBody PatrolRecordsSearchable patrolRecordsSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<PatrolRecords> patrolRecordsPage = patrolRecordsService.findAll(patrolRecordsSearchable, pageable);
        Page<PatrolRecordsVO> patrolRecordsVOPage = PatrolRecords.convert(patrolRecordsPage, PatrolRecordsVO.class);
        return Result.of(patrolRecordsVOPage);
    }

}