package com.example;

// imports for read and write to txt files
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Driver class accept the input file,
// interact with the LinkedList and RLE classes,
// generates the expected output
public class Driver {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
//
//        LinkedList.Node head = RLE.charNode('a');
//        LinkedList.Node head = RLE.charNode('6');
//        LinkedList.Node head = RLE.charNode('a');
//        LinkedList.Node head = RLE.charNode('a');
//        LinkedList.Node head = RLE.charNode('a');

        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
        System.out.println("\n" + "The size of the LinkedList is " + list.size() + "\n");
        System.out.println(list);


        try {
            BufferedReader reader = new BufferedReader(new FileReader("Input.txt"));
//            String line;
//            while((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //this is for the output text
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"));

            writer.write("Test1:Input for Encoding\n" +
                    RLE.encode("wwwwaaadexxxxxx") +"\n"+// should just be line 2
                    RLE.encode("daaaaaaaaaatttaaaaaaaaSSSSSSSttrrrrrrruuuuuuuuuuuuuuuuuctuuuuuuuuurrrrrrrrrrrrrrrrrrrrrrrrrrrrrreeeessS") +"\n"+ // should just be line 3 input
                    RLE.encode("this is a really long sentence") +"\n"+ // should just be line 4 input
                    "Test2:Input for Decoding\n"+
                    RLE.decode("3a1b3c3d2a")+"\n"+
                    RLE.decode("6A1F2D7C1A17E")+"\n"+
                    RLE.decode("5#3!1%2&6*")+"\n"+
                    "Test3:Input for Equality\n"+
                    RLE.equal(RLE.decode("3a1b"), RLE.decode("2a1a1b"))+"\n"+
                    RLE.equal(RLE.decode("3a1b3c"), RLE.decode("2a1a1b2c1d"))+"\n"+
                    RLE.equal(RLE.decode("4F"), RLE.decode(" "))+"\n"+
                    RLE.equal(RLE.decode("2(4[1*4]2)"), RLE.decode("2(4[1*4]2)"))+"\n"+
                    "\n" + "The size of the LinkedList is " + list.size() + "\n"+
                    list );
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //this is for the readme text
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("ReadMe.txt"));
            writer.write("a. Time Complexity of encode(), decode() and equal() methods in terms of Big-O notation.\n " +
                    "    The Big O for encode should be O(n), the big O for decode should be O(n), and for equal, it \n" +
                    "     should be O(n) unless the two strings are exact, then it would be O(1)\n" +
                    "    " +
                    "\n" +
                    "b. What are the advantages and disadvantages of RLE? What are the applications of RLE?\n" +
                    "\n" +
                    "     There is a disadvantage to RLE when it is used on large sequences of data the frequently\n" +
                    "     changes between values. This may even increase the size of the data since an instance of\n" +
                    "     a single character would result in to characters defining the size and the character. For\n" +
                    "     example, ABCDEFGHIJ would be 1A1B1C1D1E1F1G1H1I1J.\n" +
                    "\n" +
                    "     The advantages would be any situation when using long strings of 1's and 0's such as\n" +
                    "     fax machines and black and white printers.\n" +
                    "\n" +
                    "c. Amount of time you spent on implementing the assignment? Challenges you faced while\n" +
                    "implementing the assignment? How did you overcome these challenges?\n" +
                    "\n" +
                    "     I have currently spent an exhausting amount of time on this. I spend roughly 5 hours per day.\n" +
                    "     I will get home around 5:00 and then work on it until bedtime. It took me the first week from \n" +
                    "     Monday the 24th of January until the 30th just to get the LinkedList working and from the 31st \n" +
                    "     until the 2nd, to get the BufferedReader and Writer to work. Today is Friday and the assignment \n" +
                    "     is now late by a week and I will get 5 points removed. I assumed I would have been able to finish \n" +
                    "     by now, but I am still having trouble getting the program to parse through the .txt file.\n" +
                    "     I have the pseudocode written out, but I just do not know enough about Java to get it to work. \n" +
                    "     Everytime I think it will work, I keep getting hit with errors so what I did was take the \n" +
                    "     input.txt and manually type it into the section where the output.txt would import, I'm going to keep\n" +
                    "     working on it though. I have also spent a few hours trying to figure out how to get rid of the Main \n" +
                    "     Class that I started with since its not supposed to be in the export file but I do not know how. \n" +
                    "     I also couldn't get the output to display in a LinkedList form because the method kept messing up.\n" +
                    "     Also compression ratio. Would more time help? I think so, yes. I did work on this until the last moment.\n" +
                    "     I had to spend a significant amount of time learning new things that we didn't do in class and\n " +
                    "     have never covered in previous classes.  \n ");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
