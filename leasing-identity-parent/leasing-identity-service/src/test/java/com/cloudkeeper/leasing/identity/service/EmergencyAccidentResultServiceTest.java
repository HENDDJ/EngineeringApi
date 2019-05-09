package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.EmergencyAccidentResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 应急事故处理结果 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmergencyAccidentResultServiceTest {

    /** 应急事故处理结果 service */
    @Autowired
    private EmergencyAccidentResultService emergencyAccidentResultService;

    @Test
    public void saveTest() {
        EmergencyAccidentResult emergencyAccidentResult = new EmergencyAccidentResult();
        emergencyAccidentResult = emergencyAccidentResultService.save(emergencyAccidentResult);
        assertNotNull(emergencyAccidentResult.getId());
    }

}