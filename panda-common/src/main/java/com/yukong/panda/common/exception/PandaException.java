package com.yukong.panda.common.exception;

/**
 * @author: yukong
 * @date: 2018/12/3 09:19
 */
public class PandaException extends RuntimeException{

    public PandaException() {
    }

    public PandaException(String message) {
        super(message);
    }
}
