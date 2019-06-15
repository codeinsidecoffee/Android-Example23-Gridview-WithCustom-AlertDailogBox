package com.mrlonewolfer.example54;

public class ImageBean {
    int imgId;
    String imgName;

    public ImageBean(int imgId, String imgName) {
        this.imgId = imgId;
        this.imgName = imgName;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
