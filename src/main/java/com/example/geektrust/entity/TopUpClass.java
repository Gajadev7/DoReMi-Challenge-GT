package com.example.geektrust.entity;

import com.example.geektrust.Env.TopUp;

public class TopUpClass {

    private final TopUp topUpType;
    private final int topUpMonths;
    private final int topUpCost;

    public TopUpClass(TopUp topUpType, int topUpMonths, int topUpCost) {
        this.topUpCost = topUpCost;
        this.topUpMonths = topUpMonths;
        this.topUpType = topUpType;
    }


    public int getTopUpMonths() {
        return topUpMonths;
    }


    public int getTopUpCost() {
        return topUpCost;
    }

    public TopUp getTopUpType() {
        return topUpType;
    }

}
