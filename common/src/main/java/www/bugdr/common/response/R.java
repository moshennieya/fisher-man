package www.bugdr.common.response;

import lombok.Data;

/**
 * 返回的类
 * 数据有：
 * 1、是否成功：success[true/false] 类型 boolean
 * 2、状态码：code [20000/40000] 类型 int
 * 3、消息：msg，对code的说明，比如说操作成功，操作失败，登录成功。。。 类型 字符串类型
 * 4、返回的数据：data 类型object
 */

@Data
public class R {

    public static final int CODE_SUCCESS = 20000;
    public static final int CODE_FAILED = 40000;

    //是否成功
    private boolean success;
    //状态码
    private int code;
    //描述
    private String msg;
    //数据
    private Object data;

    public R setData(Object data) {
        this.data = data;
        return this;
    }

    // 提供一些静态的方法，可以快速创建返回对象
    public static R SUCCESS(String msg) {
        R r = new R();
        r.code = CODE_SUCCESS;
        r.msg = msg;
        r.success = true;
        return r;
    }

    public static R SUCCESS(String msg, Object data) {
        R success = SUCCESS(msg);
        success.data = data;
        return success;
    }

    public static R FAILED(String msg) {
        R r = new R();
        r.code = CODE_FAILED;
        r.msg = msg;
        r.success = false;
        return r;
    }

    public static R FAILED(String msg, Object data) {
        R success = FAILED(msg);
        success.data = data;
        return success;
    }
}
