package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.HiddenRecords;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 隐患流程记录 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HiddenRecordsServiceTest {

    /** 隐患流程记录 service */
    @Autowired
    private HiddenRecordsService hiddenRecordsService;

    @Test
    public void saveTest() {
        HiddenRecords hiddenRecords = new HiddenRecords();
        hiddenRecords = hiddenRecordsService.save(hiddenRecords);
        assertNotNull(hiddenRecords.getId());
    }

}