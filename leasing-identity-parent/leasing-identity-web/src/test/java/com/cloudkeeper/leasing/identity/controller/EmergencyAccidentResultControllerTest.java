package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.EmergencyAccidentResult;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 应急事故处理结果 controller 测试
 * @author lxw
 */
public class EmergencyAccidentResultControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        EmergencyAccidentResult emergencyAccidentResult = new EmergencyAccidentResult();
        HttpEntity<EmergencyAccidentResult> httpEntity = new HttpEntity<>(emergencyAccidentResult, httpHeaders);
        ParameterizedTypeReference<Result<EmergencyAccidentResult>> type = new ParameterizedTypeReference<Result<EmergencyAccidentResult>>() {};
        ResponseEntity<Result<EmergencyAccidentResult>> responseEntity = restTemplate.exchange("/emergencyAccidentResult/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}