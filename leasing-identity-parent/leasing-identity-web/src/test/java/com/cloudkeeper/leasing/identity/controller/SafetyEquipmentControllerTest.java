package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SafetyEquipment;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 特种设备信息 controller 测试
 * @author lxw
 */
public class SafetyEquipmentControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SafetyEquipment safetyEquipment = new SafetyEquipment();
        HttpEntity<SafetyEquipment> httpEntity = new HttpEntity<>(safetyEquipment, httpHeaders);
        ParameterizedTypeReference<Result<SafetyEquipment>> type = new ParameterizedTypeReference<Result<SafetyEquipment>>() {};
        ResponseEntity<Result<SafetyEquipment>> responseEntity = restTemplate.exchange("/safetyEquipment/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}