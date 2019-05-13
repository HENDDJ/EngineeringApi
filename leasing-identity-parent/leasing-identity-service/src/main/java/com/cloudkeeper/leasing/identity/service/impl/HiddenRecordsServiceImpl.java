package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.HiddenHandle;
import com.cloudkeeper.leasing.identity.domain.HiddenIssue;
import com.cloudkeeper.leasing.identity.domain.HiddenNode;
import com.cloudkeeper.leasing.identity.domain.HiddenRecords;
import com.cloudkeeper.leasing.identity.repository.HiddenRecordsRepository;
import com.cloudkeeper.leasing.identity.service.HiddenRecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;

/**
 * 隐患流程记录 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HiddenRecordsServiceImpl extends BaseServiceImpl<HiddenRecords> implements HiddenRecordsService {

    /** 隐患流程记录 repository */
    private final HiddenRecordsRepository hiddenRecordsRepository;
    private final HiddenIssueServiceImpl hiddenIssueService;
    @Override
    protected BaseRepository<HiddenRecords> getBaseRepository() {
        return hiddenRecordsRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("actionType", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("des", ExampleMatcher.GenericPropertyMatchers.contains());
    }
    @Nonnull
    @Override
    public HiddenRecords save(@Nonnull HiddenRecords entity) {
        HiddenRecords hiddenRecords = super.save(entity);
        HiddenIssue h = hiddenIssueService.findById(entity.getIssueId());
        if (!StringUtils.isEmpty(h)){

            HiddenNode hiddenNode = h.getHiddenNode();
            if(entity.getActionType().equals("CHECKED")){
                if(!StringUtils.isEmpty(hiddenNode.getNextNodeId())){
                    h.setStatus(hiddenNode.getNextNodeId());
                }
            }
            if(entity.getActionType().equals("UNCHECKED") ){
                if(!StringUtils.isEmpty(hiddenNode.getPreNodeId())){
                    h.setStatus(hiddenNode.getPreNodeId());
                }
            }

            hiddenIssueService.save(h);
        }
        return hiddenRecords;
    }
}
