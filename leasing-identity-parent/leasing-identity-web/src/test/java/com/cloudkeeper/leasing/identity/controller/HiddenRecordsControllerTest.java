package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.HiddenRecords;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 隐患流程记录 controller 测试
 * @author lxw
 */
public class HiddenRecordsControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        HiddenRecords hiddenRecords = new HiddenRecords();
        HttpEntity<HiddenRecords> httpEntity = new HttpEntity<>(hiddenRecords, httpHeaders);
        ParameterizedTypeReference<Result<HiddenRecords>> type = new ParameterizedTypeReference<Result<HiddenRecords>>() {};
        ResponseEntity<Result<HiddenRecords>> responseEntity = restTemplate.exchange("/hiddenRecords/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}