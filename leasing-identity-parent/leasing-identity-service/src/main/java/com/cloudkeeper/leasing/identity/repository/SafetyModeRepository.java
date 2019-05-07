package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.SafetyMode;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 安全生产方式 repository
 * @author lxw
 */
@Repository
public interface SafetyModeRepository extends BaseRepository<SafetyMode> {

}