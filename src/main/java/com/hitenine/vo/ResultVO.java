package com.hitenine.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hitenine.constant.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Hitenine
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "message", "data", "count"})
public class ResultVO<T> implements Serializable {

    /**
     * 状态码
     */
    Integer code;
    /**
     * 附加信息
     */
    String message;
    /**
     * 分页数据
     */
    Integer count;
    /**
     * 返回数据
     */
    T data;

    public ResultVO() {
    }

    public ResultVO(boolean flag, Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO(boolean flag, Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultVO(boolean flag, Integer code, String message, T data, Integer count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    /* 无数据传输的 成功返回 */
    public static <T> ResultVO<T> success() {
        return new ResultVO<T>(true, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    public static <T> ResultVO<T> success(String message) {
        return new ResultVO<T>(true, ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ResultVO<T> success(ResponseCode resultCode) {
        return new ResultVO<T>(true, resultCode.getCode(), resultCode.getMessage());
    }

    /* 单个数据传输的 成功返回 */
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<T>(true, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> ResultVO<T> success(String message, T data) {
        return new ResultVO<T>(true, ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResultVO<T> success(ResponseCode resultCode, T data) {
        return new ResultVO<T>(true, resultCode.getCode(), resultCode.getMessage(), data);
    }

    /* 分页数据传输的 成功返回 */
    public static <T> ResultVO<T> success(T data, Integer count) {
        return new ResultVO<T>(true, ResponseCode.TABLE_SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data, count);
    }

    public static <T> ResultVO<T> success(String message, T data, Integer count) {
        return new ResultVO<T>(true, ResponseCode.TABLE_SUCCESS.getCode(), message, data, count);
    }

    public static <T> ResultVO<T> success(ResponseCode resultCode, T data, Integer count) {
        return new ResultVO<T>(true, resultCode.getCode(), resultCode.getMessage(), null, count);
    }

    /* 无数据传输的 失败返回 */
    public static <T> ResultVO<T> error() {
        return new ResultVO<T>(false, ResponseCode.SYSTEM_ERROR.getCode(), ResponseCode.SYSTEM_ERROR.getMessage());
    }

    public static <T> ResultVO<T> error(ResponseCode resultCode) {
        return new ResultVO<T>(false, resultCode.getCode(), resultCode.getMessage());
    }

    public static <T> ResultVO<T> error(Integer code, String msg) {
        return new ResultVO<T>(false, code, msg);
    }

}
