package com.cloudkeeper.leasing.identity.camera;
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
public class BackMessageParentData {
    public String unitUuid;
    public String name;
    public String parentUuid;
    public Integer isParent;
    public Long createTime;
    public Long updateTime;
    public String remark;
}
