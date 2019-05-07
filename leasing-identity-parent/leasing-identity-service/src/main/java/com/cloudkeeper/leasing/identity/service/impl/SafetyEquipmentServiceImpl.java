package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SafetyEquipment;
import com.cloudkeeper.leasing.identity.repository.SafetyEquipmentRepository;
import com.cloudkeeper.leasing.identity.service.SafetyEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 特种设备信息 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SafetyEquipmentServiceImpl extends BaseServiceImpl<SafetyEquipment> implements SafetyEquipmentService {

    /** 特种设备信息 repository */
    private final SafetyEquipmentRepository safetyEquipmentRepository;

    @Override
    protected BaseRepository<SafetyEquipment> getBaseRepository() {
        return safetyEquipmentRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("registrationCode", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("propertyUnit", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("proUnitAddress", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("installAddress", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("equipmentType", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("equipmentModel", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("credentials", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("lastInspection", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("factoryNumber", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}
