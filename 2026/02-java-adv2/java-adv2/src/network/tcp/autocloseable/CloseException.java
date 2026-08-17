package network.tcp.autocloseable;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 6.
 * @fileName : CloseException
 */
public class CloseException extends Exception{
    public CloseException(String message){
        super(message);
    }
}
