package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.PatrolRecords;
import com.cloudkeeper.leasing.identity.repository.PatrolRecordsRepository;
import com.cloudkeeper.leasing.identity.service.PatrolRecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 巡查记录 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PatrolRecordsServiceImpl extends BaseServiceImpl<PatrolRecords> implements PatrolRecordsService {

    /** 巡查记录 repository */
    private final PatrolRecordsRepository patrolRecordsRepository;

    @Override
    protected BaseRepository<PatrolRecords> getBaseRepository() {
        return patrolRecordsRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("patrolName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("patrolType", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("patrolObject", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("patrolPerson", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("patrolResult", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("patrolDescribe", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}