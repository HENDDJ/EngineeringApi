package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.HikRegion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 海康区域 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HikRegionRepositoryTest {

    /** 海康区域 repository */
    @Autowired
    private HikRegionRepository hikRegionRepository;

    @Test
    public void saveTest() {
        HikRegion hikRegion = new HikRegion();
        hikRegion = hikRegionRepository.save(hikRegion);
        assertNotNull(hikRegion.getId());
    }

}