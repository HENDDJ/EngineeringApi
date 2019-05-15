package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.HiddenRecordsVO;
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

/**
 * 隐患流程记录
 * @author lxw
 */
@ApiModel(value = "隐患流程记录", description = "隐患流程记录")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hidden_records")
public class HiddenRecords extends BaseEntity {

    /** 隐患Id */
    @ApiModelProperty(value = "隐患Id", position = 10, required = true)
    @Column(length = 60)
    private String issueId;

    /** 上一节点Iｄ */
    @ApiModelProperty(value = "上一节点Iｄ", position = 10, required = true)
    @Column(length = 60)
    private String preNodeId;

    /** 下一点节点Id */
    @ApiModelProperty(value = "下一点节点Id", position = 10, required = true)
    @Column(length = 60)
    private String nextNodeId;

    /** 动作类型 */
    @ApiModelProperty(value = "动作类型", position = 10, required = true)
    @Column(length = 60)
    private String actionType;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    @Column(length = 60)
    private String des;

    /** 隐患信息 */
    @ApiModelProperty(value = "隐患信息", position = 28)
    @ManyToOne
    @JoinColumn(name = "issueId", insertable = false, updatable = false)
    private HiddenIssue hiddenIssue;

    /** 用户信息 */
    @ApiModelProperty(value = "用户信息", position = 28)
    @ManyToOne
    @JoinColumn(name = "createdBy", insertable = false, updatable = false)
    private Principal principal;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        HiddenRecordsVO hiddenRecordsVO = (HiddenRecordsVO) convert;
        if(!StringUtils.isEmpty(this.principal)){
            hiddenRecordsVO.setCreatedByName(this.principal.getName());
        }
        return (T) hiddenRecordsVO;
    }

}
