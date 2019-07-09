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
public class ChildRegions {
    public String regionUuid;
    public String name;
    public String parentUuid;
    public Integer parentNodeType;
    public Integer isParent;
    public Long createTime;
    public Long updateTime;
    public String remark;

}
