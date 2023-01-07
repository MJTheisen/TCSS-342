public class PriorityQueue {

    int max;
    int[] array;
    int numItems;

    public PriorityQueue(){
        max = 256;
        array = new int[max];
        numItems = 0;
    }

    public void addelement(int value){
        int i;
        if(numItems == 0){
            array[0] = value;
            numItems++;
            return;
        }
        for (i = numItems - 1; i >- 0; i--){
            if( value > array[i]){
                array[i+1] = array[i];

            }else{
                break;
            }
        }
        array[i+1] =value;
        numItems++;
    }
    public void outPriorityQueue() {
        for(int i = 0; i <numItems; i++) {
            System.out.println(array[i]+"");
        }
    }
    public int removeNext() {
        return array[--numItems];
    }
    public boolean isFull() {
        return numItems == max;
    }
    public boolean isEmpty(){
        return numItems == 0;
    }



}
