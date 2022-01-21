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
@TableName("uc_login_record")
@ApiModel(value = "UcLoginRecord对象", description = "")
public class UcLoginRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("ip地址")
    private String ip;

    @ApiModelProperty("地区")
    private String location;

    @ApiModelProperty("登录来源")
    private String loginFrom;

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLoginFrom() {
        return loginFrom;
    }

    public void setLoginFrom(String loginFrom) {
        this.loginFrom = loginFrom;
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
        return "UcLoginRecord{" +
        "id=" + id +
        ", userId=" + userId +
        ", ip=" + ip +
        ", location=" + location +
        ", loginFrom=" + loginFrom +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
