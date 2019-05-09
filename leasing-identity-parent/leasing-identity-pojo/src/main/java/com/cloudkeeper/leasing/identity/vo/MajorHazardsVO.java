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
 * 重大危险源 VO
 * @author cqh
 */
@ApiModel(value = "重大危险源 VO", description = "重大危险源 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MajorHazardsVO extends BaseVO {

    /** 工程id */
    @ApiModelProperty(value = "工程id", position = 10, required = true)
    private String proId;

    /** 危险源工作类型 */
    @ApiModelProperty(value = "危险源工作类型", position = 10, required = true)
    private String workType;

    /** 具体描述 */
    @ApiModelProperty(value = "具体描述", position = 10, required = true)
    private String description;

    /** 开始时间 */
    @ApiModelProperty(value = "开始时间", position = 10, required = true)
    private LocalDate startTime;

    /** 结束时间 */
    @ApiModelProperty(value = "结束时间", position = 10, required = true)
    private LocalDate endTime;

    /** 危害 */
    @ApiModelProperty(value = "危害", position = 10, required = true)
    private String damage;

    /** 状态 */
    @ApiModelProperty(value = "状态", position = 10, required = true)
    private String state;

    /** 工程名称 */
    @ApiModelProperty(value = "工程名称", position = 26, required = true)
    private String projectName;

}