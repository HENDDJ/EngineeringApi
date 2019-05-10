package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.HiddenHandle;
import com.cloudkeeper.leasing.identity.repository.HiddenHandleRepository;
import com.cloudkeeper.leasing.identity.service.HiddenHandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 隐患处理结果 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HiddenHandleServiceImpl extends BaseServiceImpl<HiddenHandle> implements HiddenHandleService {

    /** 隐患处理结果 repository */
    private final HiddenHandleRepository hiddenHandleRepository;

    @Override
    protected BaseRepository<HiddenHandle> getBaseRepository() {
        return hiddenHandleRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("solveImage", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("solveDes", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}