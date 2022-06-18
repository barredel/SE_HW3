import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * represent an iterator of ToDoList
 */
public class ToDoListIterator implements Iterator <Task>
{
        private ArrayList<Task> tasksSorted;
        private Date dueDate;
        private int index;

        /**
         * class constructor
         * @param tasksSorted arraylist of tasks
         * @param dueDate
         */
        public ToDoListIterator(ArrayList tasksSorted, Date dueDate)
        {
                this.tasksSorted = tasksSorted;
                this.dueDate = dueDate;
                this.index = 0;
        }

        /**
         * checks if there are any element left to iterate
         * @return true is there are more elements, false otherwise
         */
        @Override
        public boolean hasNext()
        {
                if (index==tasksSorted.size())
                {
                        return false;
                }
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

        /**
         * returns the next element in the queue and updates the index
         * @return the next element
         */
        @Override
        public Task next()
        {
                return tasksSorted.get(index++);
        }


}
