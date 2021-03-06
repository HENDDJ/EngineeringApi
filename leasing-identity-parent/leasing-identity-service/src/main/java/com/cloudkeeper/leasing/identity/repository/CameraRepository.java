package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.Camera;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 监控 repository
 * @author asher
 */
@Repository
public interface CameraRepository extends BaseRepository<Camera> {

    @Transactional
    @Modifying
    @Query(value = "truncate table cm_camera",nativeQuery = true)
     void truncateTable();
}
