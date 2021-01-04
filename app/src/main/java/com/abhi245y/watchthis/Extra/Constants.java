package com.abhi245y.watchthis.Extra;

import java.util.HashMap;

public class Constants {

    public static String getOMDb_API_KEY() {
        return "9a7a1eb3";
    }

    public static String getTMDb_API_KEY() {
        return "7d8ad71f7e277923665d1197cb77e46b";
    }


    public static HashMap<Integer, String> getGenerCode() {
        java.util.HashMap<Integer,String> generCode=new HashMap<>();

        generCode.put(28,"Action");
        generCode.put(12,"Adventure");
        generCode.put(16,"Animation");
        generCode.put(35,"Comedy");
        generCode.put(80,"Crime");
        generCode.put(99,"Documentary");
        generCode.put(18,"Drama");
        generCode.put(10751,"Family");
        generCode.put(14,"Fantasy");
        generCode.put(36,"History");
        generCode.put(27,"Horror");
        generCode.put(10402,"Music");
        generCode.put(9648,"Mystery");
        generCode.put(10749,"Romance");
        generCode.put(878,"Science Fiction");
        generCode.put(10770,"TV Movie");
        generCode.put(53,"Thriller");
        generCode.put(10752,"War");
        generCode.put(37,"Western");
        return generCode;
    }

    public static HashMap<String, String> getLanguageCode() {
        java.util.HashMap<String,String> languageCode=new HashMap<>();

        languageCode.put("en","English");
        languageCode.put("ml","Malayalam");
        languageCode.put("hi","Hindi");
        languageCode.put("ta","Tamil");
        languageCode.put("te","Telugu");
        languageCode.put("kn","Kannada");
        return languageCode;
    }

    public static HashMap<Integer, String> getServices(){
        java.util.HashMap<Integer,String> serviceList=new HashMap<>();
        serviceList.put(1,"YTS Torrent");
        serviceList.put(2,"Just Watch");
        serviceList.put(3,"The Movie Database");
        return serviceList;
    }

    public static HashMap<Integer, Integer> getProviderId(){
        java.util.HashMap<Integer,Integer> providerId=new HashMap<>();
        providerId.put(8,430997);
        providerId.put(119,52449861);
        providerId.put(377,174849096);
        providerId.put(122,174849096);
        providerId.put(220,85114140);
        providerId.put(232,93795879);
        providerId.put(218,82869265);
        providerId.put(237,99832956);
        providerId.put(309,138047862);
        providerId.put(175,14385750);
        providerId.put(437,201704934);
        return providerId;
    }
}
