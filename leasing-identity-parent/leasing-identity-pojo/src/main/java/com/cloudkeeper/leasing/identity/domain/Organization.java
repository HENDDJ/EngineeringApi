package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.enumeration.OrganizationTypeEnum;
import com.cloudkeeper.leasing.identity.vo.OrganizationVO;
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
 * 组织
 * @author jerry
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ck_id_organization")
public class Organization extends BaseEntity {

    /** 编码 */
    @ApiModelProperty(value = "编码", position = 10, required = true)
    @Column(length = 24)
    private String code;

    /** 全编码 */
    @ApiModelProperty(value = "全编码", position = 11, required = true)
    @Column(length = 250)
    private String fullCode;

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 12, required = true)
    @Column(length = 50)
    private String name;

    /** 父id */
    @ApiModelProperty(value = "父id", position = 14)
    @Column(length = 30)
    private String parentId;

    /** 父组织名称 */
    @ApiModelProperty(value = "工程", position = 24)
    @ManyToOne
    @JoinColumn(name = "parentId", insertable = false, updatable = false)
    private Organization organization;

    /** 组织类型 */
    @ApiModelProperty(value = "组织类型", position = 16, required = true)
    @Enumerated(value = EnumType.STRING)
    @Column(length = 30)
    private OrganizationTypeEnum type;

    /** 排序 */
    @ApiModelProperty(value = "排序", position = 18, required = true)
    private Integer sort;

    /** 描述 */
    @ApiModelProperty(value = "描述", position = 20)
    @Column(length = 1000)
    private String note;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        OrganizationVO organizationVO = (OrganizationVO) convert;
        if(!StringUtils.isEmpty(this.organization)){
            organizationVO.setParentOrganizationName(this.organization.getName());
        }
        return (T) organizationVO;
    }
}
