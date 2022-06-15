public  class ArrayQueue<E extends Cloneable>  implements Queue
{
    private E array[];
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

    @Override
    public Queue<E> clone()
    {
        return null;
    }
}


