package com.cloudkeeper.leasing.identity.dto.emergencyaccident;

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
 * 应急事故 查询DTO
 * @author lxw
 */
@ApiModel(value = "应急事故 查询DTO", description = "应急事故 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyAccidentSearchable extends BaseSearchable {

    /** 事故名称 */
    @ApiModelProperty(value = "事故名称", position = 10, required = true)
    private String name;

    /** 事故发生部门 */
    @ApiModelProperty(value = "事故发生部门", position = 10, required = true)
    private String department;

    /** 事故发生时间 */
    @ApiModelProperty(value = "事故发生时间", position = 10, required = true)
    private LocalDate occurrenceTime;

    /** 负责人 */
    @ApiModelProperty(value = "负责人", position = 10, required = true)
    private String chargePerson;

    /** 当事人姓名 */
    @ApiModelProperty(value = "当事人姓名", position = 10, required = true)
    private String litigantName;

    /** 当事人性别 */
    @ApiModelProperty(value = "当事人性别", position = 10, required = true)
    private String litigantSex;

    /** 当事人出生年月 */
    @ApiModelProperty(value = "当事人出生年月", position = 10, required = true)
    private LocalDate litigantBirth;

    /** 当事人开始工作时间 */
    @ApiModelProperty(value = "当事人开始工作时间", position = 10, required = true)
    private LocalDate litigantWorkTime;

    /** 当事人岗位 */
    @ApiModelProperty(value = "当事人岗位", position = 10, required = true)
    private String litigantPost;

    /** 受伤部位及情况 */
    @ApiModelProperty(value = "受伤部位及情况", position = 10, required = true)
    private String injuredPart;

    /** 事故简述 */
    @ApiModelProperty(value = "事故简述", position = 10, required = true)
    private String accidentPassing;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    private String enclosure;

}