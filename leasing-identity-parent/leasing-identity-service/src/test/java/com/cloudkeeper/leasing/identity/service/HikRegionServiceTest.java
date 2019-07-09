package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.HikRegion;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 海康区域 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HikRegionServiceTest {

    /** 海康区域 service */
    @Autowired
    private HikRegionService hikRegionService;

    @Test
    public void saveTest() {
        HikRegion hikRegion = new HikRegion();
        hikRegion = hikRegionService.save(hikRegion);
        assertNotNull(hikRegion.getId());
    }

}