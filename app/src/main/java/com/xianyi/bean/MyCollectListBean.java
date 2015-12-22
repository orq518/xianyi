package com.xianyi.bean;

import java.io.Serializable;

/**
 * ${todo}<我的收藏bean>
 *
 * @author lht
 * @data: on 15/12/01 15:11
 */
public class MyCollectListBean extends BaseBean implements Serializable{
    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     */
    private static final long serialVersionUID = 4768927122317982665L;
    /**
     * 状态
     */
    public String state;
    /**
     * 新价钱
     */
    public String price_now;
    /**
     * 旧价钱
     */
    public String price_old;
    /**
     * 内容
     */
    public String context;

    /**
     * 类型，0-没有顶部布局，1没有底部布局
     */
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPrice_now() {
        return price_now;
    }

    public void setPrice_now(String price_now) {
        this.price_now = price_now;
    }

    public String getPrice_old() {
        return price_old;
    }

    public void setPrice_old(String price_old) {
        this.price_old = price_old;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}


