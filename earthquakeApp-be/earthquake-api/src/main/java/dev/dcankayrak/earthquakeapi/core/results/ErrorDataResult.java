package dev.dcankayrak.earthquakeapi.core.results;

public class ErrorDataResult<T> implements DataResult {
    public String message;
    public boolean success = false;
    public T data;

    public ErrorDataResult (T data) {
        this.data = data;
    }

    public ErrorDataResult (T data, String message) {
        this.data = data;
        this.message = message;
    }

}
