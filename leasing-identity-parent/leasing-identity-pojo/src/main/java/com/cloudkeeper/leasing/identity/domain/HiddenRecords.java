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
 * 隐患流程记录
 * @author lxw
 */
@ApiModel(value = "隐患流程记录", description = "隐患流程记录")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hidden_records")
public class HiddenRecords extends BaseEntity {

    /** 隐患Id */
    @ApiModelProperty(value = "隐患Id", position = 10, required = true)
    @Column(length = 60)
    private String issueId;

    /** 上一节点Iｄ */
    @ApiModelProperty(value = "上一节点Iｄ", position = 10, required = true)
    @Column(length = 60)
    private String preNodeId;

    /** 下一点节点Id */
    @ApiModelProperty(value = "下一点节点Id", position = 10, required = true)
    @Column(length = 60)
    private String nextNodeId;

    /** 动作类型 */
    @ApiModelProperty(value = "动作类型", position = 10, required = true)
    @Column(length = 60)
    private String actionType;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    @Column(length = 60)
    private String des;

}
