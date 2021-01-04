package com.abhi245y.watchthis.Models;

import java.util.ArrayList;

public class WatchOptionsModel {

    String service_link,monetization_type;
    String service_name;
    ArrayList<TelegramResultsModel> telegramResultsModel;
    private int provider_id;


    public WatchOptionsModel(String service_name, String service_link, String monetization_type, int provider_id) {
        this.service_name = service_name;
        this.service_link = service_link;
        this.monetization_type = monetization_type;
        this.provider_id = provider_id;
    }

    public WatchOptionsModel(ArrayList<TelegramResultsModel> telegramResultsModel,String service_name) {
        this.service_name = service_name;
        this.telegramResultsModel = telegramResultsModel;
    }

    public ArrayList<TelegramResultsModel> getTelegramResultsModel() {
        return telegramResultsModel;
    }

    public String getService_name() {
        return service_name;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public String getService_link() {
        return service_link;
    }

    public String getMonetization_type() {
        return monetization_type;
    }

}
