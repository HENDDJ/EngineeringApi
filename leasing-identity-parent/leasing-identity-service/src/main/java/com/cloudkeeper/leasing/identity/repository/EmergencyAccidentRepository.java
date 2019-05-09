package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.EmergencyAccident;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 应急事故 repository
 * @author lxw
 */
@Repository
public interface EmergencyAccidentRepository extends BaseRepository<EmergencyAccident> {

}