package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.MajorHazards;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 重大危险源 controller 测试
 * @author cqh
 */
public class MajorHazardsControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        MajorHazards majorHazards = new MajorHazards();
        HttpEntity<MajorHazards> httpEntity = new HttpEntity<>(majorHazards, httpHeaders);
        ParameterizedTypeReference<Result<MajorHazards>> type = new ParameterizedTypeReference<Result<MajorHazards>>() {};
        ResponseEntity<Result<MajorHazards>> responseEntity = restTemplate.exchange("/majorHazards/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}