public class RobotAlgo { 
    // Follow Left wall
    public static void main(String[] args) {
        Robot rob = new Robot();
        while (rob.hasExited() == false) {
            if (isLeftWallThere(rob)) {
                while (isLeftWallThere(rob) && rob.isPathClear() == false) {
                    turnRight(rob);
                }
            } else {
                rob.turnLeft();
            }
            // Move Robot Forward
            rob.moveForward();
        }
        // When this code is reached the robot has left the maze
    }

    public static boolean isLeftWallThere(Robot rob) {
        // turn left to check if there is still a wall on the left side
        rob.turnLeft();
        boolean wallPresent = rob.isPathClear();
        turnRight(rob);
        return wallPresent;
    }

    public static void turnRight(Robot rob) {
        // Turn to the right
        for (int i = 0; i <= 2; i++) {
            rob.turnLeft();
        }
    }
}