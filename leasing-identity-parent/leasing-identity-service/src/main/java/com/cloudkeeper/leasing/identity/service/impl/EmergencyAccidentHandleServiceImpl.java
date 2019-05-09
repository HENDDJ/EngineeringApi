package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.EmergencyAccidentHandle;
import com.cloudkeeper.leasing.identity.repository.EmergencyAccidentHandleRepository;
import com.cloudkeeper.leasing.identity.service.EmergencyAccidentHandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 应急事故处理方案 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmergencyAccidentHandleServiceImpl extends BaseServiceImpl<EmergencyAccidentHandle> implements EmergencyAccidentHandleService {

    /** 应急事故处理方案 repository */
    private final EmergencyAccidentHandleRepository emergencyAccidentHandleRepository;

    @Override
    protected BaseRepository<EmergencyAccidentHandle> getBaseRepository() {
        return emergencyAccidentHandleRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("solution", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("precaution", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("enclosure", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}