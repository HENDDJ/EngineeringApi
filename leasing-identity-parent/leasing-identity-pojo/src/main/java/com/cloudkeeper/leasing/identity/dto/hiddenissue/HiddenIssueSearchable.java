package com.cloudkeeper.leasing.identity.dto.hiddenissue;

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
 * 隐患信息 查询DTO
 * @author lxw
 */
@ApiModel(value = "隐患信息 查询DTO", description = "隐患信息 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HiddenIssueSearchable extends BaseSearchable {

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 10, required = true)
    private String issueName;

    /** 工程ID */
    @ApiModelProperty(value = "工程ID", position = 10, required = true)
    private String projectId;

    /** 用户ID */
    @ApiModelProperty(value = "用户ID", position = 10, required = true)
    private String userId;

    /** 部门ID */
    @ApiModelProperty(value = "部门ID", position = 10, required = true)
    private String departmentId;

    /** 图片 */
    @ApiModelProperty(value = "图片", position = 10, required = true)
    private String issueImage;

    /** 等级 */
    @ApiModelProperty(value = "等级", position = 10, required = true)
    private String issueGrade;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    private String issueDescript;

    /** 建议 */
    @ApiModelProperty(value = "建议", position = 10, required = true)
    private String issueProposal;

    /** 截止日期 */
    @ApiModelProperty(value = "截止日期", position = 10, required = true)
    private LocalDate closeDate;

    /** 状态 */
    @ApiModelProperty(value = "状态", position = 10, required = true)
    private String status;

}