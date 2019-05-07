package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.PatrolRecords;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 巡查记录 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PatrolRecordsServiceTest {

    /** 巡查记录 service */
    @Autowired
    private PatrolRecordsService patrolRecordsService;

    @Test
    public void saveTest() {
        PatrolRecords patrolRecords = new PatrolRecords();
        patrolRecords = patrolRecordsService.save(patrolRecords);
        assertNotNull(patrolRecords.getId());
    }

}