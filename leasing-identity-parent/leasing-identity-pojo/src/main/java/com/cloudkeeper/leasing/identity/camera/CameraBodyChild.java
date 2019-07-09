package com.cloudkeeper.leasing.identity.camera;
import com.cloudkeeper.leasing.identity.utils.MD5Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CameraBodyChild {
    public String cameraUuid;
    public String cameraName;
    public Integer cameraType;
    public Integer cameraChannelNum;
    public String smartType;
    public Integer smartSupport;
    public Integer onLineStatus;
    public String keyBoardCode;
    public Integer orderNum;
    public Long updateTime;
    public String unitUuid;
    public String regionUuid;
    public String encoderUuid;
    public String resAuths;


}

