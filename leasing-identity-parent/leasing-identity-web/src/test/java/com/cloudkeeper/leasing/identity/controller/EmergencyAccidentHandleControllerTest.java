package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.EmergencyAccidentHandle;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 应急事故处理方案 controller 测试
 * @author lxw
 */
public class EmergencyAccidentHandleControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        EmergencyAccidentHandle emergencyAccidentHandle = new EmergencyAccidentHandle();
        HttpEntity<EmergencyAccidentHandle> httpEntity = new HttpEntity<>(emergencyAccidentHandle, httpHeaders);
        ParameterizedTypeReference<Result<EmergencyAccidentHandle>> type = new ParameterizedTypeReference<Result<EmergencyAccidentHandle>>() {};
        ResponseEntity<Result<EmergencyAccidentHandle>> responseEntity = restTemplate.exchange("/emergencyAccidentHandle/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}