package ProgAssignHashing;

import java.util.Arrays;

public class HashTable {
    String[] myArray;
    int arraySize;
    int items = 0;

    // Make Hash Table
    HashTable(int size){
        arraySize = size; // give the array a size
        myArray = new String[size]; // create the array
        Arrays.fill(myArray, "-1"); // fill the array with just -1
    }

    // this is a method to check whether or not a value is prime
    // if the value is to be used as a table size.
    public boolean isPrime(int value){
        if(value % 2 == 0)
            return false;
        for (int i = 3; i * i<=value; i += 2){
            if (value % i == 0)
                return false;
        }
        return true;
    }

    // this is the actual Hash Function
    public void hashFunction(String[] stringsForArray, String[] myArray){
        for (int n = 0; n < stringsForArray.length; n++){

            String newValue = stringsForArray[n];
            int arrayIndex = Integer.parseInt(newValue) % 23;
            System.out.println("index = " + arrayIndex+ " for value " +newValue);
            while(myArray[arrayIndex] != "-1"){
                ++arrayIndex;
                System.out.println("collision, probing index " +arrayIndex);
                arrayIndex %= arraySize;
            }
            myArray[arrayIndex] = newValue;
        }
    }

    // for finding the key
    public String getKey(String key){
        int arrayIndex = Integer.parseInt(key) % 23;
        while(myArray[arrayIndex] != "-1"){
            if(myArray[arrayIndex] == key ){
                System.out.println(key+ " was found in index " + arrayIndex  );
                return myArray[arrayIndex];
            }
            ++arrayIndex;
            arrayIndex %= arraySize;
        }
        return null;
    }

    //displays
    public void displayMyHashTable() {
        int increment = 0;
    }




}
