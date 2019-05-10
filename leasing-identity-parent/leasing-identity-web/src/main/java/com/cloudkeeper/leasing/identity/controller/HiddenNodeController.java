package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.identity.dto.hiddennode.HiddenNodeDTO;
import com.cloudkeeper.leasing.identity.dto.hiddennode.HiddenNodeSearchable;
import com.cloudkeeper.leasing.identity.vo.HiddenNodeVO;
import com.cloudkeeper.leasing.base.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 隐患节点信息 controller
 * @author lxw
 */
@Api(value = "隐患节点信息", tags = "隐患节点信息")
@RequestMapping("/hiddenNode")
public interface HiddenNodeController {

    /**
     * 查询
     * @param id 隐患节点信息id
     * @return 隐患节点信息 VO
     */
    @ApiOperation(value = "查询", notes = "查询", position = 1)
    @GetMapping("/{id}id")
    Result<HiddenNodeVO> findOne(@ApiParam(value = "隐患节点信息id", required = true) @PathVariable String id);

    /**
     * 新增
     * @param hiddenNodeDTO 隐患节点信息 DTO
     * @return 隐患节点信息 VO
     */
    @ApiOperation(value = "新增", notes = "新增", position = 2)
    @PostMapping("/")
    Result<HiddenNodeVO> add(@ApiParam(value = "隐患节点信息 DTO", required = true) @RequestBody @Validated HiddenNodeDTO hiddenNodeDTO);

    /**
     * 更新
     * @param id 隐患节点信息id
     * @param hiddenNodeDTO 隐患节点信息 DTO
     * @return 隐患节点信息 VO
     */
    @ApiOperation(value = "更新", notes = "更新", position = 3)
    @PutMapping("/{id}id")
    Result<HiddenNodeVO> update(@ApiParam(value = "隐患节点信息id", required = true) @PathVariable String id,
        @ApiParam(value = "隐患节点信息 DTO", required = true) @RequestBody @Validated HiddenNodeDTO hiddenNodeDTO);

    /**
     * 删除
     * @param id 隐患节点信息id
     * @return 删除结果
     */
    @ApiOperation(value = "删除", notes = "删除", position = 4)
    @DeleteMapping("/{id}id")
    Result delete(@ApiParam(value = "隐患节点信息id", required = true) @PathVariable String id);

    /**
     * 列表查询
     * @param hiddenNodeSearchable 隐患节点信息查询条件
     * @param sort 排序条件
     * @return 隐患节点信息 VO 集合
     */
    @ApiOperation(value = "列表查询", notes = "列表查询<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 5)
    @PostMapping("/list")
    Result<List<HiddenNodeVO>> list(@ApiParam(value = "隐患节点信息查询条件", required = true) @RequestBody HiddenNodeSearchable hiddenNodeSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort);

    /**
     * 分页查询
     * @param hiddenNodeSearchable 隐患节点信息查询条件
     * @param pageable 分页条件
     * @return 隐患节点信息 VO 分页
     */
    @ApiOperation(value = "分页查询", notes = "分页查询<br/>page：第几页，默认为0，是第一页<br/>size：分页大小, 默认为10<br/>sort：排序字段，默认是asc排序方式，可以不写，格式：sort=code,asc&sort=name&sort=note,desc", position = 6)
    @PostMapping("/page")
    Result<Page<HiddenNodeVO>> page(@ApiParam(value = "隐患节点信息查询条件", required = true) @RequestBody HiddenNodeSearchable hiddenNodeSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable);

}