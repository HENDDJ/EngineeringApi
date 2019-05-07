package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SafetyRegulations;
import com.cloudkeeper.leasing.identity.repository.SafetyRegulationsRepository;
import com.cloudkeeper.leasing.identity.service.SafetyRegulationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 安全生产规定 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SafetyRegulationsServiceImpl extends BaseServiceImpl<SafetyRegulations> implements SafetyRegulationsService {

    /** 安全生产规定 repository */
    private final SafetyRegulationsRepository safetyRegulationsRepository;

    @Override
    protected BaseRepository<SafetyRegulations> getBaseRepository() {
        return safetyRegulationsRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("descript", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("enclosure", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}
