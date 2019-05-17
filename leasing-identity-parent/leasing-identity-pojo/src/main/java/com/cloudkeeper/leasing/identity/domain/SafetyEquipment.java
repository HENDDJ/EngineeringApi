package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.SafetyEquipmentVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * 特种设备信息
 * @author lxw
 */
@ApiModel(value = "特种设备信息", description = "特种设备信息")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "safety_supervision_equipment")
public class SafetyEquipment extends BaseEntity {

    /** 注册代码 */
    @ApiModelProperty(value = "注册代码", position = 0, required = true)
    @Column(length = 60)
    private String registrationCode;

    /** 产权单位 */
    @ApiModelProperty(value = "产权单位", position = 0, required = true)
    @Column(length = 60)
    private String propertyUnit;

    /** 产权单位地址 */
    @ApiModelProperty(value = "产权单位地址", position = 0, required = true)
    @Column(length = 60)
    private String proUnitAddress;

    /** 使用地址 */
    @ApiModelProperty(value = "使用地址", position = 0, required = true)
    @Column(length = 60)
    private String installAddress;

    /** 设备种类 */
    @ApiModelProperty(value = "设备种类", position = 0, required = true)
    @Column(length = 60)
    private String equipmentType;

    /** 设备型号 */
    @ApiModelProperty(value = "设备型号", position = 0, required = true)
    @Column(length = 60)
    private String equipmentModel;

    /** 资格证书号 */
    @ApiModelProperty(value = "资格证书号", position = 0, required = true)
    @Column(length = 60)
    private String credentials;

    /** 制造年月 */
    @ApiModelProperty(value = "制造年月", position = 0, required = true)
    @Column(length = 60)
    private LocalDate manufactureDate;

    /** 出厂编号 */
    @ApiModelProperty(value = "出厂编号", position = 0, required = true)
    @Column(length = 60)
    private String factoryNumber;

    /** 安装日期 */
    @ApiModelProperty(value = "安装日期", position = 0, required = true)
    @Column(length = 60)
    private LocalDate installDate;

    /** 上次检查时间 */
    @ApiModelProperty(value = "上次检查时间", position = 0, required = true)
    @Column(length = 60)
    private LocalDate lastInspectionTime;

    /** 最新检查结果 */
    @ApiModelProperty(value = "最新检查结果", position = 0, required = true)
    @Column(length = 60)
    private String lastInspection;

    /** 下次检查时间 */
    @ApiModelProperty(value = "下次检查时间", position = 0, required = true)
    @Column(length = 60)
    private LocalDate nextInspectionTime;

    /** 工程id */
    @ApiModelProperty(value = "工程id", position = 26, required = true)
    @Column(length = 36)
    private String proId;

    /** 工程 */
    @ApiModelProperty(value = "工程", position = 28)
    @ManyToOne
    @JoinColumn(name = "proId", insertable = false, updatable = false)
    private ProjectInfo projectInfo;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        SafetyEquipmentVO safetyEquipmentVO = (SafetyEquipmentVO) convert;
        if(!StringUtils.isEmpty(this.projectInfo)){
            safetyEquipmentVO.setProjectName(this.projectInfo.getName());
        }

        return (T) safetyEquipmentVO;
    }


}
