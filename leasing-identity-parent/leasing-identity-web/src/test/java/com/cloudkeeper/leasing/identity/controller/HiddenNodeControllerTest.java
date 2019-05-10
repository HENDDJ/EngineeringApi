package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.HiddenNode;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 隐患节点信息 controller 测试
 * @author lxw
 */
public class HiddenNodeControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        HiddenNode hiddenNode = new HiddenNode();
        HttpEntity<HiddenNode> httpEntity = new HttpEntity<>(hiddenNode, httpHeaders);
        ParameterizedTypeReference<Result<HiddenNode>> type = new ParameterizedTypeReference<Result<HiddenNode>>() {};
        ResponseEntity<Result<HiddenNode>> responseEntity = restTemplate.exchange("/hiddenNode/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}