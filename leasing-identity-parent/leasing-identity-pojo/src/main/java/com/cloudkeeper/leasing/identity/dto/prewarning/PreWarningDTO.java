package com.cloudkeeper.leasing.identity.dto.prewarning;

import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
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
 * 预警信息 DTO
 * @author lxw
 */
@ApiModel(value = "预警信息 DTO", description = "预警信息 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PreWarningDTO extends BaseEditDTO {

    /** 预警类型 */
    @ApiModelProperty(value = "预警类型", position = 10, required = true)
    private String type;

    /** 预警项目ID */
    @ApiModelProperty(value = "预警项目ID", position = 10, required = true)
    private String typeId;

    /** 预警描述 */
    @ApiModelProperty(value = "预警描述", position = 10, required = true)
    private String warnDescribe;

    /** 工程id */
    @ApiModelProperty(value = "工程id", position = 10, required = true)
    private String proId;

}