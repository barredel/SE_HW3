public  class ArrayQueue<E>  implements Queue
{
    private E array[];
    private int maxSize;
    private int size;

    public ArrayQueue(int maxSize)
    {
        this.maxSize = maxSize;
    }


}
