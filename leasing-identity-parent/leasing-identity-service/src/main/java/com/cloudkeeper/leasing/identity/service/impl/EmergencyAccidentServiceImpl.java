package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.EmergencyAccident;
import com.cloudkeeper.leasing.identity.repository.EmergencyAccidentRepository;
import com.cloudkeeper.leasing.identity.service.EmergencyAccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 应急事故 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmergencyAccidentServiceImpl extends BaseServiceImpl<EmergencyAccident> implements EmergencyAccidentService {

    /** 应急事故 repository */
    private final EmergencyAccidentRepository emergencyAccidentRepository;

    @Override
    protected BaseRepository<EmergencyAccident> getBaseRepository() {
        return emergencyAccidentRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("department", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("chargePerson", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("litigantName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("litigantSex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("litigantPost", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("injuredPart", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("accidentPassing", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("enclosure", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}