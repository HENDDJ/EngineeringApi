package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.SafetyMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 安全生产方式 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SafetyModeRepositoryTest {

    /** 安全生产方式 repository */
    @Autowired
    private SafetyModeRepository safetyModeRepository;

    @Test
    public void saveTest() {
        SafetyMode safetyMode = new SafetyMode();
        safetyMode = safetyModeRepository.save(safetyMode);
        assertNotNull(safetyMode.getId());
    }

}