package singleton;

public class Demo {
    public static void main(String[] args) {
        Singleton foo = Singleton.getInstance("foo");
        Singleton bar = Singleton.getInstance("bar");

        System.out.println(foo.value);
        System.out.println(bar.value);
    }
}
