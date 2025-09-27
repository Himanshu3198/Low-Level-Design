package urlshortner;

import java.util.Random;

public class Base62IdGenerator {

    private static Random random = new Random();
    private static int ID_LENGTH = 7 ;
    private static final String[] BASE62 = {
            "0","1","2","3","4","5","6","7","8","9",
            "A","B","C","D","E","F","G","H","I","J",
            "K","L","M","N","O","P","Q","R","S","T",
            "U","V","W","X","Y","Z",
            "a","b","c","d","e","f","g","h","i","j",
            "k","l","m","n","o","p","q","r","s","t",
            "u","v","w","x","y","z"
    };

    public Base62IdGenerator() {}

    public static String generateId(){

        StringBuilder sb = new StringBuilder(ID_LENGTH);
        for(int i=0; i< ID_LENGTH; i++){
            int idx =random.nextInt(BASE62.length);
            sb.append(BASE62[idx]);
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(generateId());
//    }

}
