package factory_method;

public class Demo {
    private static Dialog dialog;
    public static void main(String[] args) {
        configure();
        runBusinessLogin();
    }

    static void configure(){
        if(System.getProperty("os.name").equals("Mac OS X")){
            dialog = new WindowsDialog();
        }else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogin(){
        dialog.renderWindow();
    }
}
