import java.util.Date;

/**
 * represents objects that their can be iterated on their Tasks
 */
public interface TaskIterable extends  Iterable <Task>
{
    /**
     * Gets the date used when going through a ToDoList
     * @param date - the date used when going through a list
     */
    void setScanningDueDate (Date date);
}
