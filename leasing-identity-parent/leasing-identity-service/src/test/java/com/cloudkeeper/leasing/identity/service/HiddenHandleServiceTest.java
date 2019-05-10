package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.HiddenHandle;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 隐患处理结果 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HiddenHandleServiceTest {

    /** 隐患处理结果 service */
    @Autowired
    private HiddenHandleService hiddenHandleService;

    @Test
    public void saveTest() {
        HiddenHandle hiddenHandle = new HiddenHandle();
        hiddenHandle = hiddenHandleService.save(hiddenHandle);
        assertNotNull(hiddenHandle.getId());
    }

}