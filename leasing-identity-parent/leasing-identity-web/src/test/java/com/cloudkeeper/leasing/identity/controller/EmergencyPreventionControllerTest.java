package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.EmergencyPrevention;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 应急预防与准备 controller 测试
 * @author lxw
 */
public class EmergencyPreventionControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        EmergencyPrevention emergencyPrevention = new EmergencyPrevention();
        HttpEntity<EmergencyPrevention> httpEntity = new HttpEntity<>(emergencyPrevention, httpHeaders);
        ParameterizedTypeReference<Result<EmergencyPrevention>> type = new ParameterizedTypeReference<Result<EmergencyPrevention>>() {};
        ResponseEntity<Result<EmergencyPrevention>> responseEntity = restTemplate.exchange("/emergencyPrevention/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}