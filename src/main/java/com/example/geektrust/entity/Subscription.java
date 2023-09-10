package com.example.geektrust.entity;

import com.example.geektrust.Env.Content;
import com.example.geektrust.Env.Plan;

import java.time.LocalDate;

public class Subscription {
    private final Content content;
    private final Plan plan;
    private final int months;
    private final int price;
    private final LocalDate startDate;
    private final LocalDate endDate;


    public Subscription(Content content, Plan plan, int months, int price, LocalDate startDate) {
        this.content = content;
        this.plan = plan;
        this.months = months;
        this.price = price;
        this.startDate = startDate;
        this.endDate = calculateEndDate(this.getStartDate(), this.getMonths());
    }

    public Content getContent() {
        return content;
    }

    public Plan getPlan() {
        return plan;
    }

    public int getPrice() {
        return price;
    }

    public int getMonths() {
        return months;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


    public LocalDate calculateEndDate(LocalDate startDate, int duration) {
        return this.startDate.plusMonths(duration);
    }
}
