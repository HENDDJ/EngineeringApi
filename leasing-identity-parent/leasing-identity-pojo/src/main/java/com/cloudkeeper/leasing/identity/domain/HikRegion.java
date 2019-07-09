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
 * 海康区域
 * @author lxw
 */
@ApiModel(value = "海康区域", description = "海康区域")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hik_region")
public class HikRegion extends BaseEntity {

    /** 区域id */
    @ApiModelProperty(value = "区域id", position = 10, required = true)
    @Column(length = 60)
    private String regionUuid;

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 10, required = true)
    @Column(length = 60)
    private String name;

    /** 是否可用 */
    @ApiModelProperty(value = "是否可用", position = 10, required = true)
    @Column(length = 60)
    private Integer enable;

}
