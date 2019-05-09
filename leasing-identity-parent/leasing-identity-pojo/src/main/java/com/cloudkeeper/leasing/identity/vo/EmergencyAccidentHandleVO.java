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
 * 应急事故处理方案 VO
 * @author lxw
 */
@ApiModel(value = "应急事故处理方案 VO", description = "应急事故处理方案 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyAccidentHandleVO extends BaseVO {

    /** 事故ID */
    @ApiModelProperty(value = "事故ID", position = 10, required = true)
    private String accidentId;

    /** 处理方案 */
    @ApiModelProperty(value = "处理方案", position = 10, required = true)
    private String solution;

    /** 预防措施 */
    @ApiModelProperty(value = "预防措施", position = 10, required = true)
    private String precaution;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    private String enclosure;

    /** 处理结果 */
    @ApiModelProperty(value = "处理结果", position = 10, required = true)
    private String accidentResult;

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


}
