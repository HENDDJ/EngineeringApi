package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.HiddenNode;
import com.cloudkeeper.leasing.identity.repository.HiddenNodeRepository;
import com.cloudkeeper.leasing.identity.service.HiddenNodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 隐患节点信息 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HiddenNodeServiceImpl extends BaseServiceImpl<HiddenNode> implements HiddenNodeService {

    /** 隐患节点信息 repository */
    private final HiddenNodeRepository hiddenNodeRepository;

    @Override
    protected BaseRepository<HiddenNode> getBaseRepository() {
        return hiddenNodeRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("nodeDescript", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}