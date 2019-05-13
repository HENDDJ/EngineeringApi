package com.cloudkeeper.leasing.identity.dto.hiddenhandle;

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
 * 隐患处理结果 DTO
 * @author lxw
 */
@ApiModel(value = "隐患处理结果 DTO", description = "隐患处理结果 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HiddenHandleDTO extends BaseEditDTO {

    /** 隐患Id */
    @ApiModelProperty(value = "隐患Id", position = 10, required = true)
    private String issueId;

    /** 处理图片 */
    @ApiModelProperty(value = "处理图片", position = 10, required = true)
    private String solveImage;

    /** 处理结果描述 */
    @ApiModelProperty(value = "处理结果描述", position = 10, required = true)
    private String solveDes;

    /** 处理完成时间 */
    @ApiModelProperty(value = "处理完成时间", position = 10, required = true)
    private LocalDate solveTime;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    private String enclosure;

}
