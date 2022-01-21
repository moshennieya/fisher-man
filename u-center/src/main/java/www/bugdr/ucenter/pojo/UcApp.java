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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
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
        return "UcApp{" +
        "id=" + id +
        ", appName=" + appName +
        ", userId=" + userId +
        ", state=" + state +
        ", appKey=" + appKey +
        ", appSecret=" + appSecret +
        ", callbackUrl=" + callbackUrl +
        ", appIcon=" + appIcon +
        ", appDescription=" + appDescription +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
