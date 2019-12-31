package com.louiewh.keeprunning.util;

import android.util.Log;


public class LogWrapper {
    private final static String TAG = "KeepRunning";

    public final static int NIO_LOG_NO_PRINT = -1;
    public final static int NIO_LOG_INVALID_PARAMETER = -2;

    private static boolean mIsDebug = true;
    private static boolean mShowLine = true;

    public static void exception(String tag, Throwable throwable) {
        if (mIsDebug) {
            Log.e(TAG, tag + ":" + callMethodAndLine() + throwable.getMessage(), throwable);
        }
    }

    public static void init(boolean isDebug, boolean showLine) {
        mIsDebug = isDebug;
        mShowLine = showLine;
    }

    public static int v(String tag, String msg) {
        if (tag == null || msg == null) return NIO_LOG_INVALID_PARAMETER;
        if (mIsDebug) return Log.v(TAG, callMethodAndLine() + msg);
        else return NIO_LOG_NO_PRINT;
    }

    public static int dWithoutline(String tag, String msg) {
        if (tag == null || msg == null) return NIO_LOG_INVALID_PARAMETER;
        if (mIsDebug) return Log.d(TAG, tag + ":" + msg);
        else return NIO_LOG_NO_PRINT;
    }

    public static int d(String tag, String msg) {
        if (tag == null || msg == null) return NIO_LOG_INVALID_PARAMETER;
        if (mIsDebug) return Log.d(TAG, tag + ":" + callMethodAndLine() + msg);
        else return NIO_LOG_NO_PRINT;
    }

    public static int i(String tag, String msg) {
        if (tag == null || msg == null) return NIO_LOG_INVALID_PARAMETER;
        if (mIsDebug) return Log.i(TAG, tag + ":" + callMethodAndLine() + msg);
        else return Log.i(TAG, tag + ":" + msg);
    }

    public static int w(String tag, String msg) {
        if (tag == null || msg == null) return NIO_LOG_INVALID_PARAMETER;
        if (mIsDebug) return Log.w(TAG, tag + ":" + callMethodAndLine() + msg);
        else return Log.w(TAG, tag + ":" + msg);
    }

    public static int e(String tag, String msg) {
        if (tag == null || msg == null) return NIO_LOG_INVALID_PARAMETER;
        if (mIsDebug) return Log.e(TAG, tag + ":" + callMethodAndLine() + msg);
        else return Log.e(TAG, tag + ":" + msg);
    }

    private static String callMethodAndLine() {
        if (!mShowLine)
            return "";
        String result = "at ";
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];

        result += "." + thisMethodStack.getMethodName();
        result += "(" + thisMethodStack.getFileName();
        result += ":" + thisMethodStack.getLineNumber() + ")  ";

        return result;
    }

    public static void ts(String tag) {
        d(TAG, tag + " ts:" + System.currentTimeMillis() / 1000);
    }
}
