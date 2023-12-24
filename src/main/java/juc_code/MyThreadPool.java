package juc_code;

import java.util.Set;

/**
 * @Author Axkea
 * @Date 2023/11/13/013 15:43
 * @Description
 */
public class MyThreadPool {
    private MyBlockingQueue<Runnable> taskList;
    private Set<Worker> workerSet;
    private int coreSize;

    public void execute(Runnable task){
        synchronized (workerSet){
            if (workerSet.size()<coreSize){
                Worker worker=new Worker(task);
                worker.start();
            }else{
                taskList.submit(task);
            }
        }
    }

    class Worker extends Thread{
        Runnable task;

        @Override
        public void run() {
            while (task!=null||(taskList.size()!=0&&(task=taskList.getTask())!=null)){
                task.run();
                task=null;
            }
            workerSet.remove(this);
        }

        public Worker(Runnable task){
            this.task=task;
        }
    }
}
