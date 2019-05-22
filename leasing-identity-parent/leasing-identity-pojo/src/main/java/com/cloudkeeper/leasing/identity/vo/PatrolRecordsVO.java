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
 * 巡查记录 VO
 * @author lxw
 */
@ApiModel(value = "巡查记录 VO", description = "巡查记录 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PatrolRecordsVO extends BaseVO {

    /** 巡查名称 */
    @ApiModelProperty(value = "巡查名称", position = 10, required = true)
    private String patrolName;

    /** 巡查类型 */
    @ApiModelProperty(value = "巡查类型", position = 10, required = true)
    private String patrolType;

    /** 巡查对象 */
    @ApiModelProperty(value = "巡查对象", position = 10, required = true)
    private String patrolObject;

    /** 巡查时间 */
    @ApiModelProperty(value = "巡查时间", position = 10, required = true)
    private LocalDateTime patrolTime;

    /** 巡查人员 */
    @ApiModelProperty(value = "巡查人员", position = 10, required = true)
    private String patrolPerson;

    /** 结果 */
    @ApiModelProperty(value = "结果", position = 10, required = true)
    private String patrolResult;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    private String patrolDescribe;

    /** 工程Id */
    @ApiModelProperty(value = "工程Id", position = 10, required = true)
    private String proId;

    /** 工程 */
    @ApiModelProperty(value = "工程", position = 10, required = true)
    private String proName;



}
