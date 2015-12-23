package com.xianyi.bean;

import java.io.Serializable;

/**
 * ${todo}<我的交易bean>
 *
 * @author lht
 * @data: on 15/12/01 15:11
 */
public class MyTradeListBean extends BaseBean implements Serializable{
    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     */
    private static final long serialVersionUID = 4768927122317982665L;
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
     * 类型，0-人数，1－姓名, 2, 3, 4, 5
     */
    public String type;
    /**
     * 人事或姓名
     */
    public String numOrName;
    /**
     * 文案
     */
    public String tip;
    /**
     * 时间
     */
    public String time;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumOrName() {
        return numOrName;
    }

    public void setNumOrName(String numOrName) {
        this.numOrName = numOrName;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}


