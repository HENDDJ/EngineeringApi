package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.HiddenHandle;
import com.cloudkeeper.leasing.identity.domain.HiddenIssue;
import com.cloudkeeper.leasing.identity.domain.HiddenNode;
import com.cloudkeeper.leasing.identity.repository.HiddenHandleRepository;
import com.cloudkeeper.leasing.identity.service.HiddenHandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;

/**
 * 隐患处理结果 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HiddenHandleServiceImpl extends BaseServiceImpl<HiddenHandle> implements HiddenHandleService {

    /** 隐患处理结果 repository */
    private final HiddenHandleRepository hiddenHandleRepository;

    private final HiddenIssueServiceImpl hiddenIssueService;

    @Override
    protected BaseRepository<HiddenHandle> getBaseRepository() {
        return hiddenHandleRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("solveImage", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("enclosure", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("solveDes", ExampleMatcher.GenericPropertyMatchers.contains());
    }

    @Nonnull
    @Override
    public HiddenHandle save(@Nonnull HiddenHandle entity) {
        HiddenHandle hiddenHandle = super.save(entity);
        HiddenIssue h = hiddenIssueService.findById(entity.getIssueId());
        if (!StringUtils.isEmpty(h)){
            HiddenNode hiddenNode = h.getHiddenNode();
            if(!StringUtils.isEmpty(hiddenNode.getNextNodeId())){
                h.setStatus(hiddenNode.getNextNodeId());
            }
            hiddenIssueService.save(h);
        }
        return hiddenHandle;
    }
}
