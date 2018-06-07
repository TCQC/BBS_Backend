package com.tcqc.bbs.util.format;

public class FormatResultGenerator {

    public static <T> FormatResult<T> genResult(boolean status,T data, String message) {
        FormatResult<T> result = new FormatResult<>(status, data, message);
        return result;
    }

    public static <T> FormatResult<T> genSuccessResult(T data) {

        return genResult(true, data, "");
    }

    public static <T> FormatResult<T> genSuccessResult() {

        return genResult(true, null, "");
    }

    public static <T> FormatResult<T> genErrorResult( String message) {

        return genResult(false, null, message);
    }

}
