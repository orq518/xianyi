package com.xianyi.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ${todo}<数据bean>
 *
 * @author lht
 * @data: on 15/11/24 15:11
 */
public class BannerBean extends BaseBean {

    public List<Licai_banner> slides;

    public class Licai_banner implements Serializable {
        public String img_url;
        public String url;
    }

}


