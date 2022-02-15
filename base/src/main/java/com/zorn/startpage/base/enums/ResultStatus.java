package com.zorn.startpage.base.enums;

public enum ResultStatus {
    SUCCESS("请求成功", 200),
    TOKEN_NOT_PROVIDE("未传入token", 101),
    TOKEN_IS_ERROR("token错误", 102),
    TOKEN_IS_EXPIRED("token已过期", 103),
    REFRESH_TOKEN_IS_ERROR("refreshToken错误", 104),
    REFRESH_TOKEN_IS_EXPIRED("refreshToken已过期", 105),
    USER_NOT_EXIST("用户不存在", 106),
    USER_IS_EXIST("用户已存在", 107),
    PASSWORD_IS_ERROR("密码错误", 108),
    CODE_NOT_EXIST("验证码未获取或已过期", 109),
    CODE_IS_ERROR("验证码错误", 110),
    PARAM_IS_ERROR("参数错误", 111),
    PARAM_IS_NULL("参数为空", 112),
//    IMAGE_TYPE_NOT_SUPPORT("不支持的图片格式",113),
//    DEVICE_NOT_EXIST("设备不存在",114),
//    ACCESS_IS_EXIST("授权信息已存在", 115),
//    ACCESS_NOT_EXIST("授权信息不存在", 116),
    GET_CODE_ERROR("获取验证码失败",113),
    FILE_IS_NULL("上传文件为空", 114),
    AUTH_ERROR("鉴权错误", 400),
    WITHOUT_PERMISSION("该用户无此权限", 401),

    TRANSACTIONAL_IS_WORKED("操作失败（事务）",197),
    MISSING_SERVLET_REQUEST_PARAMETER("缺少Servlet请求参数",198),
    DUPLICATE_KEY("唯一值在数据库中重复",199),

    ERROR("操作失败", 500);



    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    ResultStatus(String message, int code){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
