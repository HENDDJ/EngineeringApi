package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.EmergencyAccidentHandleVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.persistence.*;

/**
 * 应急事故处理方案
 * @author lxw
 */
@ApiModel(value = "应急事故处理方案", description = "应急事故处理方案")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emergency_accident_handle")
public class EmergencyAccidentHandle extends BaseEntity {

    /** 事故ID */
    @ApiModelProperty(value = "事故ID", position = 10, required = true)
    @Column(length = 60)
    private String accidentId;

    /** 处理方案 */
    @ApiModelProperty(value = "处理方案", position = 10, required = true)
    @Column(length = 60)
    private String solution;

    /** 预防措施 */
    @ApiModelProperty(value = "预防措施", position = 10, required = true)
    @Column(length = 60)
    private String precaution;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    @Column(length = 60)
    private String enclosure;


    /** 应急事故 */
    @ApiModelProperty(value = "应急事故", position = 28)
    @OneToOne
    @JoinColumn(name = "accidentId", insertable = false, updatable = false)
    private EmergencyAccident emergencyAccident;

    /** 判断有无结果 */
    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        EmergencyAccidentHandleVO emergencyAccidentHandleVO = (EmergencyAccidentHandleVO) convert;
        if(!StringUtils.isEmpty(this.getEmergencyAccident()) && !StringUtils.isEmpty(this.getEmergencyAccident().getEmergencyAccidentResult())){
            emergencyAccidentHandleVO.setAccidentResult("1");
        }else{
            emergencyAccidentHandleVO.setAccidentResult("0");
        }
        emergencyAccidentHandleVO.setName(this.emergencyAccident.getName());
        emergencyAccidentHandleVO.setDepartment(this.emergencyAccident.getDepartment());
        emergencyAccidentHandleVO.setOccurrenceTime(this.emergencyAccident.getOccurrenceTime());
        emergencyAccidentHandleVO.setChargePerson(this.emergencyAccident.getChargePerson());
        emergencyAccidentHandleVO.setLitigantName(this.emergencyAccident.getLitigantName());
        return (T) emergencyAccidentHandleVO;
    }



}
