import java.util.*;

public class Trie {

    public static int clave_encontrada;
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
        			clave_encontrada = p;
        			return true;
        		}
        	}
            return true;}
        else
            return false;
    }

    public static int getClaveEncontrada(){
        return clave_encontrada;
    }

   public static void main(String[] args) {
        Trie t = new Trie();
        int evil_vector[] = {101, 118, 105, 108, 46,99, 111, 114, 112, 64, 109, 97, 100, 46, 111, 114, 103,256,65535};
        int prueba[]={101, 118, 105, 108, 46,99, 111, 114, 112, 64, 109, 97, 100, 46, 111, 114, 103};
        t.add(evil_vector);
        System.out.println(t.contiene(prueba));
   }
}