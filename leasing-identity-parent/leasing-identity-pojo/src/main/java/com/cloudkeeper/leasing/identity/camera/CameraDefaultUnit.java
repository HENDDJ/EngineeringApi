package com.cloudkeeper.leasing.identity.camera;

import com.cloudkeeper.leasing.identity.utils.MD5Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CameraDefaultUnit {
    public String appkey = "a592d676";
    public Long time = new Date().getTime();
    public String opUserUuid;
    public String subSystemCode;
}
