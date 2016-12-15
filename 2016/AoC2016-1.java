import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        String line = "L3, R2, L5, R1, L1, L2, L2, R1, R5, R1, L1, L2, R2, R4, L4, L3, L3, R5, L1, R3, L5, L2, R4, L5, R4, R2, L2, L1, R1, L3, L3, R2, R1, L4, L1, L1, R4, R5, R1, L2, L1, R188, R4, L3, R54, L4, R4, R74, R2, L4, R185, R1, R3, R5, L2, L3, R1, L1, L3, R3, R2, L3, L4, R1, L3, L5, L2, R2, L1, R2, R1, L4, R5, R4, L5, L5, L4, R5, R4, L5, L3, R4, R1, L5, L4, L3, R5, L5, L2, L4, R4, R4, R2, L1, L3, L2, R5, R4, L5, R1, R2, R5, L2, R4, R5, L2, L3, R3, L4, R3, L2, R1, R4, L5, R1, L5, L3, R4, L2, L2, L5, L5, R5, R2, L5, R1, L3, L2, L2, R3, L3, L4, R2, R3, L1, R2, L5, L3, R4, L4, R4, R3, L3, R1, L3, R5, L5, R1, R5, R3, L1";


        int direction = 0; //start North
        int x = 0;
        int y = 0;
        CurrentPosition currentPosition = new CurrentPosition(x,y);
        ArrayList<CurrentPosition> positions = new ArrayList<CurrentPosition>();
        positions.add(new CurrentPosition(x,y));
            StringTokenizer st = new StringTokenizer(line, " \t\n\r\f,");

        while(st.hasMoreTokens()){
            String currentInstruction = st.nextToken();
            direction = turn(currentInstruction.charAt(0), direction);
            int steps = Integer.parseInt(currentInstruction.substring(1, currentInstruction.length()));
            currentPosition = move(currentPosition, steps, direction, positions);

            System.out.println(steps);
        }

        int distance = Math.abs(currentPosition.getX()) + Math.abs(currentPosition.getY());
        System.out.println("The distance is: " + distance);

        System.out.println("END PROG");
    }

    private static boolean beenHereBefore(CurrentPosition currentPosition, ArrayList<CurrentPosition> positions) {



        for(int index = 0; index < positions.size(); index++){
            CurrentPosition cp = positions.get(index);

            if(cp.isTheSameAs(currentPosition)){

                System.out.println("Current X is: " + currentPosition.getX());
                System.out.println("Current Y is: " + currentPosition.getY());

                System.out.println("New X is: " + cp.getX());
                System.out.println("New Y is: " + cp.getY());

                return true;
            }
        }
        return false;
    }

    public static CurrentPosition move(CurrentPosition currentPosition, int steps, int direction, ArrayList<CurrentPosition> positions){




        switch (direction) {
            case 0:
                for(int i = 1; i <= steps; i++ ){
                    CurrentPosition temp = new CurrentPosition(currentPosition.getX(), currentPosition.getY() + i);

                    if (beenHereBefore(temp, positions)) {
                        System.out.println("I've been here before!!!");
                        int distanceFromSamePlace = Math.abs(temp.getX()) + Math.abs(temp.getY());
                        System.out.println("The distance is: " + distanceFromSamePlace);
                    }
                    positions.add(temp);

                }
                currentPosition.setY(currentPosition.getY() + steps);
                break;
            case 1:
                for (int i = 1; i <= steps; i++) {
                    CurrentPosition temp = new CurrentPosition(currentPosition.getX() + i, currentPosition.getY());

                    if (beenHereBefore(temp, positions)) {
                        System.out.println("I've been here before!!!");
                        int distanceFromSamePlace = Math.abs(temp.getX()) + Math.abs(temp.getY());
                        System.out.println("The distance is: " + distanceFromSamePlace);
                    }
                    positions.add(temp);

                }
                currentPosition.setX(currentPosition.getX() + steps);
                break;
            case 2:
                for (int i = 1; i <= steps; i++) {
                    CurrentPosition temp = new CurrentPosition(currentPosition.getX(), currentPosition.getY() - i);

                    if (beenHereBefore(temp, positions)) {
                        System.out.println("I've been here before!!!");
                        int distanceFromSamePlace = Math.abs(temp.getX()) + Math.abs(temp.getY());
                        System.out.println("The distance is: " + distanceFromSamePlace);
                    }
                    positions.add(temp);

                }
                currentPosition.setY(currentPosition.getY() - steps);
                break;
            case 3:
                for (int i = 1; i <= steps; i++) {
                    CurrentPosition temp = new CurrentPosition(currentPosition.getX() - i, currentPosition.getY());

                    if (beenHereBefore(temp, positions)) {
                        System.out.println("I've been here before!!!");
                        int distanceFromSamePlace = Math.abs(temp.getX()) + Math.abs(temp.getY());
                        System.out.println("The distance is: " + distanceFromSamePlace);
                    }
                    positions.add(temp);

                }
                currentPosition.setX(currentPosition.getX() - steps);
                break;
        }


        return currentPosition;
    }

    private static int turn(char leftOrRight, int originalDirection){
        
        int newDirection = 0;
        if(leftOrRight == 'R'){
            newDirection = (originalDirection + 1);
            if(newDirection > 3){
                newDirection = 0;
            }
        }
        else if(leftOrRight == 'L'){
            newDirection = (originalDirection - 1);
            if(newDirection < 0){
                newDirection = 3;
            }
        }
        return newDirection;
    }

    public static class CurrentPosition{
        int x = 0;
        int y = 0;
        CurrentPosition(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setX(int x){
            this.x = x;
        }

        public int getX(){
            return x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getY() {
            return y;
        }

        public boolean isTheSameAs(CurrentPosition cp) {
            if (this.getX() == cp.getX() &&
                    this.getY() == cp.getY()) {
                return true;
            } else {
                return false;
            }
        }
    }

}

