package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.EmergencyPrevention;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 应急预防与准备 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmergencyPreventionRepositoryTest {

    /** 应急预防与准备 repository */
    @Autowired
    private EmergencyPreventionRepository emergencyPreventionRepository;

    @Test
    public void saveTest() {
        EmergencyPrevention emergencyPrevention = new EmergencyPrevention();
        emergencyPrevention = emergencyPreventionRepository.save(emergencyPrevention);
        assertNotNull(emergencyPrevention.getId());
    }

}