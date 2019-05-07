package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.PatrolRecords;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 巡查记录 controller 测试
 * @author lxw
 */
public class PatrolRecordsControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        PatrolRecords patrolRecords = new PatrolRecords();
        HttpEntity<PatrolRecords> httpEntity = new HttpEntity<>(patrolRecords, httpHeaders);
        ParameterizedTypeReference<Result<PatrolRecords>> type = new ParameterizedTypeReference<Result<PatrolRecords>>() {};
        ResponseEntity<Result<PatrolRecords>> responseEntity = restTemplate.exchange("/patrolRecords/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}