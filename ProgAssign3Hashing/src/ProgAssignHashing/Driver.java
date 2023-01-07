package ProgAssignHashing;

import java.io.*;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {

        HashTable myTable = new HashTable(30000);

        // pass in words.txt not values
        String[] elements = { "110", "760", "270", "213", "258", "198",
                "235", "88", "90", "72", "649", "176", "6", "999", "80",
                "75", "98", "978", "968", "99", "999", "982", "32", "34",
                "20", "15", "560", "654", "460", "624","999", "982", "32",
                "134", "120", "115", "160", "154", "160", "614"};
        myTable.hashFunction(elements, myTable.myArray);
        myTable.getKey("88");

        // pass out into output.txt
        myTable.displayMyHashTable();

        //why doesnt this work???
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src\\ProgAssignHashing\\words.txt"));
            String line;
            while((line = reader.readLine()) != null) {
                String[] elements2 = null;
                elements2 = line.split(",");
                //myTable.hashFunction(elements, myTable.myArray);
                //myTable.getKey("88");
                // pass out into output.txt
                System.out.println(Arrays.toString(elements2));
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\ProgAssignHashing\\Output.txt"));
                    // how to make this go in the package folder
                    writer.write( "Line 1\n");
                    writer.write( "Line 2\n");

                    // need some sort of while loop here but
                    // so far each attempt fails.
                    writer.write(Arrays.toString(elements2));

                    writer.write("\n\nI don't know why it only writes the last string in the array and not the whole array...");

                    // writer.write(//I want it to write the table.);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\ProgAssignHashing\\Output.txt"));
//            // how to make this go in the package folder
//            writer.write( "Line 1");
//            writer.write( "\nLine Two");
//            writer.write(Arrays.toString(elements));
//
//            // writer.write(//I want it to write the table.);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }


}
