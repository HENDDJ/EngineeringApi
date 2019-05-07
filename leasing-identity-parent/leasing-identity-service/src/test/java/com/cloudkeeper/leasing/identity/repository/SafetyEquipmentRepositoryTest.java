package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.SafetyEquipment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 特种设备信息 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SafetyEquipmentRepositoryTest {

    /** 特种设备信息 repository */
    @Autowired
    private SafetyEquipmentRepository safetyEquipmentRepository;

    @Test
    public void saveTest() {
        SafetyEquipment safetyEquipment = new SafetyEquipment();
        safetyEquipment = safetyEquipmentRepository.save(safetyEquipment);
        assertNotNull(safetyEquipment.getId());
    }

}