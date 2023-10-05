import com.hashtable.MyHashMap;
import com.lrucache.LRUCache;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "This contains LLD system design practice" );
        // for executing HashMap
//        MyHashMap<String, Integer> hashMap = new MyHashMap<String,Integer>(100);
//        hashMap.put("First", 1);
//        hashMap.put("First", 2);
//        System.out.printf("Finding for the key: ' %s ', " + "is the value: " + hashMap.get("First"), "First");
        // for executing LRUCache
        LRUCache lru = new LRUCache(3);
        lru.put(1, 10);
        lru.put(2, 20);
        System.out.println(lru.get(3));
        System.out.println(lru.get(2));
        lru.put(3,30);
        lru.put(4,40);
        System.out.println(lru.get(1));
        System.out.println(lru.get(4));
    }
}
