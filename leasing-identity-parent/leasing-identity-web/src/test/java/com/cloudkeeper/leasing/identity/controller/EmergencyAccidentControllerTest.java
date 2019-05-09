package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.EmergencyAccident;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 应急事故 controller 测试
 * @author lxw
 */
public class EmergencyAccidentControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        EmergencyAccident emergencyAccident = new EmergencyAccident();
        HttpEntity<EmergencyAccident> httpEntity = new HttpEntity<>(emergencyAccident, httpHeaders);
        ParameterizedTypeReference<Result<EmergencyAccident>> type = new ParameterizedTypeReference<Result<EmergencyAccident>>() {};
        ResponseEntity<Result<EmergencyAccident>> responseEntity = restTemplate.exchange("/emergencyAccident/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}