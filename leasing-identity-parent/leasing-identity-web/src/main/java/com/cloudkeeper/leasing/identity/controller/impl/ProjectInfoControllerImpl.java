package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.ProjectInfoController;
import com.cloudkeeper.leasing.identity.domain.ProjectInfo;
import com.cloudkeeper.leasing.identity.dto.projectinfo.ProjectInfoDTO;
import com.cloudkeeper.leasing.identity.dto.projectinfo.ProjectInfoSearchable;
import com.cloudkeeper.leasing.identity.service.ProjectInfoService;
import com.cloudkeeper.leasing.identity.vo.ProjectInfoVO;
import com.sun.net.httpserver.Authenticator;
import io.swagger.annotations.ApiParam;
import liquibase.util.StringUtils;
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
 * 工程信息类 controller
 * @author asher
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectInfoControllerImpl implements ProjectInfoController {

    /** 工程信息类 service */
    private final ProjectInfoService projectInfoService;

    @Override
    public Result<ProjectInfoVO> findOne(@ApiParam(value = "工程信息类id", required = true) @PathVariable String id) {
        Optional<ProjectInfo> projectInfoOptional = projectInfoService.findOptionalById(id);
        return projectInfoOptional.map(projectInfo -> Result.of(projectInfo.convert(ProjectInfoVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<ProjectInfoVO> add(@ApiParam(value = "工程信息类 DTO", required = true) @RequestBody @Validated ProjectInfoDTO projectInfoDTO) {
        ProjectInfo projectInfo = projectInfoService.save(projectInfoDTO.convert(ProjectInfo.class));
        return Result.ofAddSuccess(projectInfo.convert(ProjectInfoVO.class));
    }

    @Override
    public Result<ProjectInfoVO> update(@ApiParam(value = "工程信息类id", required = true) @PathVariable String id,
        @ApiParam(value = "工程信息类 DTO", required = true) @RequestBody @Validated ProjectInfoDTO projectInfoDTO) {
        Optional<ProjectInfo> projectInfoOptional = projectInfoService.findOptionalById(id);
        if (!projectInfoOptional.isPresent()) {
            return Result.ofLost();
        }
        ProjectInfo projectInfo = projectInfoOptional.get();
        BeanUtils.copyProperties(projectInfoDTO, projectInfo);
        projectInfo = projectInfoService.save(projectInfo);
        return Result.ofUpdateSuccess(projectInfo.convert(ProjectInfoVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "工程信息类id", required = true) @PathVariable String id) {
        projectInfoService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<ProjectInfoVO>> list(@ApiParam(value = "工程信息类查询条件", required = true) @RequestBody ProjectInfoSearchable projectInfoSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<ProjectInfo> projectInfoList = projectInfoService.findAll(projectInfoSearchable, sort);
        List<ProjectInfoVO> projectInfoVOList = ProjectInfo.convert(projectInfoList, ProjectInfoVO.class);
        return Result.of(projectInfoVOList);
    }

    @Override
    public Result<Page<ProjectInfoVO>> page(@ApiParam(value = "工程信息类查询条件", required = true) @RequestBody ProjectInfoSearchable projectInfoSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<ProjectInfo> projectInfoPage = projectInfoService.findAll(projectInfoSearchable, pageable);
        Page<ProjectInfoVO> projectInfoVOPage = ProjectInfo.convert(projectInfoPage, ProjectInfoVO.class);
        return Result.of(projectInfoVOPage);
    }

    @Override
    public void updateAll() {
        double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
        List<ProjectInfo> list = projectInfoService.findAll();
        ProjectInfo projectInfo = new ProjectInfo();
        for(int i=0; i<list.size(); i++){
            projectInfo = list.get(i);
            if(StringUtils.isEmpty(projectInfo.getLatitude())) {
                continue;
            }else{
                double lng = Double.valueOf(projectInfo.getLongitude());
                double lat = Double.valueOf(projectInfo.getLatitude());
                double z = Math.sqrt(lng * lng + lat * lat) + 0.00002 * Math.sin(lat * x_PI);
                double theta = Math.atan2(lat, lng) + 0.000003 * Math.cos(lng * x_PI);
                projectInfo.setLongitude(String.valueOf( z * Math.cos(theta) + 0.0065));
                projectInfo.setLatitude(String.valueOf( z * Math.sin(theta) + 0.006));
                projectInfoService.save(projectInfo);
            }

        }
    }

}