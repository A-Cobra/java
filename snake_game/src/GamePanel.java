import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import models.Coordinate;
import utils.Direction;

import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_WIDTH) / UNIT_SIZE;
    int DELAY;
    final Coordinate snakeCoordinates[] = new Coordinate[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    Coordinate appleCoordinates = new Coordinate();
    Direction direction = Direction.RIGHT;
    boolean running = false;
    Timer timer;
    Random random;
    final Color BACKGROUND_COLOR = Color.black;
    final Color APPLE_COLOR = Color.red;
    final Color SNAKE_HEAD_COLOR = Color.green;
    final Color SNAKE_BODY_COLOR = new Color(45, 180, 0);
    final Color GAME_OVER_COLOR = new Color(255, 0, 0);
    final Font GAME_FONT = new Font("Ink Free", Font.BOLD, UNIT_SIZE * 3);
    private final String GAME_OVER_TEXT = "Game Over";
    final Font COUNTER_FONT = new Font("Roboto", Font.BOLD, (int) (UNIT_SIZE * 1.2));
    private final String COUNTER_TEXT = "Apples Eaten: ";
    final Color COUNTER_COLOR = new Color(147, 202, 237);
    private final String RESET_BUTTON_TEXT = "Restart Game";
    JButton resetButton = new JButton(RESET_BUTTON_TEXT);
    final int BUTTON_WIDTH = 150;
    final int BUTTON_HEIGHT = 70;
    final int BUTTON_X = (int) (SCREEN_WIDTH / 2 - BUTTON_WIDTH / 2);
    final int BUTTON_Y = (int) (SCREEN_WIDTH - 150);

    GamePanel() {
        this(75);
    }

    GamePanel(int delay) {
        this.setLayout(null);
        this.DELAY = delay;
        this.setGameConfig();
        this.startGame();
        setButtonConfig();
    }

    private void setGameConfig() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(BACKGROUND_COLOR);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }

    private void setButtonConfig() {
        resetButton.setBounds(BUTTON_X, BUTTON_Y,
                BUTTON_WIDTH,
                BUTTON_HEIGHT);
        resetButton.addActionListener((e) -> {
            resetGameParams();
            this.remove(resetButton);
        });
    }

    public void startGame() {
        timer = new Timer(DELAY, this);
        resetGameParams();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }
            drawApple(g);
            drawSnake(g);
            displayApplesEatenCounter(g);
        } else {
            displayGameOver(g);
        }
    }

    public void generateAppleCoordinates() {
        appleCoordinates.x = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleCoordinates.y = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    private void drawApple(Graphics g) {
        g.setColor(APPLE_COLOR);
        g.fillOval(appleCoordinates.x, appleCoordinates.y, UNIT_SIZE, UNIT_SIZE);
    }

    public void checkApple() {
        if (snakeCoordinates[0].x == appleCoordinates.x && snakeCoordinates[0].y == appleCoordinates.y) {
            bodyParts++;
            applesEaten++;
            generateAppleCoordinates();
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            snakeCoordinates[i].x = snakeCoordinates[i - 1].x;
            snakeCoordinates[i].y = snakeCoordinates[i - 1].y;
        }

        switch (direction) {
            case RIGHT:
                snakeCoordinates[0].x = snakeCoordinates[0].x + UNIT_SIZE;
                break;
            case LEFT:
                snakeCoordinates[0].x = snakeCoordinates[0].x - UNIT_SIZE;
                break;
            case UP:
                snakeCoordinates[0].y = snakeCoordinates[0].y - UNIT_SIZE;
                break;
            case DOWN:
                snakeCoordinates[0].y = snakeCoordinates[0].y + UNIT_SIZE;
                break;
        }
    }

    private void drawSnake(Graphics g) {
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(SNAKE_HEAD_COLOR);
                g.fillRect(snakeCoordinates[i].x, snakeCoordinates[i].y, UNIT_SIZE, UNIT_SIZE);
            } else {
                g.setColor(SNAKE_BODY_COLOR);
                g.fillRect(snakeCoordinates[i].x, snakeCoordinates[i].y, UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    private void initializeSnakeCoordinates() {
        for (int i = 0; i < snakeCoordinates.length; i++) {
            snakeCoordinates[i] = new Coordinate();
        }
    }

    public void checkCollisions() {
        // Head and body collision
        for (int i = bodyParts; i > 0; i--) {
            if (snakeCoordinates[0].x == snakeCoordinates[i].x && snakeCoordinates[0].y == snakeCoordinates[i].y) {
                running = false;
            }
        }
        // Head and borders
        if (snakeCoordinates[0].x < 0
                || snakeCoordinates[0].x > SCREEN_WIDTH
                || snakeCoordinates[0].y < 0
                || snakeCoordinates[0].y > SCREEN_HEIGHT) {
            running = false;
        }

        if (!running)
            timer.stop();
    }

    public void displayGameOver(Graphics g) {
        g.setFont(GAME_FONT);
        FontMetrics metrics = getFontMetrics(g.getFont());
        final int xCenter = (SCREEN_WIDTH - metrics.stringWidth(GAME_OVER_TEXT)) / 2;
        drawText(g, GAME_OVER_COLOR, GAME_OVER_TEXT, xCenter, SCREEN_HEIGHT / 2);
        displayApplesEatenCounter(g);
        displayResetButton();
    }

    private void displayApplesEatenCounter(Graphics g) {
        g.setFont(COUNTER_FONT);
        FontMetrics metrics = getFontMetrics(g.getFont());
        final int xCenter = (SCREEN_WIDTH - metrics.stringWidth(COUNTER_TEXT + applesEaten)) / 2;
        drawText(g, COUNTER_COLOR, COUNTER_TEXT + applesEaten, xCenter, g.getFont().getSize());
    }

    private void displayResetButton() {
        this.add(resetButton, JPanel.BOTTOM_ALIGNMENT);
        this.revalidate();
        this.repaint();
    }

    private void drawText(Graphics g, Color fontColor, String text, int x, int y) {
        g.setColor(fontColor);
        g.drawString(text, x, y);
    }

    private void resetGameParams() {
        direction = Direction.RIGHT;
        bodyParts = 6;
        applesEaten = 0;
        initializeSnakeCoordinates();
        generateAppleCoordinates();
        running = true;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (direction != Direction.LEFT) {
                        direction = Direction.RIGHT;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (direction != Direction.RIGHT) {
                        direction = Direction.LEFT;
                    }
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (direction != Direction.DOWN) {
                        direction = Direction.UP;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (direction != Direction.UP) {
                        direction = Direction.DOWN;
                    }
                    break;
            }
        }
    }
}
