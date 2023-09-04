package singleton;

public class DemoMultithread {
    public static void main(String[] args) {

//        Not Thread Safe
//        Thread foo = new Thread(new ThreadFoo());
//        Thread bar = new Thread(new ThreadBar());
//        foo.start();
//        bar.start();

//        Using Thread Safe
        Thread safeFoo = new Thread(new ThreadSafeFoo());
        Thread safeBar = new Thread(new ThreadSafeBar());
        safeFoo.start();
        safeBar.start();
    }

//    Not thread safe implementation
    static class ThreadFoo implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Foo");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Bar");
            System.out.println(singleton.value);
        }
    }

//    Thread safe implementation
    static class ThreadSafeFoo implements Runnable {

        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("Foo");
            System.out.println(singleton.value);
        }
    }

    static class ThreadSafeBar implements Runnable {

        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("Bar");
            System.out.println(singleton.value);
        }
    }


}
