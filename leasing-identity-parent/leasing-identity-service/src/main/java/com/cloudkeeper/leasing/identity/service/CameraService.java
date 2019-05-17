package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.camera.CameraPreviewParam;
import com.cloudkeeper.leasing.identity.domain.Camera;
import com.cloudkeeper.leasing.base.service.BaseService;

/**
 * 监控 service
 * @author asher
 */
public interface CameraService extends BaseService<Camera> {

    String getPreviewXml(String cameraUuid);
}