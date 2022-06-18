/**
 * an exception for trying to add a task with a description that already exists
 */
public class TaskAlreadyExistsException extends RuntimeException
{
    public TaskAlreadyExistsException() {}
    public TaskAlreadyExistsException(String message)
        {
        super(message);
        }
    public TaskAlreadyExistsException(String message, Throwable cause)
        {
        super(message, cause);
        }
}
