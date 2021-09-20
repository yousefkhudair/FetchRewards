package com.yousefkhudair.interview.controller;

import com.yousefkhudair.interview.model.Payer;
import com.yousefkhudair.interview.model.Spend;
import com.yousefkhudair.interview.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RewardsController {

    // Using a List to record all transactions and later sort by timeStamp
    // Using a Map to record payer and points per payer
    List<Transaction> transactionList = new ArrayList<Transaction>();
    Map<String,Integer> payerMap = new HashMap<String, Integer>();

    //create Transaction for a specific payer & date
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/createTransaction", method = RequestMethod.POST)
    public Transaction createTransaction(@RequestBody Transaction transaction){

        transactionList.add(transaction);

        // if Map contains payer && current payer balance + transaction.points >= 0
        // else add to Map
        if(payerMap.containsKey(transaction.getPayer()) && (transaction.getPoints()+payerMap.get(transaction.getPayer())) >=0 ){
            payerMap.replace(transaction.getPayer(), transaction.getPoints()+payerMap.get(transaction.getPayer()));
        }
        else {
            payerMap.put(transaction.getPayer(),transaction.getPoints());
        }

        return transaction;
    }


    //Spend points
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/spendPoints", method = RequestMethod.POST)
    public List<Payer> spendPoints(@RequestBody Spend spend){

        // Using Map to track amount paid per payer and List to return as requested
        Map<String, Integer> tempMap = new HashMap<String, Integer>();
        List<Payer> payers = new ArrayList<>();

        int amountToSpend = spend.getPoints();

        transactionList.sort(Transaction::compareTo);

        //Iterate through all transactions and apply points to amount requested to spend
        for (Transaction transaction: transactionList) {

            int delta = 0;

            if(amountToSpend > 0){

                if(amountToSpend <= transaction.getPoints()){

                    delta = amountToSpend;
                    amountToSpend = 0;

                }else {

                    amountToSpend = amountToSpend - transaction.getPoints();
                    delta = transaction.getPoints();

                }

                // Updating payer's points amount
                payerMap.replace(transaction.getPayer(),payerMap.get(transaction.getPayer()) - delta);

                if(!tempMap.containsKey(transaction.getPayer())) {
                    tempMap.put(transaction.getPayer(), delta*-1);
                }else{
                    tempMap.replace(transaction.getPayer(),tempMap.get(transaction.getPayer())+(delta*-1));
                }
             }
        }

        // Iterate through temp map to create return List
        for (Map.Entry<String,Integer> payer: tempMap.entrySet()){
            Payer payerObject = new Payer(payer.getKey(),payer.getValue());
            payers.add(payerObject);
        }

        //return  a list  { "payer": <string>, "points": <integer> }
        return payers;
    }

    //Return all payer points
    @RequestMapping(path = "/pointsBalance", method = RequestMethod.GET)
    public Map<String, Integer> pointsBalance() {

        return payerMap;
    }
}
