package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.HiddenIssue;
import com.cloudkeeper.leasing.identity.repository.HiddenIssueRepository;
import com.cloudkeeper.leasing.identity.service.HiddenIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 隐患信息 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HiddenIssueServiceImpl extends BaseServiceImpl<HiddenIssue> implements HiddenIssueService {

    /** 隐患信息 repository */
    private final HiddenIssueRepository hiddenIssueRepository;

    @Override
    protected BaseRepository<HiddenIssue> getBaseRepository() {
        return hiddenIssueRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("issueName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("issueImage", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("issueGrade", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("issueDescript", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("issueProposal", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("status", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}