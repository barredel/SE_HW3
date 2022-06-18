import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * represent an iterator of ToDoList
 */
public class ToDoListIterator implements Iterator <Task>
{
        private ArrayList<Task> tasksSorted;
        private Date scanningDueDate;
        private int index;

        /**
         * class constructor
         * @param tasksSorted arraylist of tasks sorted by date and alphabetically
         * @param scanningDueDate the last date of tasks to be iterated. if null, iterate all tasks
         */
        public ToDoListIterator(ArrayList tasksSorted, Date scanningDueDate)
        {
                this.tasksSorted = tasksSorted;
                this.scanningDueDate = scanningDueDate;
                this.index = 0;
        }

        /**
         * checks if there are any tasks left to iterate
         * @return true is there are more tasks, false otherwise
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
                if(scanningDueDate!=null && (tasksSorted.get(index).getDueDate().compareTo(scanningDueDate))>0)
                {
                        return false;
                }
                return true;
        }

        /**
         * returns the next task in the queue and updates the index
         * @return the next task
         */
        @Override
        public Task next()
        {
                return tasksSorted.get(index++);
        }


}
