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

}


