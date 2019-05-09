package com.cloudkeeper.leasing.identity.dto.emergencyaccidenthandle;

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
 * 应急事故处理方案 DTO
 * @author lxw
 */
@ApiModel(value = "应急事故处理方案 DTO", description = "应急事故处理方案 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyAccidentHandleDTO extends BaseEditDTO {

    /** 事故ID */
    @ApiModelProperty(value = "事故ID", position = 10, required = true)
    private String accidentId;

    /** 处理方案 */
    @ApiModelProperty(value = "处理方案", position = 10, required = true)
    private String solution;

    /** 预防措施 */
    @ApiModelProperty(value = "预防措施", position = 10, required = true)
    private String precaution;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    private String enclosure;

}