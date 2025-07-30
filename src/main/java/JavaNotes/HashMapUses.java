package JavaNotes;

import java.util.HashMap;
import java.util.Map;

public class HashMapUses {
    public static void main(String[] args) {
        Map<String, Map<String,Double>> map = new HashMap<>();

        map.computeIfAbsent("d1",k->new HashMap<>()).put("s1",300.0);
        System.out.println(map.get("d1").get("s1"));

        System.out.println(map.get("d1").get("s2"));

        Map<Integer,Integer> mp = new HashMap<>();

        mp.put(1,2);
        mp.put(2,4);
        mp.computeIfAbsent(2,k->0);
        System.out.println(mp.get(2));

        mp.put(3,2);
        System.out.println(mp.getOrDefault(4,0)+1);

        for(Map.Entry<Integer,Integer> it:mp.entrySet()){
            System.out.println(it.getKey()+","+it.getValue());
        }
    }
}
