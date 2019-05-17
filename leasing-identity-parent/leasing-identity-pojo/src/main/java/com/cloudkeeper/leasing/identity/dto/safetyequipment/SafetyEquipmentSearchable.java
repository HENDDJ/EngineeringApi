package com.cloudkeeper.leasing.identity.dto.safetyequipment;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
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
 * 特种设备信息 查询DTO
 * @author lxw
 */
@ApiModel(value = "特种设备信息 查询DTO", description = "特种设备信息 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SafetyEquipmentSearchable extends BaseSearchable {

    /** 注册代码 */
    @ApiModelProperty(value = "注册代码", position = 0, required = true)
    private String registrationCode;

    /** 产权单位 */
    @ApiModelProperty(value = "产权单位", position = 0, required = true)
    private String propertyUnit;

    /** 产权单位地址 */
    @ApiModelProperty(value = "产权单位地址", position = 0, required = true)
    private String proUnitAddress;

    /** 使用地址 */
    @ApiModelProperty(value = "使用地址", position = 0, required = true)
    private String installAddress;

    /** 设备种类 */
    @ApiModelProperty(value = "设备种类", position = 0, required = true)
    private String equipmentType;

    /** 设备型号 */
    @ApiModelProperty(value = "设备型号", position = 0, required = true)
    private String equipmentModel;

    /** 资格证书号 */
    @ApiModelProperty(value = "资格证书号", position = 0, required = true)
    private String credentials;

    /** 制造年月 */
    @ApiModelProperty(value = "制造年月", position = 0, required = true)
    private LocalDate manufactureDate;

    /** 出厂编号 */
    @ApiModelProperty(value = "出厂编号", position = 0, required = true)
    private String factoryNumber;

    /** 安装日期 */
    @ApiModelProperty(value = "安装日期", position = 0, required = true)
    private LocalDate installDate;

    /** 上次检查时间 */
    @ApiModelProperty(value = "上次检查时间", position = 0, required = true)
    private LocalDate lastInspectionTime;

    /** 最新检查结果 */
    @ApiModelProperty(value = "最新检查结果", position = 0, required = true)
    private String lastInspection;

    /** 下次检查时间 */
    @ApiModelProperty(value = "下次检查时间", position = 0, required = true)
    private LocalDate nextInspectionTime;

    /** 工程id */
    @ApiModelProperty(value = "工程id", position = 0, required = true)
    private String proId;

}
