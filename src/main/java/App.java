import com.hashtable.MyHashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        System.out.println( "This contains LLD system design practice" );
        MyHashMap<String, Integer> hashMap = new MyHashMap<String,Integer>(100);
        hashMap.put("First", 1);
        hashMap.put("First", 2);
        System.out.printf("Finding for the key: ' %s ', " + "is the value: " + hashMap.get("First"), "First");
    }
}
