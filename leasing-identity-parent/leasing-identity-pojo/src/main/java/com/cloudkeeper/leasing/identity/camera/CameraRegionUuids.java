package com.cloudkeeper.leasing.identity.camera;
import com.cloudkeeper.leasing.identity.utils.MD5Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CameraRegionUuids {

    public String appkey="a592d676";

    public Long time = new Date().getTime();

    public Integer pageNo = 1;

    public Integer pageSize = 300;

    public String   opUserUuid;

    public String regionUuids;

}
