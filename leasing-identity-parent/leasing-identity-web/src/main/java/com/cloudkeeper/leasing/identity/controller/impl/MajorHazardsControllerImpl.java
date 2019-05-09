package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.MajorHazardsController;
import com.cloudkeeper.leasing.identity.domain.MajorHazards;
import com.cloudkeeper.leasing.identity.dto.majorhazards.MajorHazardsDTO;
import com.cloudkeeper.leasing.identity.dto.majorhazards.MajorHazardsSearchable;
import com.cloudkeeper.leasing.identity.service.MajorHazardsService;
import com.cloudkeeper.leasing.identity.vo.MajorHazardsVO;
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
 * 重大危险源 controller
 * @author cqh
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MajorHazardsControllerImpl implements MajorHazardsController {

    /** 重大危险源 service */
    private final MajorHazardsService majorHazardsService;

    @Override
    public Result<MajorHazardsVO> findOne(@ApiParam(value = "重大危险源id", required = true) @PathVariable String id) {
        Optional<MajorHazards> majorHazardsOptional = majorHazardsService.findOptionalById(id);
        return majorHazardsOptional.map(majorHazards -> Result.of(majorHazards.convert(MajorHazardsVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<MajorHazardsVO> add(@ApiParam(value = "重大危险源 DTO", required = true) @RequestBody @Validated MajorHazardsDTO majorHazardsDTO) {
        MajorHazards majorHazards = majorHazardsService.save(majorHazardsDTO.convert(MajorHazards.class));
        return Result.ofAddSuccess(majorHazards.convert(MajorHazardsVO.class));
    }

    @Override
    public Result<MajorHazardsVO> update(@ApiParam(value = "重大危险源id", required = true) @PathVariable String id,
        @ApiParam(value = "重大危险源 DTO", required = true) @RequestBody @Validated MajorHazardsDTO majorHazardsDTO) {
        Optional<MajorHazards> majorHazardsOptional = majorHazardsService.findOptionalById(id);
        if (!majorHazardsOptional.isPresent()) {
            return Result.ofLost();
        }
        MajorHazards majorHazards = majorHazardsOptional.get();
        BeanUtils.copyProperties(majorHazardsDTO, majorHazards);
        majorHazards = majorHazardsService.save(majorHazards);
        return Result.ofUpdateSuccess(majorHazards.convert(MajorHazardsVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "重大危险源id", required = true) @PathVariable String id) {
        majorHazardsService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<MajorHazardsVO>> list(@ApiParam(value = "重大危险源查询条件", required = true) @RequestBody MajorHazardsSearchable majorHazardsSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<MajorHazards> majorHazardsList = majorHazardsService.findAll(majorHazardsSearchable, sort);
        List<MajorHazardsVO> majorHazardsVOList = MajorHazards.convert(majorHazardsList, MajorHazardsVO.class);
        return Result.of(majorHazardsVOList);
    }

    @Override
    public Result<Page<MajorHazardsVO>> page(@ApiParam(value = "重大危险源查询条件", required = true) @RequestBody MajorHazardsSearchable majorHazardsSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<MajorHazards> majorHazardsPage = majorHazardsService.findAll(majorHazardsSearchable, pageable);
        Page<MajorHazardsVO> majorHazardsVOPage = MajorHazards.convert(majorHazardsPage, MajorHazardsVO.class);
        return Result.of(majorHazardsVOPage);
    }

}