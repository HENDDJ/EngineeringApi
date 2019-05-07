package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.EmergencyPrevention;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 应急预防与准备 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmergencyPreventionServiceTest {

    /** 应急预防与准备 service */
    @Autowired
    private EmergencyPreventionService emergencyPreventionService;

    @Test
    public void saveTest() {
        EmergencyPrevention emergencyPrevention = new EmergencyPrevention();
        emergencyPrevention = emergencyPreventionService.save(emergencyPrevention);
        assertNotNull(emergencyPrevention.getId());
    }

}