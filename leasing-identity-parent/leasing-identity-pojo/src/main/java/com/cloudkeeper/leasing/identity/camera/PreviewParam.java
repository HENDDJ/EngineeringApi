package com.cloudkeeper.leasing.identity.camera;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PreviewParam {
    private Integer errorCode;
    private String errorMessage;
    private String data;

}
