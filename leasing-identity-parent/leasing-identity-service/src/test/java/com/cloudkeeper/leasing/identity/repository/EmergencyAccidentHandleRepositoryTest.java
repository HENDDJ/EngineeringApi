package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.EmergencyAccidentHandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 应急事故处理方案 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmergencyAccidentHandleRepositoryTest {

    /** 应急事故处理方案 repository */
    @Autowired
    private EmergencyAccidentHandleRepository emergencyAccidentHandleRepository;

    @Test
    public void saveTest() {
        EmergencyAccidentHandle emergencyAccidentHandle = new EmergencyAccidentHandle();
        emergencyAccidentHandle = emergencyAccidentHandleRepository.save(emergencyAccidentHandle);
        assertNotNull(emergencyAccidentHandle.getId());
    }

}