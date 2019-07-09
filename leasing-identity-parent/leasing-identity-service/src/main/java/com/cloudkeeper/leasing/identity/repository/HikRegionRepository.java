package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.HikRegion;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 海康区域 repository
 * @author lxw
 */
@Repository
public interface HikRegionRepository extends BaseRepository<HikRegion> {

    @Transactional
    @Modifying
    @Query(value = "truncate table hik_region",nativeQuery = true)
    void truncateTable();
}
