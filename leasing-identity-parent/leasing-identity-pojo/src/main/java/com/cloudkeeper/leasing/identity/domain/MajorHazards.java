package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.MajorHazardsVO;
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
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 重大危险源
 * @author cqh
 */
@ApiModel(value = "重大危险源", description = "重大危险源")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "major_hazards")
public class MajorHazards extends BaseEntity {

    /** 工程id */
    @ApiModelProperty(value = "工程id", position = 10, required = true)
    @Column(length = 60)
    private String proId;

    /** 工程 */
    @ApiModelProperty(value = "工程", position = 24)
    @ManyToOne
    @JoinColumn(name = "proId", insertable = false, updatable = false)
    private ProjectInfo project;

    /** 危险源工作类型 */
    @ApiModelProperty(value = "危险源工作类型", position = 10, required = true)
    @Column(length = 60)
    private String workType;

    /** 具体描述 */
    @ApiModelProperty(value = "具体描述", position = 10, required = true)
    @Column(length = 60)
    private String description;

    /** 开始时间 */
    @ApiModelProperty(value = "开始时间", position = 10, required = true)
    @Column(length = 60)
    private LocalDate startTime;

    /** 结束时间 */
    @ApiModelProperty(value = "结束时间", position = 10, required = true)
    @Column(length = 60)
    private LocalDate endTime;

    /** 危害 */
    @ApiModelProperty(value = "危害", position = 10, required = true)
    @Column(length = 60)
    private String damage;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        MajorHazardsVO majorHazardsVO = (MajorHazardsVO) convert;
        if(!StringUtils.isEmpty(this.project)){
            majorHazardsVO.setProjectName(this.project.getName());
        }
        return (T) majorHazardsVO;
    }

}