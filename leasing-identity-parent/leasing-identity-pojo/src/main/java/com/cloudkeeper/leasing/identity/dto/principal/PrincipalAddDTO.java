package com.cloudkeeper.leasing.identity.dto.principal;

import com.cloudkeeper.leasing.base.constant.RegConstants;
import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 用户新增 dto
 * @author jerry
 * 各字段校验注解，使用 javax.validation.constraints 包下的注解
 */
@ApiModel(value = "用户新增dto", description = "用户新增dto")
@Getter
@Setter
public class PrincipalAddDTO extends BaseEditDTO {

    /** 登录名*/
    @ApiModelProperty(value = "登录名", position = 10, required = true)
    @NotBlank
    @Length(max = 30)
    private String code;

    /** 头像 */
    @ApiModelProperty(value = "头像", position = 20)
    private String photo;

    /** 姓名*/
    @ApiModelProperty(value = "姓名", position = 12, required = true)
    @NotBlank
    @Length(max = 50)
    private String name;

    /** 密码*/
    @ApiModelProperty(value = "密码", position = 14, required = true)
    @NotBlank
    @Length(min = 6, max = 18)
    private String password;

    /** 手机*/
    @ApiModelProperty(value = "手机", position = 16)
    @Pattern(regexp = RegConstants.PHONE_NUMBER, message = "手机号不正确")
    private String mobile;

    /** 邮箱*/
    @ApiModelProperty(value = "邮箱", position = 18)
    @Email(message = "邮箱格式错误")
    @Length(max = 100)
    private String email;

    /** 描述*/
    @ApiModelProperty(value = "描述", position = 20)
    @Length(max = 1000)
    private String note;

    /** 组织id */
    @ApiModelProperty(value = "组织id", position = 22, required = true)
    @Length(max = 36)
    private String organizationId;

    /** 角色id */
    @ApiModelProperty(value = "角色id", position = 24, required = true)
    @Length(max = 36)
    private String roleId;

    /** 工程id */
    @ApiModelProperty(value = "工程id", position = 24, required = true)
    @Length(max = 36)
    private String proId;

}
