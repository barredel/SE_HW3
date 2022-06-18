/**
 * an exception for entering negative max capacity in the ArrayQueue constructor
 */
public class NegativeCapacityException extends QueueException
{
    public NegativeCapacityException() {}
    public NegativeCapacityException(String message) {
        super(message);
    }
    public NegativeCapacityException(String message, Throwable cause) {
        super(message, cause);
    }
}


