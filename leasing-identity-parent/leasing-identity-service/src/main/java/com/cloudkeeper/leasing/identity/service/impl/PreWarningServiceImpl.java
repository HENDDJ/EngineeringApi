package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.PreWarning;
import com.cloudkeeper.leasing.identity.repository.PreWarningRepository;
import com.cloudkeeper.leasing.identity.service.PreWarningService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 预警信息 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PreWarningServiceImpl extends BaseServiceImpl<PreWarning> implements PreWarningService {

    /** 预警信息 repository */
    private final PreWarningRepository preWarningRepository;

    @Override
    protected BaseRepository<PreWarning> getBaseRepository() {
        return preWarningRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("warnDescribe", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}