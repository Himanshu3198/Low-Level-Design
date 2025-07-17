package JavaNotes;

import java.util.HashMap;
import java.util.Map;

public class HashMapUses {
    public static void main(String[] args) {
        Map<String, Map<String,Double>> map = new HashMap<>();

        map.computeIfAbsent("d1",k->new HashMap<>()).put("s1",300.0);
        System.out.println(map.get("d1").get("s1"));

        System.out.println(map.get("d1").get("s2"));
    }
}
