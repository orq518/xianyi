package com.xianyi.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ${todo}<大列表bean>
 *
 * @author lht
 * @data: on 15/12/01 15:11
 */
public class ClassifyMainListBean extends BaseBean implements Serializable{
    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     */
    private static final long serialVersionUID = 4768927122317982665L;
    /**
     * 种类
     */
    public String type;
    /**
     * 头像地址
     */
    public String icon;
    /**
     * 广告图片地址
     */
    public String adUrl;
    /**
     * 新价钱
     */
    public String price_now;
    /**
     * 旧价钱
     */
    public String price_old;
    /**
     * 时间
     */
    public String time;
    /**
     * 地址
     */
    public String address;
    /**
     * 一张图
     */
    public String oneImage;
    /**
     * 多张图
     */
    public String[] moreImage;
    /**
     * 描述
     */
    public String description;
    /**
     * 留言数
     */
    public String wordsNum;
    /**
     * 收藏数
     */
    public String collectNum;
    /**
     * 转出数
     */
    public String roll_outNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOneImage() {
        return oneImage;
    }

    public void setOneImage(String oneImage) {
        this.oneImage = oneImage;
    }

    public String[] getMoreImage() {
        return moreImage;
    }

    public void setMoreImage(String[] moreImage) {
        this.moreImage = moreImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWordsNum() {
        return wordsNum;
    }

    public void setWordsNum(String wordsNum) {
        this.wordsNum = wordsNum;
    }

    public String getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(String collectNum) {
        this.collectNum = collectNum;
    }

    public String getRoll_outNum() {
        return roll_outNum;
    }

    public void setRoll_outNum(String roll_outNum) {
        this.roll_outNum = roll_outNum;
    }
}


