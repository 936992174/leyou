package com.leyou.common.Exception;

import com.leyou.common.enums.ExceptionEnum;

/**
 * @Author: 98050
 * @Time: 2018-11-05 16:07
 * @Feature:
 */
public class LyException extends RuntimeException {

    public LyException(ExceptionEnum exception) {
        super(exception.toString());
    }
}
