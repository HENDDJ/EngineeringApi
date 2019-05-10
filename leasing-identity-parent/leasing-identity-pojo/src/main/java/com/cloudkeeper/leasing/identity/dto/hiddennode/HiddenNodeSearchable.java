package com.cloudkeeper.leasing.identity.dto.hiddennode;

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
 * 隐患节点信息 查询DTO
 * @author lxw
 */
@ApiModel(value = "隐患节点信息 查询DTO", description = "隐患节点信息 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HiddenNodeSearchable extends BaseSearchable {

    /** 上一节点Iｄ */
    @ApiModelProperty(value = "上一节点Iｄ", position = 10, required = true)
    private String preNodeId;

    /** 下一点节点Id */
    @ApiModelProperty(value = "下一点节点Id", position = 10, required = true)
    private String nextNodeId;

    /** 节点描述 */
    @ApiModelProperty(value = "节点描述", position = 10, required = true)
    private String nodeDescript;

}