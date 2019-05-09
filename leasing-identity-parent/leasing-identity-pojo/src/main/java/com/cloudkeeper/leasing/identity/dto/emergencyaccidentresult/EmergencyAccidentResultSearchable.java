package com.cloudkeeper.leasing.identity.dto.emergencyaccidentresult;

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
 * 应急事故处理结果 查询DTO
 * @author lxw
 */
@ApiModel(value = "应急事故处理结果 查询DTO", description = "应急事故处理结果 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyAccidentResultSearchable extends BaseSearchable {

    /** 事故ID */
    @ApiModelProperty(value = "事故ID", position = 10, required = true)
    private String accidentId;

    /** 处理完成情况 */
    @ApiModelProperty(value = "处理完成情况", position = 10, required = true)
    private String solutionGrade;

    /** 处理结果描述 */
    @ApiModelProperty(value = "处理结果描述", position = 10, required = true)
    private String solutionResult;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    private String enclosure;

}