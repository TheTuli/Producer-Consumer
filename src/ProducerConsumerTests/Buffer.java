package ProducerConsumerTests;

import java.util.ArrayList;

class Buffer<T> {
    ArrayList<T> arrayList;
    int capacity;

    Buffer(ArrayList<T> arrayList, int capacity) {
        this.arrayList = arrayList;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Buffer{" +
                "buffer_size=" + arrayList.size() +
                '}';
    }

    Boolean canProduce() {
        boolean not_full = arrayList.size() <= capacity;
        return not_full;
    }

    Boolean canConsume() {
        boolean not_empty = arrayList != null && arrayList.size() > 0;
        return not_empty;
    }

    Boolean cannotProduce() {
        return !canProduce();
    }

    Boolean isNotConsumable() {
        return !canConsume();
    }

    int size(){
        return arrayList.size();
    }

    void add(T t){
        arrayList.add(t);
    }

    void remove(int index){
        arrayList.remove(index);
    }
}
