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
public class CameraRegionsByUnitUuid {

    public String appkey = "a592d676";

    public String opUserUuid ;

    public String parentUuid ;

    public Integer allChildren = 1;

    private Long time = new Date().getTime();

    private Integer pageNo = 1;

    private Integer pageSize = 300;
}
