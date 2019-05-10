package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

}
