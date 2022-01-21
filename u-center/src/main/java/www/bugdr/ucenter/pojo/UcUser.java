package www.bugdr.ucenter.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author bugdr
 * @since 2022-01-21
 */
@TableName("uc_user")
@ApiModel(value = "UcUser对象", description = "")
public class UcUser implements Serializable {

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
    private Integer lev;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("头像地址")
    private String avatar;

    @ApiModelProperty("签名")
    private String sign;

    @ApiModelProperty("删除标记")
    private String deleted;

    @ApiModelProperty("用户状态")
    private String status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UcUser{" +
        "id=" + id +
        ", userName=" + userName +
        ", password=" + password +
        ", salt=" + salt +
        ", lev=" + lev +
        ", sex=" + sex +
        ", avatar=" + avatar +
        ", sign=" + sign +
        ", deleted=" + deleted +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
