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
public class CameraRegionsByUnitUuidData {
    public Integer total;
    public Integer pageNo;
    public Integer pageSize;
    public List<ChildRegions> list;
}
