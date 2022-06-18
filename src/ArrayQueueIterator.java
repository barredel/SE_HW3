import java.util.Iterator;

/**
 * an iterator of ArrayQueue
 * @param <E> a cloneable class
 */
public class ArrayQueueIterator<E extends Cloneable> implements Iterator<E>
{
    private int index;
    private ArrayQueue<E> queue;

    /**
     * @param index the index to start iterating with
     * @param queue the queue to iterate
     */
    public ArrayQueueIterator(int index, ArrayQueue<E> queue)
    {
        this.index = index;
        this.queue = queue;
    }

    /**
     * checks if there are any element left to iterate
     * @return true is there are more elements, false otherwise
     */
    @Override
    public boolean hasNext() {
        if ((index == -2) || (queue.getArray()[index] == null)){
            return false;
        }
        return true;
    }

    /**
     * returns the next element in the queue and updates the index
     * @return the next element
     */
    @Override
    public E next() {
        E element = queue.getArray()[index];
        if (index == queue.getTail())
        {
            index = -2; //in case the rear index has been reached
        }
        else{
            index = (index+1)% queue.getMaxSize(); //in case the head index isn't the 0 index
        }
        return element;
    }
}
