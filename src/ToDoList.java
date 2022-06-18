import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


/**
 * represents a ToDoList
 */
public class ToDoList implements TaskIterable , Cloneable
{
    private ArrayList<Task> tasks;
    private ArrayList<Task> tasksSorted;
    private Date scanningDueDate;

    /**
     * class constructor
     * Initials "tasks" and "tasksSorted" as arraylists of tasks, one for a list sorted by the order
     * in which the tasks were entered and one for a list sorted by the due date and alphabetically
     * also initializes the scanningDueDate as a null
     */
    public ToDoList ()
    {
        this.tasks = new ArrayList<Task>();
        this.tasksSorted = new ArrayList<Task>();
        this.scanningDueDate = null;
    }

    /**
     * sets the date used when going through a ToDoList
     * If the value of the transferred parameter is null, the iteration will be on all the tasks.
     * otherwise, the iteration will be on all the tasks until the given date (including).
     * @param scanningDueDate the date used when going through a list
     */
    @Override
    public void setScanningDueDate(Date scanningDueDate)
    {
        this.scanningDueDate = scanningDueDate;
    }

    /**
     * Adds a new task to ToDoList, for tasks simply put the task in the next place in the arraylist
     * and for tasksSorted put the task in the appropriate place by the due date so that the arraylist will be
     * sorted in ascending order by the tasks due date
     * @param task a new task to add to the ToDoList
     */
    public void addTask(Task task)
    {
        tasks.add(task);
        for(int i = 0; i<=tasksSorted.size(); i++)
        {
            if(i==tasksSorted.size())
            {
                tasksSorted.add(task);
                return;
            }
            if(tasksSorted.get(i).getDescription().equals(task.getDescription()))
            {
                throw new TaskAlreadyExistsException();
            }
            if(tasksSorted.get(i).getDueDate().compareTo(task.getDueDate()) < 0)
            {
                continue;
            }
            else if(tasksSorted.get(i).getDueDate().compareTo(task.getDueDate()) > 0)
            {
                tasksSorted.add(i, task);
                return;
            }
            else if(tasksSorted.get(i).getDueDate().compareTo(task.getDueDate()) == 0)
                if(tasksSorted.get(i).getDescription().compareTo(task.getDescription()) < 0)
                {
                    continue;
                }
                else if(tasksSorted.get(i).getDescription().compareTo(task.getDescription()) > 0)
                {
                    tasksSorted.add(i, task);
                    return;
                }
        }
    }

    /**
     * @return a ToDoList iterator accordingly to the scanningDueDate (if null or not)
     */
    public Iterator <Task> iterator()
    {
        return new ToDoListIterator(this.tasksSorted, this.scanningDueDate);
    }

    /**
     * checks if an object is a ToDoList that has the same tasks
     * @param other - any other object
     * @return true if is a ToDoList that has the same tasks as this ToDoList, false if not
     */
    @Override
    public boolean equals(Object other)
    {

        if(!(other instanceof ToDoList))
        {
            return false;
        }
        ToDoList otherToDoList = (ToDoList)other;
        if(this.tasksSorted.size() != otherToDoList.tasksSorted.size())
        {
            return false;
        }
        for(int i = 0; i < this.tasksSorted.size(); i++)
        {
            if (!((this.tasksSorted.get(i)).equals(otherToDoList.tasksSorted.get(i))))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * @return string of all the tasks in the ToDoList where each task is surrounded by round parentheses and all the
     * tasks are separated by commas. The entire list is surrounded by square brackets
     */
    @Override
    public String toString()
    {
        String string = "[";
        for (int i = 0; i<this.tasks.size();i++)
        {
            if (i == this.tasks.size() - 1) {
                string = string + "(" + tasks.get(i).toString() + ")";
            } else {
                string = string + "(" + tasks.get(i).toString() + "), ";
            }
        }
        return (string + "]");
    }

    /**
     * @return the hashcode of the first task in the sorted ToDoList
     */
    @Override
    public int hashCode()
    {
        if((this.tasksSorted).size()==0)
        {
            return 0;
        }
        else
        {
            return tasksSorted.get(0).hashCode();
        }
    }


    /**
     * deep clones the ToDoList
     * @return a clone of the ToDoList
     */
    @Override
    public ToDoList clone() {
        try {
            ToDoList copy = (ToDoList) super.clone();
            if(this.scanningDueDate != null)
            {
                copy.scanningDueDate = (Date)this.scanningDueDate.clone();
            }
            else
            {
                copy.scanningDueDate = null;
            }
            copy.tasks = new ArrayList<Task>();
            copy.tasksSorted = new ArrayList<Task>();
            for(int i = 0; i<this.tasks.size(); i++)
            {
                copy.tasks.add(this.tasks.get(i).clone());
                copy.tasksSorted.add(this.tasksSorted.get(i).clone());
            }
            return copy;
        } catch (Exception e) {
            return null;
        }
    }
}







