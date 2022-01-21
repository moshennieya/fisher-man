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
@TableName("uc_statistics")
@ApiModel(value = "UcStatistics对象", description = "")
public class UcStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("登录天数")
    private Integer loginDay;

    @ApiModelProperty("注册时间")
    private LocalDateTime registerTime;

    @ApiModelProperty("粉丝数")
    private Integer fans;

    @ApiModelProperty("关注数")
    private Integer follows;

    @ApiModelProperty("在线时长")
    private Integer onTime;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
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

    public Integer getLoginDay() {
        return loginDay;
    }

    public void setLoginDay(Integer loginDay) {
        this.loginDay = loginDay;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getFollows() {
        return follows;
    }

    public void setFollows(Integer follows) {
        this.follows = follows;
    }

    public Integer getOnTime() {
        return onTime;
    }

    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
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
        return "UcStatistics{" +
        "id=" + id +
        ", userId=" + userId +
        ", loginDay=" + loginDay +
        ", registerTime=" + registerTime +
        ", fans=" + fans +
        ", follows=" + follows +
        ", onTime=" + onTime +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
