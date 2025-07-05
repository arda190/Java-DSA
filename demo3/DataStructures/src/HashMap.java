public class HashMap<K,V>{
    int capacity;
    int size;
    K[] keys;
    V[] values;
    private final K DELETED = (K) new Object();


    public HashMap() {
        capacity=10;
        size=0;
        keys=(K[]) new Object[capacity];
        values=(V[]) new Object[capacity];
    }

    public void put(K key,V value) {
        if(size==capacity) {
            resize();
        }
        int hash=Math.abs(key.hashCode())%capacity;
        int originalHash=hash;
        if(keys[hash]!=null || keys[hash] == DELETED) {
            if(keys[hash].equals(key)) {
                values[hash]=value;
                size++;
            }
            else {
                while (keys[hash] != null && !keys[hash].equals(key)&& keys[hash] != DELETED) {
                    hash = (hash + 1) % capacity;
                    if (hash == originalHash) {
                        resize();
                        put(key, value);
                        return;
                    }
                }
                if(keys[hash]==null) {
                    size++;
                }
                keys[hash]=key;
                values[hash]=value;
            }
        }
    }

    public V get(K key) {
        int hash=Math.abs(key.hashCode())%capacity;
        int originalHash=hash;
        while(keys[hash] != DELETED && keys[hash]!=null) {
            if(keys[hash].equals(key)) {
                return values[hash];
            }
            hash=(hash+1)%capacity;
            if(originalHash==hash) {
                break;
            }
        }
        return null;
    }


    private void resize() {
        capacity*=2;
        K[] newKeys=(K[])new Object[capacity];
        V[] newValues=(V[]) new Object[capacity];

        for(int i=0;i<size;i++) {
            newKeys[i]=keys[i];
            newValues[i]=values[i];
        }
        keys=newKeys;
        values=newValues;
    }

    public V remove(K key) {
        int hash=Math.abs(key.hashCode())%capacity;
        int originalHash=hash;

        while(keys[hash]!=null) {
            if(keys[hash].equals(key)) {
                V deleted=values[hash];
                keys[hash]=DELETED;
                values[hash]=null;
                return deleted;
            }
            hash=(hash+1)%capacity;
            if(hash==originalHash) {
                break;
            }
        }
        size--;
        return null;

    }



}
