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
 * 安全生产方式
 * @author lxw
 */
@ApiModel(value = "安全生产方式", description = "安全生产方式")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "safety_supervision_mode")
public class SafetyMode extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 10, required = true)
    @Column(length = 60)
    private String name;

    /** 类型 */
    @ApiModelProperty(value = "类型", position = 10, required = true)
    @Column(length = 60)
    private String type;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    @Column(length = 60)
    private String descript;

    /** 召开时间 */
    @ApiModelProperty(value = "召开时间", position = 10, required = true)
    @Column(length = 60)
    private String startTime;

    /** 召开部门 */
    @ApiModelProperty(value = "召开部门", position = 10, required = true)
    @Column(length = 60)
    private String conveningOrg;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    @Column(length = 60)
    private String enclosure;


}
