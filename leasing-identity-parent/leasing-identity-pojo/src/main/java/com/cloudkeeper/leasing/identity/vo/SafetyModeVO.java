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
 * 安全生产方式 VO
 * @author lxw
 */
@ApiModel(value = "安全生产方式 VO", description = "安全生产方式 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SafetyModeVO extends BaseVO {

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 10, required = true)
    private String name;

    /** 类型 */
    @ApiModelProperty(value = "类型", position = 10, required = true)
    private String type;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    private String descript;

    /** 召开时间 */
    @ApiModelProperty(value = "召开时间", position = 10, required = true)
    private String startTime;

    /** 召开部门 */
    @ApiModelProperty(value = "召开部门", position = 10, required = true)
    private String conveningOrg;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    private String enclosure;

}