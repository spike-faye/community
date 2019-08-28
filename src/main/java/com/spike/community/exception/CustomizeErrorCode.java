package com.spike.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUNT(2001,"你找的问题不存在，请换一个试试"),
    TARGET_PARAM_NOT_FOUNT(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYSTEM_ERROR(2004,"服务器烧着了，不然您稍后试试？"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"您回复的评论已经不存在"),
    QUESTION_NOT_FOUND(2007,"您回复的问题已经不存在"),
    COMMENT_IS_EMPTY(2008,"输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2009,"不要访问别人信息哦，小老弟"),
    NOTIFICATION_NOT_FOUND(2010,"回复您的消息太害羞，找不到了"),
    FILE_UPLOAD_FAIL(2011,"图片上传失败")
    ;

    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

}
