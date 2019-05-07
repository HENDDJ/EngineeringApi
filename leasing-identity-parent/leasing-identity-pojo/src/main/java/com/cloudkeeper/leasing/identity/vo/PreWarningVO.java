package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预警信息 VO
 * @author lxw
 */
@ApiModel(value = "预警信息 VO", description = "预警信息 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PreWarningVO extends BaseVO {

    /** 预警类型 */
    @ApiModelProperty(value = "预警类型", position = 10, required = true)
    private String type;

    /** 预警项目ID */
    @ApiModelProperty(value = "预警项目ID", position = 10, required = true)
    private String typeId;

    /** 预警描述 */
    @ApiModelProperty(value = "预警描述", position = 10, required = true)
    private String warnDescribe;

    /** 特种设备注册编号 */
    @ApiModelProperty(value = "特种设备注册编号", position = 10, required = true)
    private String registrationCode;

    /** 特种设备种类 */
    @ApiModelProperty(value = "特种设备种类", position = 10, required = true)
    private String equipmentType;

    /** 上次检查时间 */
    @ApiModelProperty(value = "上次检查时间", position = 10, required = true)
    private LocalDate lastInspectionTime;

    /** 上次检查时间 */
    @ApiModelProperty(value = "最新检查结果", position = 10, required = true)
    private String lastInspection;

    /** 上次检查时间 */
    @ApiModelProperty(value = "下次检查时间", position = 10, required = true)
    private LocalDate nextInspectionTime;


}
