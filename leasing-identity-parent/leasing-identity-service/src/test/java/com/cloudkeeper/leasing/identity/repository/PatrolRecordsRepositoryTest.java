package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.PatrolRecords;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 巡查记录 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PatrolRecordsRepositoryTest {

    /** 巡查记录 repository */
    @Autowired
    private PatrolRecordsRepository patrolRecordsRepository;

    @Test
    public void saveTest() {
        PatrolRecords patrolRecords = new PatrolRecords();
        patrolRecords = patrolRecordsRepository.save(patrolRecords);
        assertNotNull(patrolRecords.getId());
    }

}