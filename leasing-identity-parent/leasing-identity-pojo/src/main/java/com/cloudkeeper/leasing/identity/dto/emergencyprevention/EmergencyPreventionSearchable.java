package com.cloudkeeper.leasing.identity.dto.emergencyprevention;

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
 * 应急预防与准备 查询DTO
 * @author lxw
 */
@ApiModel(value = "应急预防与准备 查询DTO", description = "应急预防与准备 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyPreventionSearchable extends BaseSearchable {

    /** 应急名称 */
    @ApiModelProperty(value = "应急名称", position = 10, required = true)
    private String name;

    /** 应急针对类别 */
    @ApiModelProperty(value = "应急针对类别", position = 10, required = true)
    private String type;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    private String description;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    private String enclosure;

    /** 提交人 */
    @ApiModelProperty(value = "提交人", position = 10, required = true)
    private String submitter;

}