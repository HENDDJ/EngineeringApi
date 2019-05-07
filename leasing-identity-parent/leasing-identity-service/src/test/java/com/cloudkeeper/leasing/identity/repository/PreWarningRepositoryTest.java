package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.PreWarning;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 预警信息 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PreWarningRepositoryTest {

    /** 预警信息 repository */
    @Autowired
    private PreWarningRepository preWarningRepository;

    @Test
    public void saveTest() {
        PreWarning preWarning = new PreWarning();
        preWarning = preWarningRepository.save(preWarning);
        assertNotNull(preWarning.getId());
    }

}