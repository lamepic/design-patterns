package factory_method;

public class WindowsDialog extends Dialog{

    @Override
    public Button createButton() {
        return new WindowButton();
    }
}
