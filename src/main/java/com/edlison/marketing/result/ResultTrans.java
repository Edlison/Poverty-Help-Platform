package com.edlison.marketing.result;

public class ResultTrans {
    public static boolean isOK(SystemResult systemResult) {
        return systemResult.getStatus() % 10 == 0;
    }
}
