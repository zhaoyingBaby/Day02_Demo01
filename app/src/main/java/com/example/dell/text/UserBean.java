package com.example.dell.text;

/**
 * Created by DELL on 2019/5/29.
 */

public class UserBean {
    private String imgurl;
    private String desc;

    public UserBean() {
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "imgurl='" + imgurl + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public UserBean(String imgurl, String desc) {
        this.imgurl = imgurl;
        this.desc = desc;
    }
}
