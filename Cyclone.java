/*Name: Yousef Noor
* Class: CS-1083
* Section: 005
* Date: 10/23/23
 */
import java.util.*;

public class Cyclone{
    public static final Scanner gConsole = new Scanner(System.in);
    public static double[] gWindSpeed;
    public static int gDatabaseSize = 0;
    public static final int gMAX_CYCLONES = 50;

    //Swapping cyclones that were given
    public static void swapValues(int f, int t){
        double temp;
        temp = gWindSpeed[f];
        gWindSpeed[f] = gWindSpeed[t];
        gWindSpeed[t] = temp;

    }

    //Getting the wind speeds of 2 given cyclones to swap
    public static void swapCyclones(){
        int idxFrom;
        int idxTo;
        do {
            System.out.print("Enter the position from (0 to " + (gDatabaseSize - 1) + ") : ");
            idxFrom = gConsole.nextInt();
            if (idxFrom<0 || idxFrom>(gDatabaseSize -1)){
                System.out.println("Invalid value, please, try again." + "\n");
            }
        }while(idxFrom<0 || idxFrom>(gDatabaseSize-1));
        System.out.println();
        do{
            System.out.print("Enter the position to change to from (0 to " + (gDatabaseSize - 1) + ") that is not " + idxFrom + " : ");
            idxTo = gConsole.nextInt();
            if (idxTo<0 || idxTo>(gDatabaseSize -1) || idxTo == idxFrom){
                System.out.println("Invalid value, please, try again." + "\n");
            }
        }while(idxTo<0 || idxTo>(gDatabaseSize -1) || idxTo == idxFrom);
        swapValues(idxFrom, idxTo);
    }

    //Displaying cyclones to view all wind speeds
    public static void showCyclones(){
        System.out.println("LIST of Cyclones' Wind Speed");
        int i;
        for(i=0;i<gWindSpeed.length;i++){
            System.out.println("Cyclone[" + i + "] : " + gWindSpeed[i]);
        }
    }

    //Clearing the data of all cyclones
    public static double[] clearDatabase(){
        double[] cleared = new double[gDatabaseSize];
        return cleared;
    }

    //Displaying all the classes of Hurricanes
    public static void getCyclonesByClass(int[] code){
        System.out.println("Tropical Depression" + "\t" + ": " + code[0]);
        System.out.println("Tropical Storm" + "\t" + ": " + code[1]);
        System.out.println("Hurricane Category 1" + "\t" + ": " + code[2]);
        System.out.println("Hurricane Category 2" + "\t" + ": " + code[3]);
        System.out.println("Hurricane Category 3" + "\t" + ": " + code[4]);
        System.out.println("Hurricane Category 4" + "\t" + ": " + code[5]);
        System.out.println("Hurricane Category 5" + "\t" + ": " + code[6]);

    }

    //Summarizing cyclones into classes
    public static void summary(){
        System.out.println("Cyclones' Classification Summary");
        int[] ret = {39,74,96,111,130,156};
        int i;
        int[] code = new int[7];
        for(i = 0;i<gWindSpeed.length;i++){
            if(gWindSpeed[i]<ret[0] && gWindSpeed[i]>0){
                code[0] += 1;
            }
            else if(gWindSpeed[i]<ret[1] && gWindSpeed[i]>0){
                code[1] += 1;
            }
            else if(gWindSpeed[i]<ret[2] && gWindSpeed[i]>0){
                code[2] += 1;
            }
            else if(gWindSpeed[i]<ret[3] && gWindSpeed[i]>0){
                code[3] += 1;
            }
            else if(gWindSpeed[i]<ret[4] && gWindSpeed[i]>0){
                code[4] += 1;
            }
            else if(gWindSpeed[i]<ret[5] && gWindSpeed[i]>0){
                code[5] += 1;
            }
            else if (gWindSpeed[i]>ret[5] && gWindSpeed[i]>0){
                code[6] += 1;
            }

        }
        getCyclonesByClass(code);
    }

    //Adding and updating cyclone status / wind speed
    public static double[] addUpdCyclone(){
        double windSpeed;
        int whichCyc;
        do {
            System.out.print("Enter the index (0 to " + (gDatabaseSize - 1) + ") : ");
            whichCyc = gConsole.nextInt();
            if((whichCyc<0 || whichCyc>gDatabaseSize - 1)){
                System.out.println("Invalid value, please, try again." + "\n");
            }
        }while(whichCyc<0 || whichCyc>gDatabaseSize - 1);
        System.out.println("\n" + "The current wind speed of the cyclone at " + whichCyc + " is : " + gWindSpeed[whichCyc]);
        do{
            System.out.print("Enter the new wind speed (0 - 1000) : ");
            windSpeed = gConsole.nextDouble();
            if(windSpeed<0 || windSpeed>1000){
                System.out.println("Invalid value, please, try again." + "\n");
            }
        }while(windSpeed<0 || windSpeed>1000);
        gWindSpeed[whichCyc] = windSpeed;
        return gWindSpeed;
    }

    //Starting main menu
    public static int menu(){
        int userMen;
        do {
            System.out.println("\n");
            System.out.println("MAIN MENU");
            System.out.println("0 - Exit, 1 - Add/Update a cyclone, 2 - Summary, 3 - Clear Database, 4 - Show Cyclones, 5 - Swap Cyclones");
            System.out.print("Select an option: ");
            userMen = gConsole.nextInt();
            if(userMen>5 || userMen <0) {
                System.out.println("Invalid value, please, try again.");
            }
        }while(userMen>5 || userMen <0);
        return userMen;
    }

    //Main Method
    public static void main(String[] args){
        int userMen;
        System.out.println("Fall2023 - UTSA - CS1083 - Section 005 - Project 2 - Cyclone - Written by Yousef Noor" + "\n");

        //Getting information from user for array length
        System.out.print("Please, enter the number of cyclones in the database (Max 50): ");
        gDatabaseSize = gConsole.nextInt();
        while(gDatabaseSize > gMAX_CYCLONES || gDatabaseSize < 0) {
            System.out.println("Invalid value, please, try again." + "\n");
            System.out.print("Please, enter the number of cyclones in the database (Max 50): ");
            gDatabaseSize = gConsole.nextInt();
        }
        gWindSpeed = new double[gDatabaseSize];



        //Sending user input to each method
        do {
            userMen = menu();

            if (userMen == 1) {
                gWindSpeed = addUpdCyclone();
            } else if (userMen == 2) {
                summary();
            }
            else if (userMen == 3){
                gWindSpeed = clearDatabase();
            }
            else if (userMen == 4){
                showCyclones();
            }
            else if (userMen == 5){
                swapCyclones();
            }


        }while(userMen!=0);

        System.out.println("Thank you for looking at the cyclone database program!");

    }
}