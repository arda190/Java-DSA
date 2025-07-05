public class CircularDeque<T>{
    private T[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularDeque() {
        this.front=0;
        this.rear=0;
        this.size=0;
        this.capacity=0;
        this.array=(T[]) new Object[capacity];
    }

    public boolean isFull() {
        return size==capacity;
    }

    public boolean isEmpty() {
        return size==0;
    }


    public void addLast(T element)throws Exception {
        if(isFull()) throw new Exception("Deque is Full");
        array[rear]=element;
        rear=(rear+1)%capacity;
        size++;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(T element) throws Exception {
        if(isFull()) throw new Exception("Deque is full");
        front=(front-1+capacity)%capacity;
        array[front]=element;
        size++;
    }


    public T removeFirst() throws Exception{
        if(isEmpty()) throw new Exception("There are no element to remove");
        T removed=array[front];
        front=(front+1)%capacity;
        size--;
        return removed;
    }


    public T removeLast() throws Exception{
        if(isEmpty()) throw new Exception("There are no element to remove");
        rear=(rear-1+capacity)%capacity;
        T removed=array[rear];
        array[rear]=null;
        size--;
        return removed;
    }

    public T peekFirst() throws Exception{
        if(isEmpty()) throw new Exception("There are no element");
        return array[front];
    }
    public T peekLast() throws Exception{
        if(isEmpty()) throw new Exception("There are no element");
        int lastIndex=(rear-1+capacity)%capacity;
        return array[lastIndex];
    }

}
