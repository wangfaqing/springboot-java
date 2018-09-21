package org.wfq.demo.common.util;

/**
 * 错误码定义
 */
public enum ResultEnum {

    // code 200-500  不要用
    Success(0, "成功"),
    systemError(101, "系统错误"),
    nullContent(102, "必要参数为空"),
    getDeviceError(103,"查询设备信息异常"),
    addRailFail(104,"添加围栏失败"),
    updateFail(105,"更新失败"),
    userRegistered(106,"用户已注册"),
    addPetFail(107,"添加宠物失败"),
    getDeviceSiteFail(108,"获取设备位置信息失败"),
    failToSet(109,"更新设置失败"),
    unregistered(110,"用户未注册"),
    isNotSetPassword(111,"用户未设置过密码"),
    userNoBaseInfo(112,"该用户基本信息为空"),
    userRegistFail(113,"用户注册失败"),
    // --- 业务层级的为1-2位数

    deviceIdIsNull(1, "手机设备ID不能为空！"),
    deviceNumberIsNull(2, "物联网设备号不能为空！"),
    petNameIsNull(3, "宠物名称不能为空！"),
    petIconIsNull(4, "宠物头像不能为空！"),
    phoneNumIsNull(5, "手机号参数为空！"),
    phoneNumIsWrong(6, "手机号格式不正确！"),
    sendMessageFail(7, "验证码发送失败！"),
    verificationCodeNotMatch(8,"验证码填写错误"),
    verificationCodeTimeOut(9,"验证码失效"),
    verificationCodeExist(10,"验证码2分钟内有效，无需重新发送"),
    verificationCodeCountLimit(11,"验证码发送次数受限"),
    getUserInfofail(12,"获取用户信息失败"),
    deviceNotOK(13,"设备已激活或不可用，请确认"),
    
   
    checkDeviceException(14,"校验设备异常，请稍后重试"),
    registDeviceException(15,"设备绑定异常"),
    deviceRegistFail(16,"设备激活失败"),
    fileUploadFail(17,"文件上传失败"),
    failToLogin(18,"登入失败"),
    uploadUserIcon(19,"用户icon图片上传异常"),

    // --- 系统层级的为3位数

//    nullContent(102, "必要参数为空"),
    ;
    private final int code;
    private final String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "code: " + code + " , message: " + message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
