package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.HiddenIssue;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 隐患信息 repository
 * @author lxw
 */
@Repository
public interface HiddenIssueRepository extends BaseRepository<HiddenIssue> {

}