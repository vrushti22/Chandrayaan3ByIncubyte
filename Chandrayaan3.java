public class Chandrayaan3 {
    private int[] position;
    private String direction;

    public Chandrayaan3(int[] initialPosition, String initialDirection) {
        position = initialPosition.clone();
        direction = initialDirection;
    }

    public void moveForward() {
        switch (direction) {
            case "N":
                position[1]++;
                break;
            case "S":
                position[1]--;
                break;
            case "E":
                position[0]++;
                break;
            case "W":
                position[0]--;
                break;
            case "Up":
                position[2]++;
                break;
            case "Down":
                position[2]--;
                break;
        }
    }

    public void moveBackward() {
        switch (direction) {
            case "N":
                position[1]--;
                break;
            case "S":
                position[1]++;
                break;
            case "E":
                position[0]--;
                break;
            case "W":
                position[0]++;
                break;
            case "Up":
                position[2]--;
                break;
            case "Down":
                position[2]++;
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case "N":
                direction = "W";
                break;
            case "S":
                direction = "E";
                break;
            case "E":
                direction = "N";
                break;
            case "W":
                direction = "S";
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case "N":
                direction = "E";
                break;
            case "S":
                direction = "W";
                break;
            case "E":
                direction = "S";
                break;
            case "W":
                direction = "N";
                break;
        }
    }

    public void turnUp() {
        if (direction.equals("N") || direction.equals("S")) {
            direction = "Up";
        }
    }

    public void turnDown() {
        if (direction.equals("N") || direction.equals("S")) {
            direction = "Down";
        }
    }

    public int[] getPosition() {
        return position.clone();
    }

    public String getDirection() {
        return direction;
    }

    public static int[] executeCommands(String[] commands, int[] initialPosition, String initialDirection) {
        Chandrayaan3 spacecraft = new Chandrayaan3(initialPosition, initialDirection);

        for (String command : commands) {
            switch (command) {
                case "f":
                    spacecraft.moveForward();
                    break;
                case "b":
                    spacecraft.moveBackward();
                    break;
                case "l":
                    spacecraft.turnLeft();
                    break;
                case "r":
                    spacecraft.turnRight();
                    break;
                case "u":
                    spacecraft.turnUp();
                    break;
                case "d":
                    spacecraft.turnDown();
                    break;
            }
        }

        return spacecraft.getPosition();
    }

    public static void main(String[] args) {
        int[] initialPosition = {0, 0, 0};
        String initialDirection = "N";
        String[] commands = {"f", "r", "u", "b", "l"};

        int[] finalPosition = executeCommands(commands, initialPosition, initialDirection);
        System.out.println("Final Position: (" + finalPosition[0] + ", " + finalPosition[1] + ", " + finalPosition[2] + ")");
    }
}