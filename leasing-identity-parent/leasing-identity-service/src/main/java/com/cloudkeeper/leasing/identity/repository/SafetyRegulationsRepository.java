package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.SafetyRegulations;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 安全生产规定 repository
 * @author lxw
 */
@Repository
public interface SafetyRegulationsRepository extends BaseRepository<SafetyRegulations> {

}