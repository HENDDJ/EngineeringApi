package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.EmergencyAccidentHandle;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 应急事故处理方案 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmergencyAccidentHandleServiceTest {

    /** 应急事故处理方案 service */
    @Autowired
    private EmergencyAccidentHandleService emergencyAccidentHandleService;

    @Test
    public void saveTest() {
        EmergencyAccidentHandle emergencyAccidentHandle = new EmergencyAccidentHandle();
        emergencyAccidentHandle = emergencyAccidentHandleService.save(emergencyAccidentHandle);
        assertNotNull(emergencyAccidentHandle.getId());
    }

}