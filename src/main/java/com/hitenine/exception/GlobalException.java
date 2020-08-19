package com.hitenine.exception;

import com.hitenine.constant.ResponseCode;
import lombok.Data;

/**
 * @author Hitenine
 */
@Data
public class GlobalException extends RuntimeException {

    private Integer code;
    private String message;

    public GlobalException(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

}
