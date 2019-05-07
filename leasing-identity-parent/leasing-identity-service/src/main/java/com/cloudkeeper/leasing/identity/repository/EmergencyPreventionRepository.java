package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.EmergencyPrevention;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 应急预防与准备 repository
 * @author lxw
 */
@Repository
public interface EmergencyPreventionRepository extends BaseRepository<EmergencyPrevention> {

}