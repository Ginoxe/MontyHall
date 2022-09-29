import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class MontyHall2
{
    public static void main(String[] args) //Does everything step by step
    {
        Random gen = new Random();
        boolean switchBool = false; //or false
        int totalWins = 0, numRuns = 0;

        while (numRuns < 100000)
        {
            int userChoice = gen.nextInt(3);
            int carDoor = gen.nextInt(3);

            boolean door1 = false;
            boolean door2 = false;
            boolean door3 = false;
            Boolean[] doors = {door1, door2, door3};
            doors[carDoor] = true;
            ArrayList<Boolean> doorList = new ArrayList<>(Arrays.asList(doors));
            if (switchBool)
            {
                while (doorList.size() > 2)
                {
                    int temp = gen.nextInt(3);
                    if (doorList.get(temp) == false && temp != userChoice)
                    {
                        doorList.remove(temp);
                        if (temp < userChoice)
                        {
                            userChoice--;
                        }
                        break;
                    }
                }
                // }
                if (userChoice == 0)
                {
                    userChoice = 1;
                }
                else
                {
                    userChoice = 0;
                }

                if (doorList.get(userChoice) == true)
                {
                    totalWins++;
                }
            }
            else
            {
                if (doorList.get(userChoice) == true)
                {
                    totalWins++;
                }
            }
            numRuns++;
        }
        System.out.println("Switch Results");
        System.out.println("Total Wins: " + totalWins);
        System.out.println("Win Rate: " + totalWins/(double)numRuns);
    }
}