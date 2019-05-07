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
import java.time.LocalDateTime;

/**
 * 巡查记录
 * @author lxw
 */
@ApiModel(value = "巡查记录", description = "巡查记录")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patrol_records")
public class PatrolRecords extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "巡查名称", position = 10, required = true)
    @Column(length = 60)
    private String patrolName;

    /** 名称 */
    @ApiModelProperty(value = "巡查类型", position = 10, required = true)
    @Column(length = 60)
    private String patrolType;

    /** 名称 */
    @ApiModelProperty(value = "巡查对象", position = 10, required = true)
    @Column(length = 60)
    private String patrolObject;

    /** 名称 */
    @ApiModelProperty(value = "巡查时间", position = 10, required = true)
    @Column(length = 60)
    private LocalDateTime patrolTime;

    /** 名称 */
    @ApiModelProperty(value = "巡查人员", position = 10, required = true)
    @Column(length = 60)
    private String patrolPerson;

    /** 名称 */
    @ApiModelProperty(value = "结果", position = 10, required = true)
    @Column(length = 60)
    private String patrolResult;

    /** 名称 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    @Column(length = 60)
    private String patrolDescribe;



}
