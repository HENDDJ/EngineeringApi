package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.SafetyRegulations;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 安全生产规定 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SafetyRegulationsServiceTest {

    /** 安全生产规定 service */
    @Autowired
    private SafetyRegulationsService safetyRegulationsService;

    @Test
    public void saveTest() {
        SafetyRegulations safetyRegulations = new SafetyRegulations();
        safetyRegulations = safetyRegulationsService.save(safetyRegulations);
        assertNotNull(safetyRegulations.getId());
    }

}