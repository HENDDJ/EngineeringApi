package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.MajorHazards;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 重大危险源 repository
 * @author cqh
 */
@Repository
public interface MajorHazardsRepository extends BaseRepository<MajorHazards> {

}