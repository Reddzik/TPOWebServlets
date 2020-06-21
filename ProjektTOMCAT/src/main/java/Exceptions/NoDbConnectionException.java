package Exceptions;

public class NoDbConnectionException extends NullPointerException{
    public NoDbConnectionException(String msg){
        super(msg);
    }
}
