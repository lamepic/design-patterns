package factory_method;

public class HtmlButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering html button");
    }

    @Override
    public void onClick() {
        System.out.println("Clicking Html button");
    }
}
