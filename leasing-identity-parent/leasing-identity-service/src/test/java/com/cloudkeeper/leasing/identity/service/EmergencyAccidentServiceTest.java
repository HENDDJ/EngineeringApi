package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.EmergencyAccident;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 应急事故 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmergencyAccidentServiceTest {

    /** 应急事故 service */
    @Autowired
    private EmergencyAccidentService emergencyAccidentService;

    @Test
    public void saveTest() {
        EmergencyAccident emergencyAccident = new EmergencyAccident();
        emergencyAccident = emergencyAccidentService.save(emergencyAccident);
        assertNotNull(emergencyAccident.getId());
    }

}