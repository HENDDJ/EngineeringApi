package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.EmergencyAccidentResult;
import com.cloudkeeper.leasing.identity.repository.EmergencyAccidentResultRepository;
import com.cloudkeeper.leasing.identity.service.EmergencyAccidentResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 应急事故处理结果 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmergencyAccidentResultServiceImpl extends BaseServiceImpl<EmergencyAccidentResult> implements EmergencyAccidentResultService {

    /** 应急事故处理结果 repository */
    private final EmergencyAccidentResultRepository emergencyAccidentResultRepository;

    @Override
    protected BaseRepository<EmergencyAccidentResult> getBaseRepository() {
        return emergencyAccidentResultRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("solutionGrade", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("solutionResult", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("enclosure", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}