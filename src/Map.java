// Eine Map speichert Values, die mit Keys assoziiert werden. 
@Author("Florian")
public class Map<K, V> {
    Node head = null;
    private class Node {
        private K key;
        private V value;
        private Node next;
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
    
    // NV: Mapping k->v eingefuegt. Wenn Rueckgabewert true wurde
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
}
