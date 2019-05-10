package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.HiddenNode;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 隐患节点信息 repository
 * @author lxw
 */
@Repository
public interface HiddenNodeRepository extends BaseRepository<HiddenNode> {

}