import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;

import javax.swing.JOptionPane;


class StepBuilder  implements Directions {
    // the robot to be used to build our stairs
    private Robot worker = new Robot(1, 1, East, 200);
    // horizontal distance for each step
    private final int TREAD_LENGTH = 3;
    // number of steps and height of each step, acquired from user
    private int numSteps = -1, stepHeight = -1;

    public static void main(String[] args) {
        StepBuilder sb = new StepBuilder();
        sb.getInfoFromUser();
        World.setVisible(true);
        World.setDelay(0);
        sb.buildSteps();
    }


    /**
     * This method directs the Robot to build the steps based on the info
     * acquired from the user.
     */
    private void buildSteps() {
        World.setSize(numSteps * 5 + 1, numSteps * 5 + 1);

        //set initial location
        worker.turnLeft();
        for (int i = 0; i < numSteps * 2; i++) {
            worker.move();
        }
        worker.turnLeft();
        worker.turnLeft();
        worker.turnLeft();

        if (stepHeight > 0) {
            for (int i = 0; i < numSteps; i++) {
                worker.putBeeper();
                for (int i1 = 0; i1 < TREAD_LENGTH - 1; i1++) {
                    worker.move();
                    worker.putBeeper();
                }
                worker.putBeeper();
                worker.turnLeft();
                worker.pickBeeper();
                for (int i1 = 0; i1 < stepHeight - 1; i1++) {
                    worker.move();
                    worker.putBeeper();
                }
                worker.turnLeft();
                worker.turnLeft();
                worker.turnLeft();
                worker.pickBeeper();
            }
        } else if (stepHeight < 0) {
            for (int i = 0; i < numSteps; i++) {
                worker.putBeeper();
                for (int i1 = 0; i1 < TREAD_LENGTH - 1; i1++) {
                    worker.move();
                    worker.putBeeper();
                }
                worker.putBeeper();
                worker.turnLeft();
                worker.turnLeft();
                worker.turnLeft();
                worker.pickBeeper();
                for (int i1 = 0; i1 < java.lang.Math.abs(stepHeight) - 1; i1++) {
                    worker.move();
                    worker.putBeeper();
                }
                worker.turnLeft();
                //worker.turnLeft();
                //worker.turnLeft();
                worker.pickBeeper();
            }
        } else {
            for (int i = 0; i < (TREAD_LENGTH - 1) * (stepHeight - 1); i++) {
                worker.move();
                worker.putBeeper();
            }
        }
    }


    /**
     * This method acquires info from the user using a JOptionPane.
     * A JOptionPane is a built-in class that helps us get info:
     * Here is a brief tutorial:  https://www.youtube.com/watch?v=q8gd2ih2-0c
     */
    private void getInfoFromUser() {
        boolean exception = true;
        while (exception) {
            try {
                numSteps = Integer.parseInt(JOptionPane.showInputDialog
                        (null,"How many steps do you want to build?" + "\n" + "Choose a number between 1 and 9"));
                while (numSteps > 9 || numSteps < 1) {
                    JOptionPane.showMessageDialog
                            (null, "Choose a number between 1 and 9", "ERROR", JOptionPane.ERROR_MESSAGE);
                    numSteps = Integer.parseInt(JOptionPane.showInputDialog
                            (null, "How many steps do you want to build?" + "\n" + "Choose a number between 1 and 9"));
                }
                exception = false;
            }

            catch (NumberFormatException e) {
                numSteps = 0;
                JOptionPane.showMessageDialog
                        (null, "Choose a number between 1 and 9", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }


        boolean exception2 = true;
        while (exception2) {
            try {
                stepHeight = Integer.parseInt(JOptionPane.showInputDialog
                        (null, "How high are the steps?" + "\n" + "Choose a number between -3 and 3"));
                while (stepHeight > 3 || stepHeight < -3 || stepHeight == 0) {
                    JOptionPane.showMessageDialog
                            (null, "Choose a number between -3 and 3", "ERROR", JOptionPane.ERROR_MESSAGE);
                    stepHeight = Integer.parseInt(JOptionPane.showInputDialog
                            (null, "How high are the steps?" + "\n" + "Choose a number between -3 and 3"));
                }
                exception2 = false;
            }

            catch (NumberFormatException e) {
                stepHeight = 0;
                JOptionPane.showMessageDialog
                        (null, "Choose a number between -3 and 3", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}