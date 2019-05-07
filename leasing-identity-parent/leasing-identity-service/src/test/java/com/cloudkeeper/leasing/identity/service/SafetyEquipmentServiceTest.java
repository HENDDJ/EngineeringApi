package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.SafetyEquipment;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 特种设备信息 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SafetyEquipmentServiceTest {

    /** 特种设备信息 service */
    @Autowired
    private SafetyEquipmentService safetyEquipmentService;

    @Test
    public void saveTest() {
        SafetyEquipment safetyEquipment = new SafetyEquipment();
        safetyEquipment = safetyEquipmentService.save(safetyEquipment);
        assertNotNull(safetyEquipment.getId());
    }

}