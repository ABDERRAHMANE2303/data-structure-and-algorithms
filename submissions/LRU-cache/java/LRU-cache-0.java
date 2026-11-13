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
            //remove from position
            ListNode prev = node.prev,next = node.next;
            prev.next = next;
            next.prev = prev;
            //move node to tail
            node.next = tail;
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            
            return cache.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == cache.size() && !cache.containsKey(key)) {
            ListNode removedNode = head.next;
            int removedKey = removedNode.key;
            head.next = removedNode.next;
            removedNode.next.prev = head;
            cache.remove(removedKey);
        }

        if (!cache.containsKey(key)){
            ListNode node = new ListNode(key,value);
            node.next = tail;
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            cache.put(key,node);
        }else {
            ListNode node = cache.get(key);
            node.val = value;
            //removing the node
            ListNode prev = node.prev,next = node.next;
            prev.next = next;
            next.prev = prev;
            //inserting it at the end 
            node.next = tail;
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
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
}

/*mid removal

prev node next 
prev -> next and prev <- next

next = node.next
prev = node.prev
prev.next = next
next.prev = prev
*/

/*head removal 

head node next 
head -> next and head <- next

node = head.next
next = node.next
head.next = next
next.prev = head

*/



