package com.example.bkt2;

public class MainModel {
    String SName,Name,Spec,Color, turl;

    MainModel(){

    }

    public MainModel(String sName, String aname, String aSpec,String aColor, String turl) {
        SName = sName;
        Name =  aname;
        Spec = aSpec;
        Color = aColor;
        this.turl = turl;

    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpec() {
        return Spec;
    }

    public void setSpec(String spec) {
        Spec = spec;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }
}

