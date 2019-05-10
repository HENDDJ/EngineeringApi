package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.HiddenHandle;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 隐患处理结果 controller 测试
 * @author lxw
 */
public class HiddenHandleControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        HiddenHandle hiddenHandle = new HiddenHandle();
        HttpEntity<HiddenHandle> httpEntity = new HttpEntity<>(hiddenHandle, httpHeaders);
        ParameterizedTypeReference<Result<HiddenHandle>> type = new ParameterizedTypeReference<Result<HiddenHandle>>() {};
        ResponseEntity<Result<HiddenHandle>> responseEntity = restTemplate.exchange("/hiddenHandle/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}