package www.bugdr.ucenter.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author bugdr
 * @since 2022-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("uc_user_info")
@ApiModel(value = "UcUserInfo对象", description = "")
public class UcUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("手机号")
    private String phoneNum;

    @ApiModelProperty("邮箱地址")
    private String email;

    @ApiModelProperty("公司地址")
    private String compony;

    @ApiModelProperty("职位")
    private String position;

    @ApiModelProperty("擅长")
    private String goodAt;

    @ApiModelProperty("生日")
    private LocalDateTime birthday;

    @ApiModelProperty("封面地址")
    private String cover;

    @ApiModelProperty("所在地")
    private String location;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("更新时间")
    private Date updateTime;

}
