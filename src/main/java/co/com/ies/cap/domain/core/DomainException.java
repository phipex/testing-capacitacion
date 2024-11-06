package co.com.ies.cap.domain.core;

public class DomainException extends Exception{
    
    public static String NO_DATA = "No hay empleado que analizar";

    public DomainException(){
        super();
    }

    public DomainException(String msg){
        super(msg);
    }

    public DomainException(Throwable throwable){
        super(throwable);
    }

}
