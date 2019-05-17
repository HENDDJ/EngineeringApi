package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.ProjectInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 工程信息类 service 测试
 * @author asher
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProjectInfoServiceTest {

    /** 工程信息类 service */
    @Autowired
    private ProjectInfoService projectInfoService;

    @Test
    public void saveTest() {
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo = projectInfoService.save(projectInfo);
        assertNotNull(projectInfo.getId());
    }

    @Test
    public void change() {
        double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
        double PI = 3.1415926535897932384626;
        double a = 6378245.0;
        double ee = 0.00669342162296594323;
        List<ProjectInfo> list = projectInfoService.findAll();
        for(int i=0; i<list.size(); i++){
            ProjectInfo projectInfo = list.get(i);
            if(projectInfo.getLatitude()=="暂未获取地址"){
                return ;
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