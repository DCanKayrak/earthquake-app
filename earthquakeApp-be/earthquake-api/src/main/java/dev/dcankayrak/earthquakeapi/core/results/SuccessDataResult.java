package dev.dcankayrak.earthquakeapi.core.results;

public class SuccessDataResult<T> implements DataResult{
    public String message;
    public boolean success = true;
    public T data;

    public SuccessDataResult (T data) {
        this.data = data;
    }

    public SuccessDataResult (T data, String message) {
        this.data = data;
        this.message = message;
    }
}
