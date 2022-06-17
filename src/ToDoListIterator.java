import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoListIterator implements Iterator <Task>
{
        private ArrayList<Task> tasksSorted;
        private Date dueDate;
        private int index;

        public ToDoListIterator(ArrayList tasksSorted, Date dueDate)
        {
                this.tasksSorted = tasksSorted;
                this.dueDate = dueDate;
                this.index = 0;
        }

        @Override
        public boolean hasNext()
        {
                if(tasksSorted.get(index)==null)
                {
                        return false;
                }
                if(dueDate!=null && (tasksSorted.get(index).getDate().compareTo(dueDate))>0)
                {
                        return false;
                }
                return true;
        }

        @Override
        public Task next()
        {
                return tasksSorted.get(index++);
        }


}
