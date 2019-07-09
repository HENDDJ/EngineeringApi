package com.cloudkeeper.leasing.identity.dto.hikregion;

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
 * 海康区域 查询DTO
 * @author lxw
 */
@ApiModel(value = "海康区域 查询DTO", description = "海康区域 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HikRegionSearchable extends BaseSearchable {

    /** 区域id */
    @ApiModelProperty(value = "区域id", position = 10, required = true)
    private String regionUuid;

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 10, required = true)
    private String name;

    /** 是否可用 */
    @ApiModelProperty(value = "是否可用", position = 10, required = true)
    private Integer enable;

}