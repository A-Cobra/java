import javax.swing.JFrame;

public class GameFrame extends JFrame {
    private String appTitle = "Snake Game";

    GameFrame() {
        this.initApp();
    }

    private void initApp() {
        this.add(new GamePanel());
        this.setTitle(appTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
