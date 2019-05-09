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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
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

    /** 工程id */
    @ApiModelProperty(value = "工程id", position = 10, required = true)
    @Column(length = 60)
    private String proId;

    /** 工程 */
    @ApiModelProperty(value = "工程", position = 24)
    @ManyToOne
    @JoinColumn(name = "proId", insertable = false, updatable = false)
    private ProjectInfo project;

    /** 预警类型 */
    @ApiModelProperty(value = "预警类型", position = 10, required = true)
    @Column(length = 60)
    private String type;

    /** 预警类型 */
    @ApiModelProperty(value = "预警项目ID", position = 10, required = true)
    @Column(length = 60)
    private String typeId;

    /** 重大危险源 */
    @ApiModelProperty(value = "重大危险源", position = 24)
    @ManyToOne()
    @JoinColumn(name = "typeId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private MajorHazards majorHazards;

    /** 预警类型 */
    @ApiModelProperty(value = "预警描述", position = 10, required = true)
    @Column(length = 60)
    private String warnDescribe;

    /** 特种设备信息 */
    @ApiModelProperty(value = "特种设备信息", position = 28)
    @ManyToOne
    @JoinColumn(name = "typeId", insertable = false, updatable = false)
    @NotFound(action=NotFoundAction.IGNORE)
    private SafetyEquipment safetyEquipment;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        PreWarningVO preWarningVO = (PreWarningVO) convert;
        /*if(!StringUtils.isEmpty(this.typeId)){
            if(type=="SPECIAL_EQUIPMENT"){*/
                if(!StringUtils.isEmpty(this.safetyEquipment)) {
                    //特种设备数据赋值
                    preWarningVO.setRegistrationCode(this.safetyEquipment.getRegistrationCode());
                    preWarningVO.setEquipmentType(this.safetyEquipment.getEquipmentType());
                    preWarningVO.setLastInspectionTime(this.safetyEquipment.getLastInspectionTime());
                    preWarningVO.setEquipmentType(this.safetyEquipment.getEquipmentType());
                    preWarningVO.setNextInspectionTime(this.safetyEquipment.getNextInspectionTime());
                }
           /* }*/
          /*  if(type=="MAJOR_HAZARDS") {*/
                if(!StringUtils.isEmpty(this.majorHazards)) {
                    //重大危险源数据赋值
                    preWarningVO.setMajorWorkType(this.majorHazards.getWorkType());
                    preWarningVO.setMajorDescription(this.majorHazards.getDescription());
                    preWarningVO.setMajorStartTime(this.majorHazards.getStartTime());
                    preWarningVO.setMajorEndTime(this.majorHazards.getEndTime());
                    preWarningVO.setMajorDamage(this.majorHazards.getDamage());
                    preWarningVO.setMajorState(this.majorHazards.getState());
                }
           /* }*/
      /*  }*/
        //工程名称赋值
        if(!StringUtils.isEmpty(this.project)){
            preWarningVO.setProjectName(this.project.getName());
        }
        return (T) preWarningVO;
    }

}
