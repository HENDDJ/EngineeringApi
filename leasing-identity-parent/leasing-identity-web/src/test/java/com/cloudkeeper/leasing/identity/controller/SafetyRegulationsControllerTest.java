package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SafetyRegulations;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 安全生产规定 controller 测试
 * @author lxw
 */
public class SafetyRegulationsControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SafetyRegulations safetyRegulations = new SafetyRegulations();
        HttpEntity<SafetyRegulations> httpEntity = new HttpEntity<>(safetyRegulations, httpHeaders);
        ParameterizedTypeReference<Result<SafetyRegulations>> type = new ParameterizedTypeReference<Result<SafetyRegulations>>() {};
        ResponseEntity<Result<SafetyRegulations>> responseEntity = restTemplate.exchange("/safetyRegulations/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}