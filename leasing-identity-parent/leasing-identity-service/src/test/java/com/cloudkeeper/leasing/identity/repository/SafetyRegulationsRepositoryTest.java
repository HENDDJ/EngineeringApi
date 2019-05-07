package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.SafetyRegulations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 安全生产规定 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SafetyRegulationsRepositoryTest {

    /** 安全生产规定 repository */
    @Autowired
    private SafetyRegulationsRepository safetyRegulationsRepository;

    @Test
    public void saveTest() {
        SafetyRegulations safetyRegulations = new SafetyRegulations();
        safetyRegulations = safetyRegulationsRepository.save(safetyRegulations);
        assertNotNull(safetyRegulations.getId());
    }

}