package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.HiddenRecords;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 隐患流程记录 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HiddenRecordsRepositoryTest {

    /** 隐患流程记录 repository */
    @Autowired
    private HiddenRecordsRepository hiddenRecordsRepository;

    @Test
    public void saveTest() {
        HiddenRecords hiddenRecords = new HiddenRecords();
        hiddenRecords = hiddenRecordsRepository.save(hiddenRecords);
        assertNotNull(hiddenRecords.getId());
    }

}