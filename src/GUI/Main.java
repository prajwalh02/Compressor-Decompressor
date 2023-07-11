package GUI;

import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {

        try {
            // Use the system's look and feel for better integration
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }


        AppFrame frame = new AppFrame();
        frame.setVisible(true);
        
    }
}
