package www.bugdr.ucenter.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName("uc_user")
@ApiModel(value = "UcUser对象", description = "")
public class UcUser extends UcUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("盐")
    private String salt;

    @ApiModelProperty("等级")
    private Integer lev = 0;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("头像地址")
    private String avatar;

    @ApiModelProperty("签名")
    private String sign;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("删除标记")
    private String deleted;

    @ApiModelProperty("用户状态")
    private String status;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("更新时间")
    private Date updateTime;

}
