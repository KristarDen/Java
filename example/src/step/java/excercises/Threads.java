package src.step.java.excercises;

public class Threads {
    public void demo() {
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                System.out.println("Hello from thread 1");
            }

        };
        thread1.start();
    }

}

/*
    Thread (поток) - часть процесса
    поток создается на функции (методе)
    Основным классом для управления потоками является Thread.
    Основным методом, который выполянется является run()
 */