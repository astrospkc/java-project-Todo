
// in this project steps inlcuded are:
// 1. Use CRUD operation
// a. First Create a list and add items to the list
// b. Allow user to read the list , to check all the items in the list whether all the items are present or not.
// c. Update the list ,do some changes in the list.
// d. Delete some items if not needed.
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;


public class todo{

    private static Scanner scanner = new Scanner(System.in);
    static int operation;

    public static int choose(){
        System.out.println("------------Choose any one from the below to operate any process:------------ ");
        System.out.println("-             Press 1 -> To add items            -");
        System.out.println("-             Press 2 -> To delete items from the list and updating the list         -");
        System.out.println("--------------Press 3 -> To read the list--------------");
        
        // String input = scanner.nextLine();
        // int track = Integer.parseInt(input);
        // return track;

        int track = scanner.nextInt();
        operation = track;
        return operation;
    }

    static void addItems(File file){
        
        try{
            FileWriter fwrite = new FileWriter(file, true);
            if(file.length()==0){
                fwrite.write("------------ToDO list- --------------");
                fwrite.close();
            }
            
            System.out.println("\n\n------------------------Fill up the item list---------------------");
            while(true){
                System.out.println("-       Enter 1 to add , 0 to stop           -");
                int stop = scanner.nextInt();
                if(stop==0){
                    System.out.println("****************Exiting the addding item list****************");
                    break;
                }else{
                    scanner.nextLine();
                    String item = scanner.nextLine();
                    System.out.println("----You entered: "+ item);
                    fwrite.write(item +"\n");

                }
                
            }
            fwrite.close();
            choose();
       
        }catch(IOException e){
            System.out.println("An unexpected error occured");
            e.printStackTrace();
        }
        
    }

    static void deleteItems(File file){
        String itemToDelete = scanner.next();
        try {
            List<String> lines = readFile(file); // read content from the file
            deleteWord(lines, itemToDelete); // delete word if present
            writeFile(file, lines);
            System.out.println("Item " + itemToDelete + " successfully deleted from the file");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        choose();
    }

    static List<String> readFile(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
        } 
        return lines;
    }

    static void deleteWord(List<String> lines, String wordToDelete){
        for(int i=0; i<lines.size(); i++){
            lines.set(i, lines.get(i).replace(wordToDelete,""));
        }
    }

    static void writeFile(File file, List<String> lines) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(String line : lines){
                writer.write(line);
                writer.newLine();
            }

        }

    }

    static void updateItems(File file){

    }

    static void readItems(File file){

        if(file.length()==0){
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!  No item is present in it. Add items to it    !!!!!!!!!!!!!!!!!!");
                addItems(file);
                
            }
        try{
            FileReader fileRead = new FileReader(file);
            BufferedReader bufferedRead = new BufferedReader(fileRead);
            String line;
            
            while((line = bufferedRead.readLine())!= null){
                System.out.println(line);
            }
            bufferedRead.close();
            fileRead.close();

        }catch(IOException e){
            System.out.println("unexpected error occurred.");
            e.printStackTrace();

        }

        choose();


    }
    
    public static void main(String[] args){
        choose();
        File ToDofile = new File("Todofile.txt");
        
        System.out.println("----------The choosen value: "+ operation);
        while(operation == 1||operation==2||operation==3){

        
        switch(operation){
            case 1:

                System.out.println("------------------------Add your items-------------------------");
                addItems(ToDofile);
                break;
            case 2:
                System.out.println("------------------------Delete items that you want to delete and update it accordingly------------------------");
                deleteItems(ToDofile);
                break;
           
            case 3:
                System.out.println("------------------------Read the list------------------------");
                readItems(ToDofile);
                break;
            default:
                System.out.println("there is no such option");

        }
    }
    System.out.println("------------------------You have successfully exited the program------------------------");

    

    }
}