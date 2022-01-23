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
@TableName("uc_app")
@ApiModel(value = "UcApp对象", description = "")
public class UcApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("应用名称")
    private String appName;

    @ApiModelProperty("创建者")
    private String userId;

    @ApiModelProperty("1表示可用，0表示不可用")
    private String state;

    @ApiModelProperty("应用的id")
    private String appKey;

    @ApiModelProperty("应用秘钥")
    private String appSecret;

    @ApiModelProperty("回调地址")
    private String callbackUrl;

    @ApiModelProperty("图标地址")
    private String appIcon;

    @ApiModelProperty("应用描述")
    private String appDescription;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("更新时间")
    private Date updateTime;

}
