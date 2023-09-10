package com.example.geektrust.service;

import com.example.geektrust.Env.Command;
import com.example.geektrust.Env.Content;
import com.example.geektrust.Env.Plan;
import com.example.geektrust.Env.TopUp;
import com.example.geektrust.IParser;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parser implements IParser {

    public Command parseCommand(String commandArg) {
        Command command;
        try {
            command = Command.valueOf(commandArg);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Please provide a valid command");
        }
        return command;
    }

    public LocalDate parseStartDate(String dateArgs) {
        LocalDate dateTime = null;
        try {
            dateTime = LocalDate.parse(dateArgs, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeException e) {
            System.out.println("INVALID_DATE");
        }
        return dateTime;
    }

    public Content parseContentType(String contentArgs) {
        Content contentType;
        try {
            contentType = Content.valueOf(contentArgs);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Please provide the valid content type");
        }
        return contentType;
    }

    public Plan parsePlanType(String planArgs) {
        Plan planType;
        try {
            planType = Plan.valueOf(planArgs);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Please provide the valid plan type");
        }
        return planType;
    }

    public TopUp parseTopUpType(String topUpArgs) {

        TopUp topUpType;
        try {
            topUpType = TopUp.valueOf(topUpArgs);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Please provide a valid topup plan type");
        }
        return topUpType;
    }

    public int parseNoOfMonths(String noOfMonthsArg) {
        int noOfMonths;
        try {
            noOfMonths = Integer.parseInt(noOfMonthsArg);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Please provide a valid integer for no of months");
        }
        return noOfMonths;
    }
}
