package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.HiddenHandle;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 隐患处理结果 repository
 * @author lxw
 */
@Repository
public interface HiddenHandleRepository extends BaseRepository<HiddenHandle> {

}