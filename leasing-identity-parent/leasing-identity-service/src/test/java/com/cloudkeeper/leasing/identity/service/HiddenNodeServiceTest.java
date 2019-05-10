package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.HiddenNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 隐患节点信息 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HiddenNodeServiceTest {

    /** 隐患节点信息 service */
    @Autowired
    private HiddenNodeService hiddenNodeService;

    @Test
    public void saveTest() {
        HiddenNode hiddenNode = new HiddenNode();
        hiddenNode = hiddenNodeService.save(hiddenNode);
        assertNotNull(hiddenNode.getId());
    }

}