package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.camera.*;
import com.cloudkeeper.leasing.identity.domain.Camera;
import com.cloudkeeper.leasing.identity.domain.HikRegion;
import com.cloudkeeper.leasing.identity.repository.CameraRepository;
import com.cloudkeeper.leasing.identity.repository.HikRegionRepository;
import com.cloudkeeper.leasing.identity.service.CameraService;
import com.cloudkeeper.leasing.identity.service.HikRegionService;
import com.cloudkeeper.leasing.identity.utils.MD5Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 监控 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CameraServiceImpl extends BaseServiceImpl<Camera> implements CameraService {

    /**
     * 监控 repository
     */
    private final CameraRepository cameraRepository;

    private final HikRegionService hikRegionService;

    private final HikRegionRepository hikRegionRepository;

    private static final String IP_PORT = "http://172.16.1.133:8080";


    @Override
    protected BaseRepository<Camera> getBaseRepository() {
        return cameraRepository;
    }

    /**
     * app_key
     */
    private static final String APP_KEY = "a592d676";

    /**
     * 秘钥
     */
    private static final String SECRET = "69681c3587194a50a2b11f1335ad6f41";

    /**
     * 摄像头资源列表
     */
    private static final String CAMERA_LIST = "/openapi/service/vss/res/getEncoders";

    /**
     * 查询监控点设备
     */
    private static final String PONIT_URL = "/openapi/service/vss/res/getCamerasEx";

    /**
     * 获取所有网域
     */
    private static final String NET_URL = "/openapi/service/base/netZone/getNetZones";

    /**
     * 预览
     */
    private static final String PERVIEW_URL = "/openapi/service/vss/preview/getPreviewParamByCameraUuid";

    /**
     * 获取经纬度
     */
    private static final String XY_URL = "/openapi/service/ems/location/getResLocations";

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
        CameraPreviewParam cameraPreviewParam = new CameraPreviewParam();
        cameraPreviewParam.setCameraUuid(cameraUuid);
        ObjectMapper param = new ObjectMapper();
        String fullUrl = null;
        try {
            fullUrl = getFullUrl(PERVIEW_URL, param.writeValueAsString(cameraPreviewParam));
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.add("Accept", MediaType.APPLICATION_JSON_UTF8.toString());
            HttpEntity entity = new HttpEntity(cameraPreviewParam, headers);
            ResponseEntity responseEntity = restTemplate.exchange(fullUrl, HttpMethod.POST, entity, String.class);
            return responseEntity.getBody().toString();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取请求token
     *
     * @param URI  相对接口的请求地址
     * @param json 需要参与生成token的入参json串
     * @return token
     */
    private static String generateToken(String URI, String json) {
        String origin = URI + json + SECRET;
        return MD5Utils.MD5Encode(origin, "utf-8");
    }

    /**
     * 获取请求全路径
     *
     * @param URI  相对接口的请求地址
     * @param json 需要参与生成token的入参json串
     * @return 请求全路径
     */
    @JsonIgnore
    private static String getFullUrl(String URI, String json) {
        String token = generateToken(URI, json);
        return String.format("%s?token=%s", IP_PORT + URI, token.toUpperCase());
    }


    //获得默认USERUUID
    public static String getDefaultUUID() {
        ObjectMapper param = new ObjectMapper();
        CameraDefaultUuid cameraDefaultUuid = new CameraDefaultUuid();
        try {
            String str = param.writeValueAsString(cameraDefaultUuid);
            String fullUrl = getFullUrl("/openapi/service/base/user/getDefaultUserUuid", str);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity<String> entity = new HttpEntity<String>(str, headers);
            ResponseEntity responseEntity = restTemplate.exchange(fullUrl, HttpMethod.POST, entity, String.class);
            return responseEntity.getBody().toString();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取默认控制中心
    public static String getDefaultUnit(String opUserUuid) {
        ObjectMapper param = new ObjectMapper();
        CameraDefaultUnit cameraDefaultUnit = new CameraDefaultUnit();
        cameraDefaultUnit.setOpUserUuid(opUserUuid);
        cameraDefaultUnit.setSubSystemCode("1048576");
        try {
            String str = param.writeValueAsString(cameraDefaultUnit);
            String fullUrl = getFullUrl("/openapi/service/base/org/getDefaultUnit", str);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity<String> entity = new HttpEntity<String>(str, headers);
            ResponseEntity responseEntity = restTemplate.exchange(fullUrl, HttpMethod.POST, entity, String.class);
            return responseEntity.getBody().toString();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //获得区域下的子区域
    public static String getRegionsByUnits() {
        ObjectMapper param = new ObjectMapper();
        CameraRegionsByUnitUuid cameraRegionsByUnitUuid = new CameraRegionsByUnitUuid();
        String UUID = getDefaultUUID();
        try {
            BackMessage backMessage = param.readValue(UUID, BackMessage.class);
            cameraRegionsByUnitUuid.setOpUserUuid(backMessage.getData());
            BackMessageParent backMessageParent = param.readValue(getDefaultUnit(backMessage.getData()), BackMessageParent.class);

            cameraRegionsByUnitUuid.setParentUuid("f6ed32f2f6c941ce964e1f9740ddf09f");
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String str = param.writeValueAsString(cameraRegionsByUnitUuid);
            String fullUrl = getFullUrl("/openapi/service/base/org/getRegionsByParentUuid", str);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity<String> entity = new HttpEntity<>(str, headers);
            ResponseEntity responseEntity = restTemplate.exchange(fullUrl, HttpMethod.POST, entity, String.class);
            return responseEntity.getBody().toString();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void freshCamera() {
        ObjectMapper param = new ObjectMapper();
        try {
            CameraRegionByParent cameraRegionByParent = param.readValue(getRegionsByUnits(), CameraRegionByParent.class);
            CameraRegionsByUnitUuidData cameraRegionsByUnitUuidData = cameraRegionByParent.getData();
            List<ChildRegions> list = cameraRegionsByUnitUuidData.getList();
            StringBuffer regionUuids = new StringBuffer();
            hikRegionRepository.truncateTable();
            for (int i = 0; i < list.size(); i++) {
                HikRegion hikRegion = new HikRegion();
                hikRegion.setRegionUuid(list.get(i).getRegionUuid());
                hikRegion.setName(list.get(i).getName());
                hikRegion.setEnable(0);
                hikRegionService.save(hikRegion);
                if (i == 0) {
                    regionUuids.append(list.get(i).getRegionUuid());
                } else {
                    regionUuids.append("," + list.get(i).getRegionUuid());
                }
            }
            ;
            ObjectMapper objectMapper = new ObjectMapper();
            String UUID = getDefaultUUID();
            BackMessage backMessage = objectMapper.readValue(UUID, BackMessage.class);
            CameraRegionUuids cameraRegionUuids = new CameraRegionUuids();
            cameraRegionUuids.setOpUserUuid(backMessage.getData());
            cameraRegionUuids.setRegionUuids(regionUuids.toString());

            String str = param.writeValueAsString(cameraRegionUuids);
            String fullUrl = getFullUrl("/openapi/service/vss/res/getCamerasEx", str);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity<String> entity = new HttpEntity<>(str, headers);
            ResponseEntity responseEntity = restTemplate.exchange(fullUrl, HttpMethod.POST, entity, String.class);
            String body = responseEntity.getBody().toString();
            CameraBody cameraBody = objectMapper.readValue(body, CameraBody.class);
            List<CameraBodyChild> cameraBodyChildren = cameraBody.getData().getList();
            cameraRepository.truncateTable();
            for (int i = 0; i < cameraBodyChildren.size(); i++) {
                Camera camera = new Camera();
                camera.setCameraName(cameraBodyChildren.get(i).getCameraName());
                camera.setCameraType(cameraBodyChildren.get(i).getCameraType());
                camera.setCameraUuid(cameraBodyChildren.get(i).getCameraUuid());
                camera.setKeyBoardCode(cameraBodyChildren.get(i).getKeyBoardCode());
                camera.setRegionUuid(cameraBodyChildren.get(i).getRegionUuid());
                camera.setNickName(cameraBodyChildren.get(i).getCameraName());
                camera.setRefreshCheck(0);
                camera.setEnable(0);
                super.save(camera);
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public PreviewParam getPreviewParam(String cameraUuid) {
        Long now = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        String dateTimeStr = "1970-01-01 08:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Long dateTime = LocalDateTime.parse(dateTimeStr, df).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        Long time = now - dateTime;

        ObjectMapper param = new ObjectMapper();
        String UUID = getDefaultUUID();
        PreViewParamData preViewParamData = new PreViewParamData();
        String netZoneUuid = "5b994421aced4e2d9a76179e8cc70734";

        try {
            String opUserUuid;
            BackMessage backMessage = param.readValue(UUID, BackMessage.class);
            opUserUuid = backMessage.getData();
            preViewParamData.setOpUserUuid(opUserUuid);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        preViewParamData.setAppkey(APP_KEY);
        preViewParamData.setCameraUuid(cameraUuid);
        preViewParamData.setNetZoneUuid(netZoneUuid);
        preViewParamData.setTime(time);
        try {
            String str = param.writeValueAsString(preViewParamData);
            String fullUrl = getFullUrl("/openapi/service/vss/preview/getPreviewParamByCameraUuid", str);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity<String> entity = new HttpEntity<>(str, headers);
            ResponseEntity responseEntity = restTemplate.exchange(fullUrl, HttpMethod.POST, entity, String.class);
            String body = responseEntity.getBody().toString();
            PreviewParam previewParam = param.readValue(body, PreviewParam.class);
            return previewParam;
        }catch (JsonParseException e) {
            e.printStackTrace();
            return null;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
