package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.MajorHazards;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 重大危险源 service 测试
 * @author cqh
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MajorHazardsServiceTest {

    /** 重大危险源 service */
    @Autowired
    private MajorHazardsService majorHazardsService;

    @Test
    public void saveTest() {
        MajorHazards majorHazards = new MajorHazards();
        majorHazards = majorHazardsService.save(majorHazards);
        assertNotNull(majorHazards.getId());
    }

}