package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.PreWarningVO;
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

/**
 * 预警信息
 * @author lxw
 */
@ApiModel(value = "预警信息", description = "预警信息")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pre_warning")
public class PreWarning extends BaseEntity {

    /** 预警类型 */
    @ApiModelProperty(value = "预警类型", position = 10, required = true)
    @Column(length = 60)
    private String type;

    /** 预警类型 */
    @ApiModelProperty(value = "预警项目ID", position = 10, required = true)
    @Column(length = 60)
    private String typeId;

    /** 预警类型 */
    @ApiModelProperty(value = "预警描述", position = 10, required = true)
    @Column(length = 60)
    private String warnDescribe;

    /** 角色 */
    @ApiModelProperty(value = "特种设备信息", position = 28)
    @ManyToOne
    @JoinColumn(name = "typeId", insertable = false, updatable = false)
    private SafetyEquipment safetyEquipment;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        PreWarningVO preWarningVO = (PreWarningVO) convert;
        if(!StringUtils.isEmpty(this.typeId)){
            preWarningVO.setRegistrationCode(this.safetyEquipment.getRegistrationCode());
            preWarningVO.setEquipmentType(this.safetyEquipment.getEquipmentType());
            preWarningVO.setLastInspectionTime(this.safetyEquipment.getLastInspectionTime());
            preWarningVO.setEquipmentType(this.safetyEquipment.getEquipmentType());
            preWarningVO.setNextInspectionTime(this.safetyEquipment.getNextInspectionTime());
        }


        return (T) preWarningVO;
    }

}
