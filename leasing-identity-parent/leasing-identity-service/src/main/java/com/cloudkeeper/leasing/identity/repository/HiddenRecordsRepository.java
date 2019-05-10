package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.HiddenRecords;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 隐患流程记录 repository
 * @author lxw
 */
@Repository
public interface HiddenRecordsRepository extends BaseRepository<HiddenRecords> {

}