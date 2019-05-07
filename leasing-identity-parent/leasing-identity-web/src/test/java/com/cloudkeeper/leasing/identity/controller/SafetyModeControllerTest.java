package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SafetyMode;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 安全生产方式 controller 测试
 * @author lxw
 */
public class SafetyModeControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SafetyMode safetyMode = new SafetyMode();
        HttpEntity<SafetyMode> httpEntity = new HttpEntity<>(safetyMode, httpHeaders);
        ParameterizedTypeReference<Result<SafetyMode>> type = new ParameterizedTypeReference<Result<SafetyMode>>() {};
        ResponseEntity<Result<SafetyMode>> responseEntity = restTemplate.exchange("/safetyMode/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}