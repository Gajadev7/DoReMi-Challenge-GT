package com.example.geektrust;

import com.example.geektrust.Env.Command;
import com.example.geektrust.Env.Content;
import com.example.geektrust.Env.Plan;
import com.example.geektrust.Env.TopUp;

import java.time.LocalDate;

public interface IParser {
    Command parseCommand(String commandArg);
    LocalDate parseStartDate(String dateArgs);
    Content parseContentType(String contentArgs);
    Plan parsePlanType(String planArgs);
    TopUp parseTopUpType(String topUpArgs);
    int parseNoOfMonths(String noOfMonthsArg);
}
