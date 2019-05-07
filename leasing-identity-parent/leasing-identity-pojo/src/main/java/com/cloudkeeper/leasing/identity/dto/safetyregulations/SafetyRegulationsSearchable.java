package com.cloudkeeper.leasing.identity.dto.safetyregulations;

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
 * 安全生产规定 查询DTO
 * @author lxw
 */
@ApiModel(value = "安全生产规定 查询DTO", description = "安全生产规定 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SafetyRegulationsSearchable extends BaseSearchable {

    /** 规定名称 */
    @ApiModelProperty(value = "规定名称", position = 0, required = true)
    private String name;

    /** 规定名称 */
    @ApiModelProperty(value = "规定类型", position = 2, required = true)
    private String type;

    /** 规定名称 */
    @ApiModelProperty(value = "规定描述", position = 4, required = true)
    private String descript;

    /** 规定名称 */
    @ApiModelProperty(value = "规定附件", position = 6, required = true)
    private String enclosure;

}
