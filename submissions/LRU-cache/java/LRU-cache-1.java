class LRUCache {
    final int capacity;
    final Map<Integer,ListNode> cache = new HashMap<>();
    final ListNode head = new ListNode(), tail = new ListNode();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            remove(node);
            addLast(node);
            return cache.get(key).val;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            ListNode node = cache.get(key);
            node.val = value;
            remove(node);
            addLast(node);
        }else {
            if (capacity == cache.size()){
                ListNode removedNode = head.next;
                int removedKey = removedNode.key;
                remove(removedNode);
                cache.remove(removedKey);
            }
            ListNode node = new ListNode(key,value);
            node.next = tail;
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            cache.put(key,node);
        }
    }
    private static class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;
        ListNode(){}
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            }
    }
    private void remove(ListNode node){
        ListNode prev = node.prev,next = node.next;
            prev.next = next;
            next.prev = prev;
    }
    private void addLast(ListNode node){
        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
    }
}



