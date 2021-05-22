package com.snackpub.core.moduel;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 练习信息记录模型
 *
 * @author snackpub
 * @date 2021/5/3
 */
public class PracticeLog implements Serializable {
    private Integer id;
    private String level;
    private Integer count;
    private String curFlag;
    private int userId;
    private String lsh;
    private LocalDateTime createTime;

    public String getCurFlag() {
        return curFlag;
    }

    public void setCurFlag(String curFlag) {
        this.curFlag = curFlag;
    }

    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
