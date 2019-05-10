package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.HiddenRecordsController;
import com.cloudkeeper.leasing.identity.domain.HiddenRecords;
import com.cloudkeeper.leasing.identity.dto.hiddenrecords.HiddenRecordsDTO;
import com.cloudkeeper.leasing.identity.dto.hiddenrecords.HiddenRecordsSearchable;
import com.cloudkeeper.leasing.identity.service.HiddenRecordsService;
import com.cloudkeeper.leasing.identity.vo.HiddenRecordsVO;
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
 * 隐患流程记录 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HiddenRecordsControllerImpl implements HiddenRecordsController {

    /** 隐患流程记录 service */
    private final HiddenRecordsService hiddenRecordsService;

    @Override
    public Result<HiddenRecordsVO> findOne(@ApiParam(value = "隐患流程记录id", required = true) @PathVariable String id) {
        Optional<HiddenRecords> hiddenRecordsOptional = hiddenRecordsService.findOptionalById(id);
        return hiddenRecordsOptional.map(hiddenRecords -> Result.of(hiddenRecords.convert(HiddenRecordsVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<HiddenRecordsVO> add(@ApiParam(value = "隐患流程记录 DTO", required = true) @RequestBody @Validated HiddenRecordsDTO hiddenRecordsDTO) {
        HiddenRecords hiddenRecords = hiddenRecordsService.save(hiddenRecordsDTO.convert(HiddenRecords.class));
        return Result.ofAddSuccess(hiddenRecords.convert(HiddenRecordsVO.class));
    }

    @Override
    public Result<HiddenRecordsVO> update(@ApiParam(value = "隐患流程记录id", required = true) @PathVariable String id,
        @ApiParam(value = "隐患流程记录 DTO", required = true) @RequestBody @Validated HiddenRecordsDTO hiddenRecordsDTO) {
        Optional<HiddenRecords> hiddenRecordsOptional = hiddenRecordsService.findOptionalById(id);
        if (!hiddenRecordsOptional.isPresent()) {
            return Result.ofLost();
        }
        HiddenRecords hiddenRecords = hiddenRecordsOptional.get();
        BeanUtils.copyProperties(hiddenRecordsDTO, hiddenRecords);
        hiddenRecords = hiddenRecordsService.save(hiddenRecords);
        return Result.ofUpdateSuccess(hiddenRecords.convert(HiddenRecordsVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "隐患流程记录id", required = true) @PathVariable String id) {
        hiddenRecordsService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<HiddenRecordsVO>> list(@ApiParam(value = "隐患流程记录查询条件", required = true) @RequestBody HiddenRecordsSearchable hiddenRecordsSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<HiddenRecords> hiddenRecordsList = hiddenRecordsService.findAll(hiddenRecordsSearchable, sort);
        List<HiddenRecordsVO> hiddenRecordsVOList = HiddenRecords.convert(hiddenRecordsList, HiddenRecordsVO.class);
        return Result.of(hiddenRecordsVOList);
    }

    @Override
    public Result<Page<HiddenRecordsVO>> page(@ApiParam(value = "隐患流程记录查询条件", required = true) @RequestBody HiddenRecordsSearchable hiddenRecordsSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<HiddenRecords> hiddenRecordsPage = hiddenRecordsService.findAll(hiddenRecordsSearchable, pageable);
        Page<HiddenRecordsVO> hiddenRecordsVOPage = HiddenRecords.convert(hiddenRecordsPage, HiddenRecordsVO.class);
        return Result.of(hiddenRecordsVOPage);
    }

}