import java.util.Date;

/**
 * represents a Task
 */
public class Task implements Cloneable
{
    private String description;
    private Date date;

    /**
     * class constructor
     * @param description the description of the task
     * @param date the due date of the task
     */
    public Task(String description,Date date)
    {
        this.description = description;
        this.date = date;
    }

    /**
     * set the due date of the task
     * @param date the due date to update on the task
     */
    public void setDueDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return the due date of the task
     */
    public Date getDate()
    {
        return date;
    }

    /**
     *
     * @return the due date of the task
     */
    public Date getDueDate()
    {
        return this.date;
    }

    /**
     *
     * @return string of the description of the task
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * checks if an object is a task that has the same description and date as this task
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
        if((this.description.equals(otherTask.description))&& (this.date.compareTo(otherTask.date)==0))
        {
            return true;
        }
        return false;
    }

    /**
     *
     * @return string of the description and the due date (in format DD.MM.YYYY) of the task with "," between them.
     */
    @Override
    public String toString()
    {
        String string = description + ", ";
        if(date.getDate() <10)
        {
            string = string + "0" + date.getDate();
        }
        else
        {
            string = string + date.getDate();
        }
        if(date.getMonth() <9)
        {
            string = string + ".0" + (date.getMonth()+1);
        }
        else
        {
            string = string + "." + (date.getMonth()+1);
        }
        string = string + "." + (date.getYear() +1900);
        return string;
    }

    /**
     *
     * @return the hashcode of the description of the task
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
            copy.date = (Date)date.clone();
            return copy;
        } catch (Exception e)
        {
            return null;
        }
    }

}
