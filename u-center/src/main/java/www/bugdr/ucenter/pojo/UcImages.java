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
@TableName("uc_images")
@ApiModel(value = "UcImages对象", description = "")
public class UcImages implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("MD5值")
    private String md5;

    @ApiModelProperty("文件名称")
    private String name;

    @ApiModelProperty("url")
    private String url;

    @ApiModelProperty("类型：avatar,app_icon,cover")
    private String type;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("更新时间")
    private Date updateTime;

}
