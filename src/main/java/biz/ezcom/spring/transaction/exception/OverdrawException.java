package biz.ezcom.spring.transaction.exception;

/**
 * 透支异常
 */
public class OverdrawException extends RuntimeException {
    private static final long serialVersionUID = 1846489281819923566L;

    public OverdrawException(String msg) {
        super(msg);
    }
}
