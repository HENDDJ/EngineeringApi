package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.MajorHazards;
import com.cloudkeeper.leasing.identity.repository.MajorHazardsRepository;
import com.cloudkeeper.leasing.identity.service.MajorHazardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 重大危险源 service
 * @author cqh
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MajorHazardsServiceImpl extends BaseServiceImpl<MajorHazards> implements MajorHazardsService {

    /** 重大危险源 repository */
    private final MajorHazardsRepository majorHazardsRepository;

    @Override
    protected BaseRepository<MajorHazards> getBaseRepository() {
        return majorHazardsRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("workType", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("description", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("damage", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}