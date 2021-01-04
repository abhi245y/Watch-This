package com.abhi245y.watchthis.Models;

import java.util.ArrayList;

public class HomeVerticalListModel {

    int service_code;
    String qurey_name;

    ArrayList<HomeHorizontalListModel> horizontalListModel ;

    public String getQurey_name() {
        return qurey_name;
    }

    public void setQurey_name(String qurey_name) {
        this.qurey_name = qurey_name;
    }

    public int getService_code() {
        return service_code;
    }

    public void setService_code(int service_code) {
        this.service_code = service_code;
    }

    public ArrayList<HomeHorizontalListModel> getHorizontalListModel() {
        return horizontalListModel;
    }

    public void setHorizontalListModel(ArrayList<HomeHorizontalListModel> horizontalListModel) {
        this.horizontalListModel = horizontalListModel;
    }
}
