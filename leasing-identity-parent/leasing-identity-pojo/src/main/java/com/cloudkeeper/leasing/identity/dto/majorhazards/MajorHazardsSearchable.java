package com.cloudkeeper.leasing.identity.dto.majorhazards;

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
 * 重大危险源 查询DTO
 * @author cqh
 */
@ApiModel(value = "重大危险源 查询DTO", description = "重大危险源 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MajorHazardsSearchable extends BaseSearchable {

    /** 工程id */
    @ApiModelProperty(value = "工程id", position = 10, required = true)
    private String proId;

    /** 危险源工作类型 */
    @ApiModelProperty(value = "危险源工作类型", position = 10, required = true)
    private String workType;

    /** 具体描述 */
    @ApiModelProperty(value = "具体描述", position = 10, required = true)
    private String description;

    /** 危害 */
    @ApiModelProperty(value = "危害", position = 10, required = true)
    private String damage;

}