package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.EmergencyPrevention;
import com.cloudkeeper.leasing.identity.repository.EmergencyPreventionRepository;
import com.cloudkeeper.leasing.identity.service.EmergencyPreventionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 应急预防与准备 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmergencyPreventionServiceImpl extends BaseServiceImpl<EmergencyPrevention> implements EmergencyPreventionService {

    /** 应急预防与准备 repository */
    private final EmergencyPreventionRepository emergencyPreventionRepository;

    @Override
    protected BaseRepository<EmergencyPrevention> getBaseRepository() {
        return emergencyPreventionRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("description", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("enclosure", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("submitter", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}