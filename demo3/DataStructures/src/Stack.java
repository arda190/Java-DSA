public class Stack<T>{
    private T[] stack;
    private int size;
    private int index;
    public Stack(){
        this.size=10;
        this.index=0;
        this.stack=(T[]) new Object[size];
    }

    public void push(T item){
        if(index==size){
            resize();
        }
        stack[index]=item;
        index++;
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }

        return stack[index-1];
    }

    public T pop(){

        if(isEmpty()){
            return null;
        }

        T removed=stack[index-1];
        stack[index-1]=null;
        index--;
        return removed;
    }


    private void resize(){
        size*=2;
        T[] newArray=(T[]) new Object[size];
        for(int i=0;i<index;i++){
            newArray[i]=stack[i];
        }
        stack=newArray;
    }

    public boolean isEmpty(){
        return index==0;
    }

    public int size(){
        return index;
    }


}
