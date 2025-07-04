public class deque<T> {
    private int size;
    private int index;
    private T[] array;

    public deque() {
        this.size=10;
        this.index=0;
        this.array=(T[])new Object[size];
    }

    public void addLast(T element) {
        if(index==size) {
            resize();
        }
        array[index]=element;
        index++;
    }

    public T removeLast() {
        T removed=array[index-1];
        array[index-1]=null;
        index--;
        return removed;
    }


    public T removeFirst() throws Exception {
        if(index==0) throw new Exception("There are no element in deque");


        T removed=array[0];
        for(int i=1;i<index;i++) {
            array[i-1]=array[i];
        }
        array[index-1]=null;
        index--;
        return removed;
    }

    public void addFirst(T element) {
        if(index==size) {
            resize();
        }
        for(int i=index;i>0;i--) {
            array[i]=array[i-1];
        }
        array[0]=element;
        index++;
    }


    public int size() {
        return index;
    }


    public T peekFirst() {
        return array[0];
    }

    public T peekLast() {
        return array[index-1];
    }






    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(T t:array) {
            sb.append(t+"\n");
        }
        return sb.toString();
    }




    private void resize() {
        size*=2;
        T[] newArray=(T[]) new Object[size];
        for(int i=0;i<index;i++) {
            newArray[i]=array[i];
        }
        array=newArray;
    }

    public boolean isEmpty() {
        return index==0;
    }



}
