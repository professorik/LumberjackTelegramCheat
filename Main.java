import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) throws AWTException {
        // mouseCheat(); //936
        keyboardCheat(); //912
    }

    //TODO: delete copy-past
    private static void keyboardCheat() throws AWTException {
        Robot robot = new Robot();
        boolean[] fl = new boolean[6];
        int key;
        while (true) {
            if (robot.getPixelColor(900, 925).getGreen() == 116) {
                for (int i = 6; i > 0; i--) {
                    if (robot.getPixelColor(895, i * 100 + 1).getGreen() == 204)
                        fl[6 - i] = true;
                    else
                        fl[6 - i] = false;
                }
                for (boolean i : fl) {
                    if (i) {
                        key = KeyEvent.VK_RIGHT;
                    } else {
                        key = KeyEvent.VK_LEFT;
                    }
                    robot.keyPress(key);
                    robot.keyRelease(key);
                    robot.delay(17);
                    robot.keyPress(key);
                    robot.keyRelease(key);
                    robot.delay(9);
                }
                robot.delay(140);
            }
        }
    }

    private static void mouseCheat() throws AWTException {
        Robot robot = new Robot();
        boolean[] fl = new boolean[6];
        while (true) {
            if (robot.getPixelColor(900, 925).getGreen() == 116) {
                for (int i = 6; i > 0; i--) {
                    if (robot.getPixelColor(895, i * 100 + 1).getGreen() == 204)
                        fl[6 - i] = true;
                    else
                        fl[6 - i] = false;
                }
                for (boolean i : fl) {
                    robot.waitForIdle();
                    if (i) {
                        robot.mouseMove(1043, 875);
                    } else {
                        robot.mouseMove(919, 875);
                    }
                    robot.waitForIdle();
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    robot.delay(17); //with a delay of 16ms the max score is 936
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    robot.delay(9);
                }
                robot.delay(140);
            }
        }
    }
}