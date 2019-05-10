package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.HiddenHandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 隐患处理结果 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HiddenHandleRepositoryTest {

    /** 隐患处理结果 repository */
    @Autowired
    private HiddenHandleRepository hiddenHandleRepository;

    @Test
    public void saveTest() {
        HiddenHandle hiddenHandle = new HiddenHandle();
        hiddenHandle = hiddenHandleRepository.save(hiddenHandle);
        assertNotNull(hiddenHandle.getId());
    }

}