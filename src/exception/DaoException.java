package exception;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class DaoException extends RuntimeException {
    public DaoException(){}
    public DaoException(String message,Throwable cause){
        super(message, cause);
    }
    public  DaoException(String message){
        super(message);
    }
    public DaoException(Throwable cause){
        super(cause);
    }
}
