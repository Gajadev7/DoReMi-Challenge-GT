package com.example.geektrust.service;

import com.example.geektrust.Env.Constant;
import com.example.geektrust.Env.Content;
import com.example.geektrust.Env.Plan;
import com.example.geektrust.Env.TopUp;
import com.example.geektrust.IDoReMi;
import com.example.geektrust.entity.Subscription;
import com.example.geektrust.entity.TopUpClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DoReMi implements IDoReMi {

    private final HashMap<String, Integer> priceMap;
    private final HashMap<String, Integer> durationMap;
    private final HashMap<TopUp, Integer> topUpCostMap;
    private LocalDate startDate;
    private final List<Subscription> subscriptionList;
    private TopUpClass topUp;

    public DoReMi() {
        this.subscriptionList = new ArrayList<>();
        this.topUp = null;
        priceMap = Constant.PRICE_MAP;
        durationMap = Constant.DURATION_MAP;
        topUpCostMap = Constant.TOPUP_COST;
    }

    @Override
    public void startSubscription(LocalDate date) {
        this.startDate = date;
    }

    @Override
    public void addSubscription(Content content, Plan plan) {
        if (this.startDate == null) {
            System.out.println("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
            return;
        }
        if (!this.subscriptionList.isEmpty() && contentSubscribedAlready(content)) {
            System.out.println("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
            return;
        }
        String key = content + "|" + plan;
        int price = priceMap.get(key);
        int duration = durationMap.get(key);
        subscriptionList.add(new Subscription(content, plan, duration, price, startDate));
    }

    @Override
    public void addTopUp(TopUp topUp, int noOfMonths) {
        if (this.startDate == null) {
            System.out.println("ADD_TOPUP_FAILED INVALID_DATE");
            return;
        }
        if (this.subscriptionList.isEmpty()) {
            System.out.println("SUBSCRIPTIONS_NOT_FOUND");
            return;
        }
        if (this.topUp != null) {
            System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
            return;
        }
        this.topUp = new TopUpClass(topUp, noOfMonths, topUpCostMap.get(topUp) * noOfMonths);
    }

    @Override
    public void printRenewalDetails() {
        if (this.subscriptionList.isEmpty()) {
            System.out.println("SUBSCRIPTIONS_NOT_FOUND");
            return;
        }
        this.subscriptionList.forEach(subscription -> {
            System.out.println("RENEWAL_REMINDER " + subscription.getContent() + " " + getReminderDate(subscription));
        });

        System.out.println("RENEWAL_AMOUNT " + getTotalRenewalCost());
    }

    private boolean contentSubscribedAlready(Content content) {
        Set<Content> contentSet = this.subscriptionList.stream().map(Subscription::getContent).collect(Collectors.toSet());
        return contentSet.contains(content);
    }

    private int getTotalRenewalCost() {
        int renewalAmount = 0;
        for (Subscription subscription : this.subscriptionList) {
            renewalAmount += subscription.getPrice();
        }
        if (topUp != null) {
            renewalAmount += (topUp.getTopUpCost());
        }
        return renewalAmount;
    }

    private String getReminderDate(Subscription subscription) {
        LocalDate renewalDate = subscription.getEndDate();
        LocalDate reminderDate = renewalDate.minusDays(Constant.reminderDays);
        return reminderDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
