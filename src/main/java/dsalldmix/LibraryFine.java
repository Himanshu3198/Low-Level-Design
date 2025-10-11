package dsalldmix;


import java.util.*;

class Transaction{

    private String lender;
    private String borrower;
    private String book;
    private Integer days;

    public Transaction(String lender, String borrower, String book, Integer days){
         this.lender =  lender;
         this.borrower = borrower;
         this.book = book;
         this.days = days;
    }

    public String getLender(){
        return  lender;
    }

    public String getBorrower(){
        return borrower;
    }

    public String getBook(){
        return book;
    }

    public Integer getDays(){
        return days;
    }
}

class FineDTO{

    Integer  fine = 0;
    Set<String> bookTaken;

    public FineDTO(Integer fine,Set<String> bookTaken ){
        this.fine = fine;
        this.bookTaken = bookTaken;
    }
}


class LibraryManager{

    private List<Transaction> transactionList ;

    private  Map<String,Integer> bookRecord = new HashMap<>();
    private Map<String,FineDTO> bfine = new HashMap<>();

    public  LibraryManager(List<Transaction> transactionList){
        this.transactionList = transactionList;
    }

    public void calculateFine(){

        for(var record:transactionList){

                String book = record.getBook();
                String borrower = record.getBorrower();
                Integer days = record.getDays();

                  int calBookFine = bookRecord.getOrDefault(book,0);
                  bookRecord.put(book,calBookFine+days);
                  if(calBookFine+days <= 10) {
                      bookRecord.put(book,calBookFine+days);
                      continue;
                  }
                  int borrowerFine = 0;

                  if(calBookFine <=10){
                       borrowerFine = Math.abs(10-(calBookFine+days));
                  }else{
                      borrowerFine = days;
                  }

                 bfine.putIfAbsent(borrower,new FineDTO(0,new HashSet<>()));
                 FineDTO borrowerRecord =  bfine.get(borrower);
                 int fine = borrowerRecord.fine;
                 Set<String> booksBorrow = borrowerRecord.bookTaken;
                 fine +=borrowerFine;
                 booksBorrow.add(book);
                 bfine.put(borrower,new FineDTO(fine,booksBorrow));
        }


        for(Map.Entry<String,FineDTO> record: bfine.entrySet()){
            FineDTO  values = record.getValue();

            StringBuilder  sb = new StringBuilder();
            List<String> value = values.bookTaken.stream().toList();
            for(int i=0;i<value.size();i++){
                String v = value.get(i);
                sb.append(v);
                if(i!=value.size()-1){
                    sb.append(",");
                }
            }
            System.out.println(record.getKey()+":"+values.fine+":"+sb.toString());
        }

    }
}



public class LibraryFine {

    public static void main(String[] args) {
        List<Transaction> transactionsList = new ArrayList<>();
        transactionsList.add(new Transaction("LIB","Ace","B1",5));
        transactionsList.add(new Transaction("ACE","Bob","B1",7));
        transactionsList.add(new Transaction("Bob","LIB","B1",0));
        transactionsList.add(new Transaction("Bob","TAS","B1",6));
        transactionsList.add(new Transaction("Tob","BIB","B2",8));
        transactionsList.add(new Transaction("Tob","BIB","B2",5));
        transactionsList.add(new Transaction("Tob","BIB","B2",6));
        transactionsList.add(new Transaction("Tob","BIB","B3",26));


        LibraryManager libraryManager = new LibraryManager(transactionsList);

        libraryManager.calculateFine();

    }

}
