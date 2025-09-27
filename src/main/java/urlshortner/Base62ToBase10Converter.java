package urlshortner;

public class Base62ToBase10Converter {


    public static long base62ToDecimal(String base62Id){
        long result = 0;
        for(int i=0;i<base62Id.length();i++){
            int val = charToValue(base62Id.charAt(i));
            result = result * 62 + val;
        }
        return  result;
    }

    private static int charToValue(Character c){
        if(c >= '0' && c <= '9') return c - '0';
        if(c >= 'A' && c <= 'Z') return 10 + c - '0';
        if(c >= 'a' && c <= 'z') return 36 + c - '0';
        throw new IllegalArgumentException("Invalid Base62 character: "+c);
    }

    public static void main(String[] args) {

        Base62IdGenerator base62IdGenerator = new Base62IdGenerator();

        String id = Base62IdGenerator.generateId();

        System.out.println("[INFO] GeneratedId: "+id);
        System.out.println("[INFO] BASE10 conversion: "+base62ToDecimal(id));
    }

}
