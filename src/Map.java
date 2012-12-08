import java.util.Iterator;

// Eine Map speichert Values, die mit Keys assoziiert werden. 
@Author("Florian")
public class Map<K, V> implements Iterable<V> {
    private Node head = null;
    private class Node {
        private K key;
        private V value;
        private Node next;
    }
    
    private class Iter implements Iterator<V> {
        private Node next = head;
        @Override
        public boolean hasNext() {
            return next != null;
        }
        
        @Override
        public V next() {
            V v = next.value;
            next = next.next;
            return v;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    // NB: Gib value zurueck, der mit k assoziiert ist.
    // Gib null zurueck, wenn kein value mit k assoziiert.
    @Author("Florian")
    public V find(K k) {
        for (Node c = head; c != null; c = c.next) {
            if (c.key.equals(k)) {
                return c.value;
            }
        }
        return null;
    }
    
    // NB: Mapping k->v eingefuegt. Wenn Rueckgabewert true wurde
    // es neu eingefuegt, sonst ein altes mit der neuen value
    // ersetzt.
    @Author("Florian")
    public boolean insert(K k, V v) {
        for (Node c = head; c != null; c = c.next) {
            if (c.key.equals(k)) {
                c.value = v;
                return false;
            }
        }
        
        Node a = new Node();
        a.key = k;
        a.value = v;
        a.next = head;
        head = a;
        return true;
    }
    
    // NB: Mapping k->v entfernt. Gibt true zurueck, wenn es existierte.
    // sonst false.
    @Author("Florian")
    public boolean remove(K k) {
        Node l = null;
        for (Node c = head; c != null; c = c.next) {
            if (c.key.equals(k)) {
                if (l == null) {
                    head = c.next;
                } else {
                    l.next = c.next;
                }
                return true;
            }
            l = c;
        }
        return false;
    }
    
    @Override
    @Author("Florian")
    public Iterator<V> iterator() {
        return new Iter();
    }
    
    public static void main(String[] args) {
        Map<String, Integer> mp = new Map<String, Integer>();
        mp.insert("Hallo", 1);
        mp.insert("Welt", 2);
        System.out.println(mp.find("Hallo"));
        System.out.println(mp.find("Welt"));
        mp.insert("Welt", 3);
        System.out.println(mp.find("Welt"));
        mp.remove("Welt");
        System.out.println(mp.find("Welt"));
    }
}
