import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator<E>
{
    private int index;
    private ArrayQueue<E> queue;

    public ArrayQueueIterator(int index, ArrayQueue<E> queue)
    {
        this.index = index;
        this.queue = queue;
    }

    @Override
    public boolean hasNext() {
        if (index == -1){
            return false;
        }
        return true;
    }

    @Override
    public E next() {
        E element = queue.getArray()[index];
        if (index == queue.getTail())
        {
            index = -1;
        }
        else{
            index = (index+1)% queue.getMaxSize();
        }
        return element;
    }
}
