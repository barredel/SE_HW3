import java.util.Date;

/**
 *
 */
public interface TaskIterable extends  Iterable <Task>
{
    /**
     * Gets the date used when going through a ToDoList
     * @param date - the date used when going through a list
     */
    void setScanningDueDate (Date date);
}
