package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.PreWarning;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 预警信息 controller 测试
 * @author lxw
 */
public class PreWarningControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        PreWarning preWarning = new PreWarning();
        HttpEntity<PreWarning> httpEntity = new HttpEntity<>(preWarning, httpHeaders);
        ParameterizedTypeReference<Result<PreWarning>> type = new ParameterizedTypeReference<Result<PreWarning>>() {};
        ResponseEntity<Result<PreWarning>> responseEntity = restTemplate.exchange("/preWarning/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}