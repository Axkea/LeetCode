package juc_code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Axkea
 * @Date 2023/11/13/013 14:34
 * @Description
 */
public class MyBlockingQueue<T> {
    private Deque<T> queue;
    private int size;
    private ReentrantLock lock;
    private Condition fullCondition;
    private Condition emptyCondition;

    public MyBlockingQueue(int size) {
        this.size = size;
        this.queue=new ArrayDeque<>();
        this.lock=new ReentrantLock();
        this.fullCondition= lock.newCondition();
        this.emptyCondition= lock.newCondition();
    }

    public int size(){
        return queue.size();
    }

    public void submit(T task){
        lock.lock();
        try {
            while (queue.size()>=size){
                fullCondition.await();
            }
            queue.add(task);
            emptyCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T getTask(){
        lock.lock();
        T t=null;
        try {
            while (queue.isEmpty()){
                emptyCondition.await();
            }
            t = queue.removeFirst();
            fullCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }
}
