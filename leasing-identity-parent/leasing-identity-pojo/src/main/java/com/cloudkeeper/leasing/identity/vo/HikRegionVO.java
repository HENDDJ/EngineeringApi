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
 * 海康区域 VO
 * @author lxw
 */
@ApiModel(value = "海康区域 VO", description = "海康区域 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HikRegionVO extends BaseVO {

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