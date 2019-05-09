package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.MajorHazards;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 重大危险源 repository 测试
 * @author cqh
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MajorHazardsRepositoryTest {

    /** 重大危险源 repository */
    @Autowired
    private MajorHazardsRepository majorHazardsRepository;

    @Test
    public void saveTest() {
        MajorHazards majorHazards = new MajorHazards();
        majorHazards = majorHazardsRepository.save(majorHazards);
        assertNotNull(majorHazards.getId());
    }

}