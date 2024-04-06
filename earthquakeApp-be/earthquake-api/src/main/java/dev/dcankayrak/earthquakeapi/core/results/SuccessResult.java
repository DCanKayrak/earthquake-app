package dev.dcankayrak.earthquakeapi.core.results;

public class SuccessResult implements Result{
    public String message;
    public boolean success = true;

    public SuccessResult(){

    }
    public SuccessResult(String message) {
        this.message = message;
    }
}
