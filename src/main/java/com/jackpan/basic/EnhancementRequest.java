package com.jackpan.basic;


/**
 * Describes the Request-for-Enhancement (RFE) annotation type.
 * @author jackpan
 * @version v1.0 2020/12/18 00:46
 */
public @interface EnhancementRequest {
    int id();
    String synopsis();
    String engineer() default "[unassigned]";
    String date() default "[unknown]";
}
