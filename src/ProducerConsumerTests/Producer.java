package ProducerConsumerTests;

class Producer extends BufferUtils implements Runnable {
    public Producer(Buffer<? extends Object> buffer, int limit) {
        super(buffer, limit);
    }

    @Override
    public String toString() {
        return "Producer{" + super.toString() + '}';
    }

    @Override
    public void run() {
        while (!done()) {
            produceItemInBuffer();
        }
    }

    private void produceItemInBuffer() {
        synchronized (buffer) {
            waitForBufferSpace();
            produce();
            logAndNotify();
        }
    }

    private void produce() {
       add();
    }

    private void waitForBufferSpace() {
        while (buffer.cannotProduce())
            waitOnBuffer();
    }
}







