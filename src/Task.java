import java.util.Date;

/**
 * represents a Task
 */
public class Task implements Cloneable
{
    private String description;
    private Date dueDate;

    /**
     * class constructor
     * @param description the description of the task
     * @param dueDate the due date of the task
     */
    public Task(String description,Date dueDate)
    {
        this.description = description;
        this.dueDate = dueDate;
    }

    /**
     * set the due date of the task
     * @param dueDate the due date to update the task
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     *
     * @return the due date of the task
     */
    public Date getDueDate()
    {
        return this.dueDate;
    }

    /**
     *
     * @return the string of the description of the task
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * checks if an object is a task and if it has the same description and date as this task
     * @param other - any other object
     * @return true if is a task that has the same description and date as this task, false if not
     */
    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Task))
        {
            return false;
        }
        Task otherTask = (Task)other;
        if((this.description.equals(otherTask.description))&& (this.dueDate.compareTo(otherTask.dueDate)==0))
        {
            return true;
        }
        return false;
    }

    /**
     * @return string of the description and the due date (in format DD.MM.YYYY) of the task with "," between them.
     */
    @Override
    public String toString()
    {
        String string = description + ", ";
        if(dueDate.getDate() <10)
        {
            string = string + "0" + dueDate.getDate();
        }
        else
        {
            string = string + dueDate.getDate();
        }
        if(dueDate.getMonth() <9)
        {
            string = string + ".0" + (dueDate.getMonth()+1);
        }
        else
        {
            string = string + "." + (dueDate.getMonth()+1);
        }
        string = string + "." + (dueDate.getYear() +1900);
        return string;
    }

    /**
     *
     * @return the hashcode based on the hashcode of the description of the task
     */
    @Override
    public int hashCode()
    {
        return description.hashCode();
    }

    /**
     * deep clones the task
     * @return a clone of the task
     */
    @Override
    public Task clone()
    {
        try
        {
            Task copy = (Task)super.clone();
            copy.dueDate = (Date)dueDate.clone();
            return copy;
        } catch (Exception e)
        {
            return null;
        }
    }

}
