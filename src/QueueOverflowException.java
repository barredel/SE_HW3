/**
 * an exception for trying to add an element to the queue when it is full
 */
public class QueueOverflowException extends QueueException
{
    public QueueOverflowException() {}
    public QueueOverflowException(String message) {
        super(message);
    }
    public QueueOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
