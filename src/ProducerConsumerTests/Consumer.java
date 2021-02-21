package ProducerConsumerTests;

class Consumer extends BufferUtils implements Runnable {
    public Consumer(Buffer buffer, int limit) {
        super(buffer, limit);
    }

    @Override
    public String toString() {
        return "Consumer{" + super.toString() + '}';
    }

    @Override
    public void run() {
        while (!done())
            consumeBuffer();
    }

    private void consumeBuffer() {
        synchronized (buffer) {
            waitForItemInBuffer();
            consumeAnItem();
            logAndNotify();
        }
    }

    private void consumeAnItem() {
        remove(0);
    }

    private void waitForItemInBuffer() {
        while (bufferIsNotConsumable())
            waitOnBuffer();
    }

    private Boolean bufferIsNotConsumable() {
        return buffer.isNotConsumable();
    }
}
