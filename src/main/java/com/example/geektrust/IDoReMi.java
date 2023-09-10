package com.example.geektrust;

import com.example.geektrust.Env.Content;
import com.example.geektrust.Env.Plan;
import com.example.geektrust.Env.TopUp;

import java.time.LocalDate;

public interface IDoReMi {
    public void startSubscription(LocalDate date);
    public void addSubscription(Content content, Plan plan);
    public  void addTopUp(TopUp topUp, int noOfMonths);
    public void printRenewalDetails();

}
