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
 * 隐患流程记录 VO
 * @author lxw
 */
@ApiModel(value = "隐患流程记录 VO", description = "隐患流程记录 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HiddenRecordsVO extends BaseVO {

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

    /** 用户姓名 */
    @ApiModelProperty(value = "用户姓名", position = 10, required = true)
    private String createdByName;

}
