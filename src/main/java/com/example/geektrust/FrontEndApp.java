package com.example.geektrust;

import com.example.geektrust.Env.Command;
import com.example.geektrust.Env.Content;
import com.example.geektrust.Env.Plan;
import com.example.geektrust.Env.TopUp;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FrontEndApp {

    private final IDoReMi doReMi;
    private final IParser parser;

    public FrontEndApp(IDoReMi doReMi, IParser parser){
        this.doReMi = doReMi;
        this.parser = parser;
    }

    public void getInput(String input){
        String[] args = input.split("\\s+");
        Command command = parser.parseCommand(args[0]);
        processCommand(command, args);
    }

    private void processCommand(Command command, String[] args){
        if(command.equals(Command.START_SUBSCRIPTION)){
            processStartSubscription(args);
        }
        else if(command.equals(Command.ADD_SUBSCRIPTION)){
            processAddSubscription(args);
        }
        else if(command.equals(Command.ADD_TOPUP)){
            processAddTopUp(args);
        }
        else if(command.equals(Command.PRINT_RENEWAL_DETAILS)) {
            processPrintRenewalDetails();
        }
    }

    private void processStartSubscription(String[] args){
        LocalDate dateTime = parser.parseStartDate(args[1]);
        doReMi.startSubscription(dateTime);
    }

    private void processAddSubscription(String[] args){
        Content contentType = parser.parseContentType(args[1]);
        Plan planType = parser.parsePlanType(args[2]);
        doReMi.addSubscription(contentType, planType);
    }

    private void processAddTopUp(String[] args){
        TopUp topUpType = parser.parseTopUpType(args[1]);
        int noOfMonths = parser.parseNoOfMonths(args[2]);
        doReMi.addTopUp(topUpType, noOfMonths);
    }

    private void processPrintRenewalDetails(){
        doReMi.printRenewalDetails();
    }
}
