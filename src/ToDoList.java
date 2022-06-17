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
    public void setScanningDueDate(Date scanningDueDate)
    {
        this.scanningDueDate = scanningDueDate;
    }

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
            if(tasksSorted.get(i).getDate().compareTo(task.getDate()) < 0)
            {
                continue;
            }
            else if(tasksSorted.get(i).getDate().compareTo(task.getDate()) > 0)
            {
                tasksSorted.add(i, task);
                return;
            }
            else if(tasksSorted.get(i).getDate().compareTo(task.getDate()) == 0)
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
    public Iterator <Task> iterator()
    {
        return new ToDoListIterator(this.tasksSorted, this.scanningDueDate);
    }

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

    @Override

    public String toString()
    {
        String string = "[";
        for (int i = 0; i<this.tasks.size();i++)
        {
            if (i == this.tasks.size() - 1) {
                string = string + "(" + tasks.get(i).toString() + ")";
            } else {
                string = string + "(" + tasks.get(i).toString() + "),";
            }
        }
        return (string + "]");
    }


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







