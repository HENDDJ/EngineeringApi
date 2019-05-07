package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 应急预防与准备
 * @author lxw
 */
@ApiModel(value = "应急预防与准备", description = "应急预防与准备")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emergency_prevention")
public class EmergencyPrevention extends BaseEntity {

    /** 应急名称 */
    @ApiModelProperty(value = "应急名称", position = 10, required = true)
    @Column(length = 60)
    private String name;

    /** 应急针对类别 */
    @ApiModelProperty(value = "应急针对类别", position = 10, required = true)
    @Column(length = 60)
    private String type;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    @Column(length = 60)
    private String description;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    @Column(length = 60)
    private String enclosure;

    /** 提交人 */
    @ApiModelProperty(value = "提交人", position = 10, required = true)
    @Column(length = 60)
    private String submitter;


}
