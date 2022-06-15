import java.util.Iterator;

public  class ArrayQueue<E extends Cloneable>  implements Queue<E>, Cloneable, Iterable<E>
{
    private E[] array;
    private int maxSize;
    private int size;
    private int head;
    private int tail;

    public ArrayQueue(int maxSize)
    {//to do: if maxsize<0 throws exception
        this.size = 0;
        this.head = 0;
        this.tail = 0;
        this.maxSize = maxSize;
        this.array = (E[]) new Cloneable[maxSize];
    }


    @Override
    public void enqueue(E element)
    {//to do: if size==maxsize throws exception
        this.tail = (this.tail+1) % this.maxSize;
        this.array[this.tail] = element;
        this.size++;
    }


    @Override
    public E dequeue ()
    {//to do: if size==0 throws exception
        E temp = this.array[head];
        this.array[head] = null;
        this.head = (this.head+1) % this.maxSize;
        this.size--;
        return temp;
    }


    @Override
    public E peek()
    {//to do: if size==0 throws exception
        return this.array[head];
    }

    @Override
    public int size()
    {
        return this.size;
    }

    @Override
    public boolean isEmpty()
    {
        if(size==0)
        {
            return true;
        }
        return false;
    }

    public E[] getArray() {
        return array;
    }

    public int getTail() {
        return tail;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator<E>(head, this);
    }

    @Override
    public ArrayQueue<E> clone()
    {
        try{
            ArrayQueue<E> copy = (ArrayQueue<E>)super.clone();
            copy.array = (E[]) new Cloneable[maxSize];
            for(int i = 0; i<this.maxSize; i++)
            {
                copy.array[i] = this.array[i].clone();
            }
            return copy;
        }catch(CloneNotSupportedException e){
            return null;
        }
    }


}


