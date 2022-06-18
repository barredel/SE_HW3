import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * represents a queue that uses an array to manage it's elements
 * @param <E> a cloneable class
 */
public  class ArrayQueue<E extends Cloneable>  implements Queue<E>, Cloneable, Iterable<E>
{
    private E[] array;
    private int maxSize;
    private int size;
    private int head;
    private int tail; //the rear

    /**
     * @param maxSize - the max number of elements the queue can have
     */
    public ArrayQueue(int maxSize)
    {
        if(maxSize < 0)
        {
            throw new NegativeCapacityException("negative capacity");
        }
        this.size = 0;
        this.head = 0;
        this.tail = -1;
        this.maxSize = maxSize;
        this.array = (E[]) new Cloneable[maxSize];
    }


    /**
     * adds an element to the rear of the queue and updates the queue accordingly
     * @param element - an element to be added at the rear of the queue
     */
    @Override
    public void enqueue(E element)
    {
        if(this.size==maxSize)
        {
            throw new QueueOverflowException("The queue reached its full capacity");
        }
        this.tail = (this.tail+1) % this.maxSize; //in case the head isn't in the 0 index of the array
        this.array[this.tail] = element;
        this.size++;
    }

    /**
     * take the first element out and updates the rest queue accordingly
     * @return the first element in the queue (the one in the head index)
     */
    @Override
    public E dequeue ()
    {
        if(isEmpty())
        {
            throw new EmptyQueueException("The queue is empty");
        }
        E temp = this.array[head];
        this.array[head] = null;
        this.head = (this.head+1) % this.maxSize; //in case the head is in the last index of the array
        this.size--;
        return temp;
    }


    /**
     * returns the first element without taking it out
     * @return the first element in the queue (the one in the head index)
     */
    @Override
    public E peek()
    {//to do: if size==0 throws exception
        if(isEmpty())
        {
            throw new EmptyQueueException("The queue is empty");
        }
        return this.array[head];
    }

    /**
     * @return the num of element in the queue
     */
    @Override
    public int size()
    {
        return this.size;
    }

    /**
     * @return true if there are no element in the queue, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        if(size==0)
        {
            return true;
        }
        return false;
    }

    /**
     * @return the array of elements
     */
    public E[] getArray() {
        return array;
    }

    /**
     * @return the rear index of the queue
     */
    public int getTail() {
        return tail;
    }

    /**
     * @return the max number of elements in the queue
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * @return an iterator of this queue
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator<E>(head, this);
    }

    /**
     * deep clones the queue
     * @return a clone of the queue
     */
    @Override
    public ArrayQueue<E> clone()
    {
        try{
            ArrayQueue<E> copy = (ArrayQueue<E>)super.clone();
            copy.array = (E[]) new Cloneable[maxSize];
            if(this.maxSize == 0)
            {
                return copy;
            }
            Class meta = array[this.head].getClass();
            Method m = meta.getMethod("clone");
            for(int i = 0; i<this.maxSize; i++)
            {
                if (this.array[i] !=null)
                copy.array[i] = (E)m.invoke(this.array[i]); //copies each element separately
            }
            return copy;
        }catch(Exception e) {
            return null;
        }
    }
}


