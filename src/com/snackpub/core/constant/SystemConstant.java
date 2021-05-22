package com.snackpub.core.constant;

/**
 * 系统常量
 *
 * @author snackpub
 * @date 2021/1/10
 */
public interface SystemConstant {

    /**
     * 删除标记：0 未删除 1已删除
     */
    int NON_DEL_FLAG = 0;
    int HAV_DEL_FLAG = 1;

    /**
     * 用户类型：1 普通账户 2 超级管理员
     */
    int DEFAULT_USER_TYPE = 1;
    int ADMIN_USER_TYPE = 2;

    /**
     * 当前做题记录：0 当前在做的题目 1 旧练习题
     */
    String CURRENT_FLAG = "0";
    String OLD_FLAG = "1";

}
