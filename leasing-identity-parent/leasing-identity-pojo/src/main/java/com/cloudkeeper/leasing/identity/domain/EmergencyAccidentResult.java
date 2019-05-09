package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 应急事故处理结果
 * @author lxw
 */
@ApiModel(value = "应急事故处理结果", description = "应急事故处理结果")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emergency_accident_result")
public class EmergencyAccidentResult extends BaseEntity {

    /** 事故ID */
    @ApiModelProperty(value = "事故ID", position = 10, required = true)
    @Column(length = 60)
    private String accidentId;

    /** 处理完成情况 */
    @ApiModelProperty(value = "处理完成情况", position = 10, required = true)
    @Column(length = 60)
    private String solutionGrade;

    /** 处理结果描述 */
    @ApiModelProperty(value = "处理结果描述", position = 10, required = true)
    @Column(length = 60)
    private String solutionResult;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    @Column(length = 60)
    private String enclosure;

    /** 应急事故 */
    @ApiModelProperty(value = "应急事故", position = 28)
    @OneToOne
    @JoinColumn(name = "accidentId", insertable = false, updatable = false)
    private EmergencyAccident emergencyAccident;

}
