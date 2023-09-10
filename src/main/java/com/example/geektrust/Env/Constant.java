package com.example.geektrust.Env;

import java.util.HashMap;

public class Constant {

    public static final int reminderDays = 10;
    public static final HashMap<String, Integer> PRICE_MAP = initPriceMap();
    public static final HashMap<String, Integer> DURATION_MAP = initDurationMap();
     public static final HashMap<TopUp, Integer> TOPUP_COST = initTopUpCostMap();

    private static HashMap<String, Integer> initPriceMap(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put(Content.MUSIC +"|"+Plan.FREE,0);
        map.put(Content.MUSIC +"|"+Plan.PERSONAL,100);
        map.put(Content.MUSIC +"|"+Plan.PREMIUM,250);
        map.put(Content.VIDEO +"|"+Plan.FREE,0);
        map.put(Content.VIDEO +"|"+Plan.PERSONAL,200);
        map.put(Content.VIDEO +"|"+Plan.PREMIUM,500);
        map.put(Content.PODCAST +"|"+Plan.FREE,0);
        map.put(Content.PODCAST +"|"+Plan.PERSONAL,100);
        map.put(Content.PODCAST +"|"+Plan.PREMIUM,300);

        return map;
    }

    private static HashMap<String, Integer> initDurationMap(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put(Content.MUSIC +"|"+Plan.FREE,1);
        map.put(Content.MUSIC +"|"+Plan.PERSONAL,1);
        map.put(Content.MUSIC +"|"+Plan.PREMIUM,3);
        map.put(Content.VIDEO +"|"+Plan.FREE,1);
        map.put(Content.VIDEO +"|"+Plan.PERSONAL,1);
        map.put(Content.VIDEO +"|"+Plan.PREMIUM,3);
        map.put(Content.PODCAST +"|"+Plan.FREE,1);
        map.put(Content.PODCAST +"|"+Plan.PERSONAL,1);
        map.put(Content.PODCAST +"|"+Plan.PREMIUM,3);

        return map;
    }

    private static HashMap<TopUp, Integer> initTopUpCostMap(){
        HashMap<TopUp, Integer> map = new HashMap<>();

        map.put(TopUp.FOUR_DEVICE,50);
        map.put(TopUp.TEN_DEVICE,100);


        return map;
    }
}
