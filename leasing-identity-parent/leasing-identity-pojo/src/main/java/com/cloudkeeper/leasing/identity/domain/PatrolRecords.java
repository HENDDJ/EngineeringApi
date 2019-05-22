package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.PatrolRecordsVO;
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
import java.time.LocalDateTime;

/**
 * 巡查记录
 * @author lxw
 */
@ApiModel(value = "巡查记录", description = "巡查记录")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patrol_records")
public class PatrolRecords extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "巡查名称", position = 10, required = true)
    @Column(length = 60)
    private String patrolName;

    /** 名称 */
    @ApiModelProperty(value = "巡查类型", position = 10, required = true)
    @Column(length = 60)
    private String patrolType;

    /** 名称 */
    @ApiModelProperty(value = "巡查对象", position = 10, required = true)
    @Column(length = 60)
    private String patrolObject;

    /** 名称 */
    @ApiModelProperty(value = "巡查时间", position = 10, required = true)
    @Column(length = 60)
    private LocalDateTime patrolTime;

    /** 名称 */
    @ApiModelProperty(value = "巡查人员", position = 10, required = true)
    @Column(length = 60)
    private String patrolPerson;

    /** 名称 */
    @ApiModelProperty(value = "结果", position = 10, required = true)
    @Column(length = 60)
    private String patrolResult;

    /** 名称 */
    @ApiModelProperty(value = "描述", position = 10, required = true)
    @Column(length = 60)
    private String patrolDescribe;

    /** 工程Id */
    @ApiModelProperty(value = "工程Id", position = 10, required = true)
    @Column(length = 60)
    private String proId;

    /** 工程 */
    @ApiModelProperty(value = "工程", position = 28)
    @OneToOne
    @JoinColumn(name = "proId", insertable = false, updatable = false)
    private ProjectInfo projectInfo;


    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        PatrolRecordsVO patrolRecordsVO = (PatrolRecordsVO) convert;
        if(!StringUtils.isEmpty(this.projectInfo)){
            patrolRecordsVO.setProName(this.projectInfo.getName());
        }
        return (T) patrolRecordsVO;
    }

}
