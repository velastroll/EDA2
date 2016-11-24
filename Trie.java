import java.util.*;
/**
 *
 * @author javhelg
 * @author alvvela
 *
 **/
public class Trie {

    public static int clave_encontrada;
    HashMap<Integer, HashMap> raiz;

    public Trie() {
       raiz = new HashMap<Integer, HashMap>();
    }


    public void add(int [] v) {
        HashMap<Integer, HashMap> nodo_actual = raiz;
        for (int i = 0, n = v.length; i < n; i++) {
            Integer num = v[i];
            if (nodo_actual.containsKey(num))
                nodo_actual = nodo_actual.get(num);
            else {
                nodo_actual.put(num, new HashMap<Integer, HashMap>());
                nodo_actual = nodo_actual.get(num);
            }
        }
    }

    public boolean contiene(int[] v) {
        HashMap<Integer, HashMap> nodo_actual = raiz;
        for (int i = 0, n = v.length; i < n; i++) {
            Integer num = v[i];
            if (nodo_actual.containsKey(num))
                nodo_actual = nodo_actual.get(num);
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
   }
}