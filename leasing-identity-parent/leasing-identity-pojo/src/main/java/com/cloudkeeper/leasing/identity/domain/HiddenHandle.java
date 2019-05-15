package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.HiddenHandleVO;
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
 * 隐患处理结果
 * @author lxw
 */
@ApiModel(value = "隐患处理结果", description = "隐患处理结果")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hidden_handle")
public class HiddenHandle extends BaseEntity {

    /** 隐患Id */
    @ApiModelProperty(value = "隐患Id", position = 10, required = true)
    @Column(length = 60)
    private String issueId;

    /** 处理图片 */
    @ApiModelProperty(value = "处理图片", position = 10, required = true)
    @Column(length = 60)
    private String solveImage;

    /** 处理结果描述 */
    @ApiModelProperty(value = "处理结果描述", position = 10, required = true)
    @Column(length = 60)
    private String solveDes;

    /** 处理完成时间 */
    @ApiModelProperty(value = "处理完成时间", position = 10, required = true)
    @Column(length = 60)
    private LocalDate solveTime;

    /** 附件 */
    @ApiModelProperty(value = "附件", position = 10, required = true)
    @Column(length = 60)
    private String enclosure;

    /** 隐患信息 */
    @ApiModelProperty(value = "隐患信息", position = 28)
    @OneToOne
    @JoinColumn(name = "issueId", insertable = false, updatable = false)
    private HiddenIssue hiddenIssue;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        HiddenHandleVO hiddenHandleVO = (HiddenHandleVO) convert;
        if(!StringUtils.isEmpty(this.hiddenIssue) && !StringUtils.isEmpty(this.hiddenIssue.getHiddenHandle())){
            hiddenHandleVO.setIssueName(this.hiddenIssue.getIssueName());
            hiddenHandleVO.setProjectId(this.hiddenIssue.getProjectId());
            hiddenHandleVO.setStatusName(this.hiddenIssue.getHiddenNode().getNodeDescript());
            hiddenHandleVO.setProjectName(this.hiddenIssue.getProjectInfo().getName());
        }

        return (T) hiddenHandleVO;
    }

}
