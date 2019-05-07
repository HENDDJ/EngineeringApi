package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.SafetyMode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 安全生产方式 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SafetyModeServiceTest {

    /** 安全生产方式 service */
    @Autowired
    private SafetyModeService safetyModeService;

    @Test
    public void saveTest() {
        SafetyMode safetyMode = new SafetyMode();
        safetyMode = safetyModeService.save(safetyMode);
        assertNotNull(safetyMode.getId());
    }

}