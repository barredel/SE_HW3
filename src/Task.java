import java.util.Date;
public class Task implements Cloneable
{
    private String description;
    private Date date;

    public Task(String description,Date date)
    {
        this.description = description;
        this.date = date;
    }

    public void setDueDate(Date date) {
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }

    public Date getDueDate()
    {
        return this.date;
    }

    public String getDescription()
    {
        return this.description;
    }

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

    @Override

    public int hashCode()
    {
        return description.hashCode();
    }

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
