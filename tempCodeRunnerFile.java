
// in this project steps inlcuded are:
// 1. Use CRUD operation
// a. First Create a list and add items to the list
// b. Allow user to read the list , to check all the items in the list whether all the items are present or not.
// c. Update the list ,do some changes in the list.
// d. Delete some items if not needed.

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class todo{

    public static void addItems(File file){
        
        try{
            FileWriter fwrite = new FileWriter(file);
            if(file.length()==0){
                fwrite.write("------------ToDO list- --------------");
                fwrite.close();

            }
            if(file.createNewFile()){
            
                System.out.println("File "+ file.getName() + " is created successfully.");
                
                
            }else{
                System.out.println("File already exist");
            }
            
        }catch(IOException e){
            System.out.println("An unexpected error occured");
            e.printStackTrace();
        }
        
    }

    public static void deleteItems(File file){

    }

    public static void updateItems(File file){

    }

    public static void readItems(File file){

    }
    public static void main(String[] args){

        // step a.
        // write the item name and after writing , press 0 to add or 1 to discard.
        File ToDofile = new File("Todofile.txt");
        System.out.println("Choose any one from the below to operate any process: ");
        System.out.println(" Press 1 -> To add items");
        System.out.println("Press 2 -> To delete items from the list.");
        System.out.println("Press 3-> To update the list");
        System.out.println("Press 4 -> To read the list");

        Scanner scanner = new Scanner(System.in);
        int select_number = scanner.nextInt();
        
        switch(select_number){
            case 1:
                System.out.println("Add your items-");
                addItems(ToDofile);
                break;
            case 2:
                System.out.println("Delete items that you want to delete");
                deleteItems(ToDofile);
                break;
            case 3:
                System.out.println("Update your list");
                updateItems(ToDofile);
                break;
            case 4:
                System.out.println("Read the list");
                readItems(ToDofile);
                break;
            default:
                System.out.println("there is no such option");

        }

        addItems(ToDofile);

    }
}