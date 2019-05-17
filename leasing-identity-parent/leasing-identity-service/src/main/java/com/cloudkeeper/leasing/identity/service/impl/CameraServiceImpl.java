package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.camera.CameraPreviewParam;
import com.cloudkeeper.leasing.identity.domain.Camera;
import com.cloudkeeper.leasing.identity.repository.CameraRepository;
import com.cloudkeeper.leasing.identity.service.CameraService;
import com.cloudkeeper.leasing.identity.utils.CameraPlatform;
import com.cloudkeeper.leasing.identity.utils.MD5Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 监控 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CameraServiceImpl extends BaseServiceImpl<Camera> implements CameraService {

    /** 监控 repository */
    private final CameraRepository cameraRepository;

    private String IP_PORT = "http://172.16.1.133:8080";

    private String PERVIEW_URL = "/openapi/service/vss/preview/getPreviewParamByCameraUuid";

    @Override
    protected BaseRepository<Camera> getBaseRepository() {
        return cameraRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("pId", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("cameraUuid", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("regionUuid", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("cameraName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("nickName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("keyBoardCode", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("rtspURL", ExampleMatcher.GenericPropertyMatchers.contains());
    }

    @Override
    public String getPreviewXml(String cameraUuid) {
        CameraPreviewParam cameraPreviewParam =  new CameraPreviewParam();
        cameraPreviewParam.setCameraUuid(cameraUuid);
        ObjectMapper param = new ObjectMapper();
        String fullUrl = null;
        try {
            fullUrl = getFullUrl(PERVIEW_URL, param.writeValueAsString(cameraPreviewParam), cameraPreviewParam.secret);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.add("Accept", MediaType.APPLICATION_JSON_UTF8.toString());
            HttpEntity entity = new HttpEntity(cameraPreviewParam,headers);
            ResponseEntity  responseEntity = restTemplate.exchange(fullUrl, HttpMethod.POST, entity,String.class);
            return responseEntity.getBody().toString();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取请求全路径
     * @param URI 相对接口的请求地址
     * @param json 需要参与生成token的入参json串
     * @return 请求全路径
     */
    @JsonIgnore
    public String getFullUrl(String URI,String json, String secret) {
        String origin = URI + json + secret;
        String token = MD5Utils.MD5Encode(origin, "utf-8");
        return String.format("%s?token=%s", IP_PORT + URI, token.toUpperCase());
    }

}
