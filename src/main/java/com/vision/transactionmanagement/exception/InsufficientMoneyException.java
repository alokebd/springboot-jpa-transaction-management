package com.vision.transactionmanagement.exception;

public class InsufficientMoneyException extends RuntimeException {

    public InsufficientMoneyException(String message){
        super(message);
    }
}
