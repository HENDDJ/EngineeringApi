package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.HikRegionController;
import com.cloudkeeper.leasing.identity.domain.HikRegion;
import com.cloudkeeper.leasing.identity.dto.hikregion.HikRegionDTO;
import com.cloudkeeper.leasing.identity.dto.hikregion.HikRegionSearchable;
import com.cloudkeeper.leasing.identity.service.HikRegionService;
import com.cloudkeeper.leasing.identity.vo.HikRegionVO;
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
 * 海康区域 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HikRegionControllerImpl implements HikRegionController {

    /** 海康区域 service */
    private final HikRegionService hikRegionService;

    @Override
    public Result<HikRegionVO> findOne(@ApiParam(value = "海康区域id", required = true) @PathVariable String id) {
        Optional<HikRegion> hikRegionOptional = hikRegionService.findOptionalById(id);
        return hikRegionOptional.map(hikRegion -> Result.of(hikRegion.convert(HikRegionVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<HikRegionVO> add(@ApiParam(value = "海康区域 DTO", required = true) @RequestBody @Validated HikRegionDTO hikRegionDTO) {
        HikRegion hikRegion = hikRegionService.save(hikRegionDTO.convert(HikRegion.class));
        return Result.ofAddSuccess(hikRegion.convert(HikRegionVO.class));
    }

    @Override
    public Result<HikRegionVO> update(@ApiParam(value = "海康区域id", required = true) @PathVariable String id,
        @ApiParam(value = "海康区域 DTO", required = true) @RequestBody @Validated HikRegionDTO hikRegionDTO) {
        Optional<HikRegion> hikRegionOptional = hikRegionService.findOptionalById(id);
        if (!hikRegionOptional.isPresent()) {
            return Result.ofLost();
        }
        HikRegion hikRegion = hikRegionOptional.get();
        BeanUtils.copyProperties(hikRegionDTO, hikRegion);
        hikRegion = hikRegionService.save(hikRegion);
        return Result.ofUpdateSuccess(hikRegion.convert(HikRegionVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "海康区域id", required = true) @PathVariable String id) {
        hikRegionService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<HikRegionVO>> list(@ApiParam(value = "海康区域查询条件", required = true) @RequestBody HikRegionSearchable hikRegionSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<HikRegion> hikRegionList = hikRegionService.findAll(hikRegionSearchable, sort);
        List<HikRegionVO> hikRegionVOList = HikRegion.convert(hikRegionList, HikRegionVO.class);
        return Result.of(hikRegionVOList);
    }

    @Override
    public Result<Page<HikRegionVO>> page(@ApiParam(value = "海康区域查询条件", required = true) @RequestBody HikRegionSearchable hikRegionSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<HikRegion> hikRegionPage = hikRegionService.findAll(hikRegionSearchable, pageable);
        Page<HikRegionVO> hikRegionVOPage = HikRegion.convert(hikRegionPage, HikRegionVO.class);
        return Result.of(hikRegionVOPage);
    }

}