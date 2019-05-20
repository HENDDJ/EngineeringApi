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
public class CameraPreviewParam implements Serializable {

    public String appkey = "a592d676";

    public String opUserUuid = "c26a811c141a11e79aeeb32ef95273f2";

    public String netZoneUuid = "5b994421aced4e2d9a76179e8cc70734";
//    public String netZoneUuid = "f5816cf43fcc41d880d9f636fa8bc443";


    public String secret = "69681c3587194a50a2b11f1335ad6f41";

    private Long time = new Date().getTime();

    private Integer pageNo = 1;

    private Integer pageSize = 10;

    private String cameraUuid;


}
