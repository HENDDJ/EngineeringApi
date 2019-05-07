package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.PatrolRecords;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 巡查记录 repository
 * @author lxw
 */
@Repository
public interface PatrolRecordsRepository extends BaseRepository<PatrolRecords> {

}