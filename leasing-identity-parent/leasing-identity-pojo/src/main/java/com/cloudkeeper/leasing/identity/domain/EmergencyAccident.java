package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.EmergencyAccidentVO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * 应急事故
 * @author lxw
 */
@ApiModel(value = "应急事故", description = "应急事故")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emergency_accident")
public class EmergencyAccident extends BaseEntity {

    /** 事故名称 */
    @ApiModelProperty(value = "事故名称", position = 10, required = true)
    @Column(length = 60)
    private String name;

    /** 事故发生部门 */
    @ApiModelProperty(value = "事故发生部门", position = 10, required = true)
    @Column(length = 60)
    private String department;

    /** 事故发生时间 */
    @ApiModelProperty(value = "事故发生时间", position = 10, required = true)
    @Column(length = 60)
    private LocalDate occurrenceTime;

    /** 负责人 */
    @ApiModelProperty(value = "负责人", position = 10, required = true)
    @Column(length = 60)
    private String chargePerson;

    /** 当事人姓名 */
    @ApiModelProperty(value = "当事人姓名", position = 10, required = true)
    @Column(length = 60)
    private String litigantName;

    /** 当事人姓名 */
    @ApiModelProperty(value = "当事人性别", position = 10, required = true)
    @Column(length = 60)
    private String litigantSex;

    /** 当事人姓名 */
    @ApiModelProperty(value = "当事人出生年月", position = 10, required = true)
    @Column(length = 60)
    private LocalDate litigantBirth;

    /** 当事人姓名 */
    @ApiModelProperty(value = "当事人开始工作时间", position = 10, required = true)
    @Column(length = 60)
    private LocalDate litigantWorkTime;

    /** 当事人岗位 */
    @ApiModelProperty(value = "当事人岗位", position = 10, required = true)
    @Column(length = 60)
    private String litigantPost;

    /** 受伤部位及情况 */
    @ApiModelProperty(value = "受伤部位及情况", position = 10, required = true)
    @Column(length = 60)
    private String injuredPart;

    /** 事故简述 */
    @ApiModelProperty(value = "事故简述", position = 10, required = true)
    @Column(length = 60)
    private String accidentPassing;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    @Column(length = 60)
    private String enclosure;

    /** 处理方案 */
    @ApiModelProperty(value = "处理方案", position = 10, required = true)
    @JsonIgnore
    @JsonBackReference
    @OneToOne(mappedBy = "emergencyAccident")
    private EmergencyAccidentHandle emergencyAccidentHandle;

    /** 处理结果 */
    @ApiModelProperty(value = "处理结果", position = 10, required = true)
    @JsonIgnore
    @JsonBackReference
    @OneToOne(mappedBy = "emergencyAccident")
    private EmergencyAccidentResult emergencyAccidentResult;

    /** 判断有无吹方案与结果 */
    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        EmergencyAccidentVO emergencyAccidentVO = (EmergencyAccidentVO) convert;
        if(!StringUtils.isEmpty(this.emergencyAccidentHandle)){
            emergencyAccidentVO.setEmergencyAccidentHandle("1");
            emergencyAccidentVO.setSolution(this.emergencyAccidentHandle.getSolution());
            emergencyAccidentVO.setPrecaution(this.emergencyAccidentHandle.getPrecaution());
            emergencyAccidentVO.setHandleEnclosure(this.emergencyAccidentHandle.getEnclosure());
        }else{
            emergencyAccidentVO.setEmergencyAccidentHandle("0");
        }
        if(!StringUtils.isEmpty(this.emergencyAccidentResult)){
            emergencyAccidentVO.setEmergencyAccidentResult("1");
            emergencyAccidentVO.setSolutionGrade(this.emergencyAccidentResult.getSolutionGrade());
            emergencyAccidentVO.setSolutionResult(this.emergencyAccidentResult.getSolutionResult());
            emergencyAccidentVO.setResultEnclosure(this.emergencyAccidentResult.getEnclosure());

        }else{
            emergencyAccidentVO.setEmergencyAccidentResult("0");
        }

        return (T) emergencyAccidentVO;
    }



}
