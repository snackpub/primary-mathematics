package com.snackpub.core.moduel;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 题目库模型
 *
 * @author snackpub
 * @date 2021/5/3
 */
public class MathProblems implements Serializable {
    private Integer id;
    private Integer operand1;
    private Integer operand2;
    private Integer systemValue;
    private Integer userValue;
    private String curFlag;
    /**
     * 练习信息ID
     */
    private String praLogLsh;
    private String createUser;
    private LocalDateTime createTime;
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCurFlag() {
        return curFlag;
    }

    public void setCurFlag(String curFlag) {
        this.curFlag = curFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public Integer getSystemValue() {
        return systemValue;
    }

    public void setSystemValue(Integer systemValue) {
        this.systemValue = systemValue;
    }

    public Integer getUserValue() {
        return userValue;
    }

    public void setUserValue(Integer userValue) {
        this.userValue = userValue;
    }

    public String getPraLogLsh() {
        return praLogLsh;
    }

    public void setPraLogLsh(String praLogLsh) {
        this.praLogLsh = praLogLsh;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
