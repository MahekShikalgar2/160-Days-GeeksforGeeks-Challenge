class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    LRUCache(int cap) {
        this.capacity = cap;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

        
    public void put(int key, int value) {
      if(cache.containsKey(key)){
          Node oldNode = cache.get(key);
          remove(oldNode);
          cache.remove(key);
      }
      Node node = new Node(key, value);
      add(node);
      cache.put(key, node);
      if(cache.size() > capacity){
          Node lru = head.next;
          remove(lru);
          cache.remove(lru.key);
      }
      
    }
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private void add(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
       
    }
}