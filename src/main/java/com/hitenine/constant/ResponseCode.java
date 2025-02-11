package com.hitenine.constant;

/**
 * @author Hitenine
 */

public enum ResponseCode {

    /*
    * 400 bad request	常用在参数校验
    401 unauthorized	未经验证的用户，常见于未登录。如果经过验证后依然没权限，应该 403（即 authentication 和 authorization 的区别）。
    403 forbidden	无权限
    404 not found	资源不存在
    500 internal server error	非业务类异常
    503 service unavaliable	由容器抛出，自己的代码不要抛这个异常
    * */

    // 公共请求信息
    SUCCESS(200, "请求成功"),
    TABLE_SUCCESS(0, "请求成功"),
    SYSTEM_ERROR(500, "系统服务异常"),
    PARAMETER_MISSING(600, "参数缺失"),
    PARAMETER_FAULT(700, "参数有误"),
    UNAUTHORIZED(401, "未登录"),
    UNAUTHENTICATED(403, "未授权"),
    OTHER_ERROR(999, "其他未知异常"),
    // ..一真往后面加

    //用户信息
    //5000100 - 5000200
    USERNAME_REPEAT(5000100, "用户名已存在"),
    PHONE_REPEAT(5000101, "手机号已存在"),
    EMAIL_REPEAT(5000102, "邮箱已存在"),
    EMAIL_IDENTITY(5000103, "身份证号已存在"),
    //用户-角色
    //5000201 - 5000300
    USER_ROLE_NO_CLEAR(5000201, "该角色存在用户关联，无法删除");

    private Integer code;

    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessage(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return null;
    }

    public static Integer getCode(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }
}
