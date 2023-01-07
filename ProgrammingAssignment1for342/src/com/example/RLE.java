package com.example;

public class RLE {

    // Takes what is not encoded and encodes it.
    public static String encode(String original){
        // Takes in wwwwaaadexxxxxx and returns 4w3a1d1e6x
        // Count occurrence of the same character in the given input
        // If a new character is found append the character and count in the result
        // Continue until the end original string.

        StringBuilder sb = new StringBuilder();
        int lengthOriginal = original.length();
        char last = original.charAt(0);
        int count = 1;
        for (int i = 1; i <= lengthOriginal; i++) {
            if (i == lengthOriginal) {
                sb.append(count).append(last);
                break;
            }
            char current = original.charAt(i);
            if (last == current) {
                count++;
            } else {
                sb.append(count).append(last);
                last = current;
                count = 1;
            }
        }
        return sb.toString();
    }

    // Takes what is encoded and decodes it.
    public static String decode(String jumbled) {
        // I actually built a decoder for
        // this first because I thought it
        // would be cool. Turned out to be
        // pretty useful.
        // Takes in 4w3a1d1e6x and returns wwwwaaadexxxxxx
        StringBuilder sb = new StringBuilder();
        int length = jumbled.length();
        char last = jumbled.charAt(0);
        int i = 0;
        while (i <jumbled.length()){
            int repeats = 0;
            while ((i < jumbled.length()) && Character.isDigit(jumbled.charAt(i))){
                repeats = repeats * 10 + jumbled.charAt(i++) - '0';
            }
            // resets with each new letter
            StringBuilder sb2 = new StringBuilder();
            //
            while ((i < jumbled.length()) && !Character.isDigit(jumbled.charAt(i))) {
                sb2.append(jumbled.charAt(i++));
            }

            //Repeats until the number of characters is output
            if (repeats > 0) {
                for (int j = 0; j < repeats; j++) {
                    sb.append(sb2.toString());
                }
            } else {
                sb.append(sb2.toString());
            }
        }
        return sb.toString();
    }

    // Takes 2 parameters and tests equality with true or false.
    public static boolean equal(String string1, String string2) {
        // Is AAA equal to AAA? true.

        if (string1.equals(string2)) {
            return true;
        }else{
            return false;
        }
    }

    // NOTES
    // should I use .hasNextLine() ? .nextString??
    // how to add .txt to LL
    public static void main(String[] args) {
        //for tests
        System.out.println("Expected: ");
        System.out.println("4w3a1d1e6x");
        System.out.println("Result");
        System.out.println(encode("wwwwaaadexxxxxx"));
        System.out.println();

        System.out.println("Expected: ");
        System.out.println("wwwwaaadexxxxxx");
        System.out.println("Result");
        System.out.println(decode("4w3a1d1e6x"));
        System.out.println();

        System.out.println(equal("hello","hello"));
        System.out.println(equal("hello","world"));
        System.out.println(equal(decode("4w3a1d1e6x"),decode("4w3a1d1e6x")));
        System.out.println(equal(decode("4w3a1d1e6x"),decode("4w1d1e6x")));

    }

}




// Below is the original RLE that I could
// not get to work. I began a few times
// from scratch and this is the final attempt.




//    static class Node
//    {
//        char data;
//        Node next;
//    };
//    static Node charNode(char data) {
//        LinkedList.Node temp = new LinkedList.Node();
//        temp.data = data;
//        temp.next = null;
//        return temp;
//    }
//    public void add(Node head, char data) {
//        // create new node
//
//        LinkedList.Node myNode = new LinkedList.Node();
//
//        myNode.next = null;
//
//        // check if LinkedList is empty
//        if(head == null){
//            head = myNode;
//        } else {
//            // check if LinkedList is not empty
//            LinkedList.Node myNode2 = head;
//            while(myNode2.next != null){
//                myNode2 = myNode2.next; // Null by default
//            }
//            myNode2.next = myNode;
//        }
//    }
//
//    // takes the SLL as the parameter & prints the encoded string
//    public void encode(LinkedList.Node head){
//        LinkedList.Node rleNode = head;
//        LinkedList.Node tempNode = charNode(rleNode.data);
//
//        char storage = rleNode.data;
//        rleNode = rleNode.next;
//        int count = 1;
//
//        while(rleNode != null){
//            char storage2 = rleNode.data;
//            if (storage == storage2)
//                count++;
//            else{
//
//            }
//            count = 1;
//            add(storage);
////                if (count > 1){
////                 //   if( count > 9)
////                      //  LinkedList.add(tempNode, (char) ('0' + (count / 10)));
////                       // LinkedList.add((char) ('0' + (count % 10)));
////
////                }
////                count = 1;
////            }
//        }
//    }
//    //takes the encoded string as the parameter and prints the decoded SLL
//    public static void decode(){
//    }
//    //takes 2 SLL as parameters and returns true if they represent the same sequence and false if they are not the same
//    public static void equal(){
//    }
//
//    public static void main(String[] args) {
//        LinkedList.Node head = RLE.charNode('a');
//        LinkedList.Node head.next = RLE.charNode('a');
//    }
//}
//
//        for (int i = 1; i <= length; i++) {
//            // Add to the final
//            if (i == length) {
//                for (int j = 0; j < Integer.parseInt(sb2.toString()); j++){
//                    sb.append(last);
//                }
//                break;
//            }
//            char current = jumbled.charAt(i);
//            // For
//            if (Character.isDigit(current)){
//                sb2.append(current);
//            } else {
//                for (int j = 0; j < Integer.parseInt(sb2.toString()); j++){
//                    sb.append(last);
//                }
//                last = current;
//                sb2 = new StringBuilder(); // Amount of repeats
//            }
//        }
