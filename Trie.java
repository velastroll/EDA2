
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
import java.util.*;

public class Trie {

<<<<<<< Updated upstream
    HashMap<Integer, HashMap> root;

    public Trie() {
       root = new HashMap<Integer, HashMap>();
    }


    public void add(int [] s) {
        HashMap<Integer, HashMap> nodo_actual = root;
        for (int i = 0, n = s.length; i < n; i++) {
            Integer c = s[i];
            if (nodo_actual.containsKey(c))
                nodo_actual = nodo_actual.get(c);
            else {
                nodo_actual.put(c, new HashMap<Integer, HashMap>());
                nodo_actual = nodo_actual.get(c);
            }
        }
    }

    public boolean contiene(int[] s) {
        HashMap<Integer, HashMap> nodo_actual = root;
        for (int i = 0, n = s.length; i < n; i++) {
            Integer c = s[i];
            if (nodo_actual.containsKey(c))
                nodo_actual = nodo_actual.get(c);
            else {
                return false;}
        }
        if (nodo_actual.containsKey(256)){
        	nodo_actual = nodo_actual.get(256);
        	for (int p = 0; p<65536; p++){
        		if (nodo_actual.containsKey(p)){
        			System.out.println(p);
        			return true;
        		}
        	}
            return true;}
        else
            return false;
    }

   public static void main(String[] args) {
        Trie t = new Trie();
        int evil_vector[] = {101, 118, 105, 108, 46,99, 111, 114, 112, 64, 109, 97, 100, 46, 111, 114, 103,256,65535};
        int prueba[]={101, 118, 105, 108, 46,99, 111, 114, 112, 64, 109, 97, 100, 46, 111, 114, 103};
        t.add(evil_vector);
        //evil_vector[17]=1;
        System.out.println(t.contiene(prueba));

=======
    HashMap<Character, HashMap> root;

    /**
     *  Default contructor
     */
    public Trie() {
       root = new HashMap<Character, HashMap>();
    }

    /**
     *  Contructor that takes a String[] of words to add
     *
     *  @param sa a String[] of words to be added
     */
    public Trie(String[] sa) {
        this(); 
        addAll(sa);
    }

    /**
     *  Constructor that takes a Collection<String> of words to add
     *
     *  @param sc a Collection<String> of words to be added
     */
    public Trie(Collection<String> sc) {
        this();
        addAll(sc);
    }

    /**
     *  Adds a string to the trie
     * 
     *  @param s String to add to the trie
     */
    public void add(String s) {
        HashMap<Character, HashMap> curr_node = root;
        for (int i = 0, n = s.length(); i < n; i++) {
            Character c = s.charAt(i);
            if (curr_node.containsKey(c)){
                curr_node = curr_node.get(c); }
            else {
                curr_node.put(c, new HashMap<Character, HashMap>());
                curr_node = curr_node.get(c);
            }
        }
        curr_node.put('\0', new HashMap<Character, HashMap>(0)); // term
    }

    /**
     *  Adds a String[] of words to the trie
     * 
     *  @param sa String[] to add to the trie
     */
    public void addAll(String[] sa) {
        for (String s: sa){
            add(s); }
    }

    /**
     *  Adds a Collection<String> of words to the trie
     * 
     *  @param sc Collection<String> to add to the trie
     */
    public void addAll(Collection<String> sc) {
        for (String s: sc) {
            add(s); }
    }

    /** 
     *  Returns true if the String is in the trie
     *
     *  @param s query
     *  @return true if the query is in the trie
     */
    public boolean contains(String s) {
        HashMap<Character, HashMap> curr_node = root;
        for (int i = 0, n = s.length(); i < n; i++) {
            Character c = s.charAt(i);
            if (curr_node.containsKey(c)) {
                curr_node = curr_node.get(c); }
            else {
                return false; }
        }
        if (curr_node.containsKey('\0')) {
            return true; }
        else {
            return false; } 
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("APPLE");
        t.add("APPLESAUCE");
        t.add("APPLICATION"); 
        System.out.println(t.contains("FOO")    + " " + false);
        System.out.println(t.contains("APPL")   + " " + false);
        System.out.println(t.contains("APPLES") + " " + false);
        System.out.println(t.contains("APPLE")  + " " + true);
>>>>>>> Stashed changes
    }
}
