package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.HikRegion;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 海康区域 controller 测试
 * @author lxw
 */
public class HikRegionControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        HikRegion hikRegion = new HikRegion();
        HttpEntity<HikRegion> httpEntity = new HttpEntity<>(hikRegion, httpHeaders);
        ParameterizedTypeReference<Result<HikRegion>> type = new ParameterizedTypeReference<Result<HikRegion>>() {};
        ResponseEntity<Result<HikRegion>> responseEntity = restTemplate.exchange("/hikRegion/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}