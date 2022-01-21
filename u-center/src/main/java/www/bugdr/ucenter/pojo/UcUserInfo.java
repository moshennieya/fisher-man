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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompony() {
        return compony;
    }

    public void setCompony(String compony) {
        this.compony = compony;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGoodAt() {
        return goodAt;
    }

    public void setGoodAt(String goodAt) {
        this.goodAt = goodAt;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        return "UcUserInfo{" +
        "id=" + id +
        ", userId=" + userId +
        ", phoneNum=" + phoneNum +
        ", email=" + email +
        ", compony=" + compony +
        ", position=" + position +
        ", goodAt=" + goodAt +
        ", birthday=" + birthday +
        ", cover=" + cover +
        ", location=" + location +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
