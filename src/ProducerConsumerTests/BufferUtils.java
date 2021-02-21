package ProducerConsumerTests;

class BufferUtils {
    Buffer buffer;
    int value, limit;

    BufferUtils(Buffer buffer, int limit) {
        this.buffer = buffer;
        this.limit = limit;
        value = 0;
    }

    @Override
    public String toString() {
        return "Task{" + buffer.toString() + '}';
    }

    void logAndNotify() {
        try {
            logAndNotifyHelper();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void waitOnBuffer(){
        try {
            buffer.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void notifyOnBuffer() {
        buffer.notify();
    }

    private void logAndNotifyHelper() throws InterruptedException {
        System.out.println(this);
        notifyOnBuffer();
    }

    void add(){
        value++;
        buffer.add(value);
    }

    void remove(int index){
        buffer.remove(index);
    }

    Boolean done(){
        return value >= limit;
    }
}
