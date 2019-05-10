package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.HiddenIssue;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 隐患信息 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HiddenIssueServiceTest {

    /** 隐患信息 service */
    @Autowired
    private HiddenIssueService hiddenIssueService;

    @Test
    public void saveTest() {
        HiddenIssue hiddenIssue = new HiddenIssue();
        hiddenIssue = hiddenIssueService.save(hiddenIssue);
        assertNotNull(hiddenIssue.getId());
    }

}