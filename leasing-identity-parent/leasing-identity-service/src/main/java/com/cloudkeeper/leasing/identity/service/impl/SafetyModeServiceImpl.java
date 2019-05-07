package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SafetyMode;
import com.cloudkeeper.leasing.identity.repository.SafetyModeRepository;
import com.cloudkeeper.leasing.identity.service.SafetyModeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 安全生产方式 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SafetyModeServiceImpl extends BaseServiceImpl<SafetyMode> implements SafetyModeService {

    /** 安全生产方式 repository */
    private final SafetyModeRepository safetyModeRepository;

    @Override
    protected BaseRepository<SafetyMode> getBaseRepository() {
        return safetyModeRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("descript", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("startTime", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("conveningOrg", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("enclosure", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}