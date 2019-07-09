package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.HikRegion;
import com.cloudkeeper.leasing.identity.repository.HikRegionRepository;
import com.cloudkeeper.leasing.identity.service.HikRegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 海康区域 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HikRegionServiceImpl extends BaseServiceImpl<HikRegion> implements HikRegionService {

    /** 海康区域 repository */
    private final HikRegionRepository hikRegionRepository;

    @Override
    protected BaseRepository<HikRegion> getBaseRepository() {
        return hikRegionRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("regionUuid", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}