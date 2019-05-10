package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.HiddenIssue;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 隐患信息 controller 测试
 * @author lxw
 */
public class HiddenIssueControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        HiddenIssue hiddenIssue = new HiddenIssue();
        HttpEntity<HiddenIssue> httpEntity = new HttpEntity<>(hiddenIssue, httpHeaders);
        ParameterizedTypeReference<Result<HiddenIssue>> type = new ParameterizedTypeReference<Result<HiddenIssue>>() {};
        ResponseEntity<Result<HiddenIssue>> responseEntity = restTemplate.exchange("/hiddenIssue/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}