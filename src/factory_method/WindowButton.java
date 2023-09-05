package factory_method;

public class WindowButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering window button");
    }

    @Override
    public void onClick() {
        System.out.println("Clicking window button");
    }
}
