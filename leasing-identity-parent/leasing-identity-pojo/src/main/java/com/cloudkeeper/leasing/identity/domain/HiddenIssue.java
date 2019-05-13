package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.HiddenIssueVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * 隐患信息
 * @author lxw
 */
@ApiModel(value = "隐患信息", description = "隐患信息")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hidden_issue")
public class HiddenIssue extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 10, required = true)
    @Column(length = 60)
    private String issueName;

    /** 工程ID */
    @ApiModelProperty(value = "工程ID", position = 10, required = true)
    @Column(length = 60)
    private String projectId;

    /** 用户ID */
    @ApiModelProperty(value = "用户ID", position = 10, required = true)
    @Column(length = 60)
    private String userId;

    /** 部门ID */
    @ApiModelProperty(value = "部门ID", position = 10, required = true)
    @Column(length = 60)
    private String departmentId;

    /** 图片 */
    @ApiModelProperty(value = "图片", position = 10, required = true)
    @Column(length = 60)
    private String issueImage;

    /** 等级 */
    @ApiModelProperty(value = "等级", position = 10, required = true)
    @Column(length = 60)
    private String issueGrade;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    @Column(length = 60)
    private String issueDescript;

    /** 建议 */
    @ApiModelProperty(value = "建议", position = 10, required = true)
    @Column(length = 60)
    private String issueProposal;

    /** 截止日期 */
    @ApiModelProperty(value = "截止日期", position = 10, required = true)
    @Column(length = 60)
    private LocalDate closeDate;

    /** 状态 */
    @ApiModelProperty(value = "状态", position = 10, required = true)
    @Column(length = 60)
    private String status;

    /** 节点 */
    @ApiModelProperty(value = "节点", position = 28)
    @OneToOne
    @JoinColumn(name = "status", insertable = false, updatable = false)
    private HiddenNode hiddenNode;

    /** 用户 */
    @ApiModelProperty(value = "用户", position = 28)
    @OneToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private Principal principal;

    /** 工程 */
    @ApiModelProperty(value = "工程", position = 28)
    @OneToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private ProjectInfo projectInfo;

    /** 部门 */
    @ApiModelProperty(value = "部门", position = 28)
    @OneToOne
    @JoinColumn(name = "departmentId", insertable = false, updatable = false)
    private Organization organization;



    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        HiddenIssueVO hiddenIssueVO = (HiddenIssueVO) convert;
        if(!StringUtils.isEmpty(this.hiddenNode)){
            hiddenIssueVO.setStatusName(this.hiddenNode.getNodeDescript());
        }
        if(!StringUtils.isEmpty(this.principal)){
            hiddenIssueVO.setUserName(this.principal.getName());
        }
        if(!StringUtils.isEmpty(this.projectInfo)){
            hiddenIssueVO.setProjectName(this.projectInfo.getName());
        }
        if(!StringUtils.isEmpty(this.organization)){
            hiddenIssueVO.setDepartmentName(this.organization.getName());
        }

        return (T) hiddenIssueVO;
    }

}
