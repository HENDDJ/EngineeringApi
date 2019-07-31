package com.cloudkeeper.leasing.identity.camera;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PreViewParamData {
    String appkey;
    Long time;
    String token;
    String opUserUuid;
    String cameraUuid;
    String netZoneUuid;
}
