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
 * 安全生产规定
 * @author lxw
 */
@ApiModel(value = "安全生产规定", description = "安全生产规定")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "safety_supervision_regulations")
public class SafetyRegulations extends BaseEntity {

    /** 规定名称 */
    @ApiModelProperty(value = "规定名称", position = 0, required = true)
    @Column(length = 60)
    private String name;

    /** 规定名称 */
    @ApiModelProperty(value = "规定类型", position = 2, required = true)
    @Column(length = 60)
    private String type;

    /** 规定名称 */
    @ApiModelProperty(value = "规定描述", position = 4, required = true)
    @Column(length = 60)
    private String descript;

    /** 规定名称 */
    @ApiModelProperty(value = "规定附件", position = 6, required = true)
    @Column(length = 60)
    private String enclosure;

}
