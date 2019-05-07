package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.PreWarning;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 预警信息 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PreWarningServiceTest {

    /** 预警信息 service */
    @Autowired
    private PreWarningService preWarningService;

    @Test
    public void saveTest() {
        PreWarning preWarning = new PreWarning();
        preWarning = preWarningService.save(preWarning);
        assertNotNull(preWarning.getId());
    }

}