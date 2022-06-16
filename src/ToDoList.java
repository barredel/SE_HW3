import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoList implements TaskIterable , Cloneable
{
    private ArrayList<Task> tasks;
    private ArrayList<Task> tasksSorted;
    private Date scanningDueDate;

    public ToDoList ()
    {
        this.tasks = new ArrayList<Task>();
        this.tasksSorted = new ArrayList<Task>();
        this.scanningDueDate = null;
    }

    @Override
    public void setScanningDueDate(Date scanningDueDate) {
        this.scanningDueDate = scanningDueDate;
    }

    public void addTask(Task task)
    {

    }
    public Iterator <Task> iterator()
    {
        return new ToDoListIterator(this.tasksSorted, this.scanningDueDate);
    }




}


