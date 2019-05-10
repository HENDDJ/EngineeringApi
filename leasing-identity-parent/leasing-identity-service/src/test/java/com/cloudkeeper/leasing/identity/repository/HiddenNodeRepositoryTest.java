package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.HiddenNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 隐患节点信息 repository 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HiddenNodeRepositoryTest {

    /** 隐患节点信息 repository */
    @Autowired
    private HiddenNodeRepository hiddenNodeRepository;

    @Test
    public void saveTest() {
        HiddenNode hiddenNode = new HiddenNode();
        hiddenNode = hiddenNodeRepository.save(hiddenNode);
        assertNotNull(hiddenNode.getId());
    }

}