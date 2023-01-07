// Michael Theisen

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanEncoding {

    private static final int ASCII = 256;

    public HuffmanEncodeAnswer compress(final String data){
        final int[] frequency = buildFrequencyTable(data);
        final HuffNode root = buildHuffmanTree(frequency);
        final Map<Character, String> lookupTable = buildLookupTable(root);
        return new HuffmanEncodeAnswer(generateEncodeData(data, lookupTable), root);
    }

    private static String generateEncodeData(String data, Map<Character, String> lookupTable) {
        final StringBuilder sb = new StringBuilder();
        for(final char character : data.toCharArray()) {
            sb.append(lookupTable.get(character));
        }
        return sb.toString();
    }

    private static Map<Character, String> buildLookupTable(final HuffNode root){
        final Map<Character, String> lookupTable = new HashMap<>();
        buildLookupTableImpl(root, "", lookupTable);
        return lookupTable;
    }

    private static void buildLookupTableImpl(HuffNode node, String s, Map<Character, String> lookupTable) {
        if(!node.isLeaf()){
            buildLookupTableImpl(node.myLeft, s + '0', lookupTable);
            buildLookupTableImpl(node.myRight, s + '1', lookupTable);
        } else {
            lookupTable.put(node.myChar, s);
        }
    }

    private static HuffNode buildHuffmanTree(int[] frequency){

        final PriorityQueue<HuffNode> myQueue = new PriorityQueue<>();
        for(char i = 0; i < ASCII; i++ ) {
            if(frequency[i] > 0) {
                myQueue.add(new HuffNode(i, frequency[i], null, null));
            }
        }
        if(myQueue.size() == 1) {
            myQueue.add(new HuffNode('\0', 1,null, null));
        }
        while(myQueue.size() > 1 ) {
            final HuffNode left = myQueue.poll();
            final HuffNode right = myQueue.poll();
            final HuffNode parent = new HuffNode('\0',left.myFrequency+ right.myFrequency, left, right);
            myQueue.add(parent);
        }
        return myQueue.poll();
    }

    private static int[] buildFrequencyTable(final String data) {
        final int[] myFrequency = new int[ASCII];
        for(final char myChar : data.toCharArray()){
            myFrequency[myChar]++;
        }
        return myFrequency;
    }

    public String decompress(final HuffmanEncodeAnswer result) {
        final StringBuilder sb2 = new StringBuilder();
        HuffNode currentNode = result.getRoot();
        int i = 0;
        while(i < result.getEncodedData().length()) {
            while(!currentNode.isLeaf()) {
                char bit = result.getEncodedData().charAt(i);
                if(bit == '1'){
                    currentNode = currentNode.myRight;
                }else if (bit == '0'){
                    currentNode = currentNode.myLeft;
                }else{
                    throw new IllegalArgumentException("Invalid bit! " +bit );
                }
                i++;
            }
            sb2.append(currentNode.myChar);
            currentNode = result.getRoot();
        }
        return sb2.toString();
    }

    static class HuffNode implements Comparable<HuffNode> {
        private final char myChar;
        private final int myFrequency;
        private final HuffNode myLeft, myRight;
        private HuffNode(final char myChar, final int frequency, final HuffNode leftChild, final HuffNode rightChild){
            this.myChar = myChar;
            this.myFrequency = frequency;
            this.myRight = rightChild;
            this.myLeft = leftChild;
        }
        boolean isLeaf(){
            return this.myLeft == null && this.myRight == null;
        }
        @Override
        public int compareTo(HuffNode o) {
            final int frequencyComparison = Integer.compare(this.myFrequency, o.myFrequency);
            if(frequencyComparison != 0 ){
                return frequencyComparison;
            }
            return Integer.compare(this.myChar, o.myChar);
        }
    }
    static class HuffmanEncodeAnswer{
        final HuffNode root;
        final String encodedData;
        HuffmanEncodeAnswer(final String encodeData, final HuffNode root){
            this.encodedData = encodeData;
            this.root = root;
        }
        public HuffNode getRoot() {
            return this.root;
        }
        public String getEncodedData(){
            return this.encodedData;
        }
    }


    public static void main(String[] args) {
        final String test = ("\neeyjjjj\n"
                + "Eerie eyes seen near lake\n"
                + "BACADAEAFABBAAAGAH\n"
                + "May the Force be with you !\n"
                + "Veni, vidi, vici.\n" );

        final HuffmanEncoding encoding = new HuffmanEncoding();

        final HuffmanEncodeAnswer result = encoding.compress(test);
        System.out.println("Original text is " + test);
        System.out.println("Encoded is " + result.encodedData +"\n" );
        System.out.println("Decoded is " + encoding.decompress(result));





    }
}
