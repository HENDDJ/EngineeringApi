package com.cloudkeeper.leasing.identity.dto.hiddenrecords;

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
 * 隐患流程记录 查询DTO
 * @author lxw
 */
@ApiModel(value = "隐患流程记录 查询DTO", description = "隐患流程记录 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HiddenRecordsSearchable extends BaseSearchable {

    /** 隐患Id */
    @ApiModelProperty(value = "隐患Id", position = 10, required = true)
    private String issueId;

    /** 上一节点Iｄ */
    @ApiModelProperty(value = "上一节点Iｄ", position = 10, required = true)
    private String preNodeId;

    /** 下一点节点Id */
    @ApiModelProperty(value = "下一点节点Id", position = 10, required = true)
    private String nextNodeId;

    /** 动作类型 */
    @ApiModelProperty(value = "动作类型", position = 10, required = true)
    private String actionType;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    private String des;

}