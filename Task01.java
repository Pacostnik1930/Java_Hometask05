import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;


public class Task01 {

    public static void main(String[] args) {
        Map <String, String> book = new HashMap<>();
        book.put("88001122333","Иван Иванов" );
        book.put("88001662333","Иван Курицин" );
        book.put("88001112333","Иван Курицин" );
        book.put("88001122432","Иван Незлобин" );
        book.put("88001112453","Сергей Потапов" );
        book.put("8800163214","Сергей Потапов" );
        book.put("8800142421", "Сергей Курицин");
        book.put("880012343", "Михаил Незлобвин");
        book.put("8800213312343", "Михаил Незлывфобин"); 
        book.put("880011232343", "Михаил Незлобыфвин"); 
        book.put("8800112321312343", "Михаил Незлобыыфвфвин"); 
        System.out.println(repetition(book));  
        
    }
    public static Map<String, Integer> repetition (Map <String, String> book){
        Map <String, String> uniqueNames = new HashMap<>();
        Map <String, Integer> repetit = new TreeMap<>();
        for (Entry<String, String> i : book.entrySet()) {
            uniqueNames.put(i.getValue(), i.getKey());
        }
        List<String> surnameAndName = new ArrayList<>(uniqueNames.keySet());
        for (int i = 0; i < surnameAndName.size(); i++) {
            String name = surnameAndName.get(i).split(" ", 0)[0];
            if (repetit.containsKey(name)) {
                repetit.put(name, repetit.get(name)+1);
            }
            else{
                repetit.put(name, 1);
            }
        }      

        repetit.entrySet().removeIf(entry -> entry.getValue() == 1);
        repetit = sortedNames(repetit, book);
        return repetit;
    }
    public static Map<String, Integer> sortedNames (Map <String, Integer> names, Map <String, String> book){
        Map <String, Integer> sortedNames = new LinkedHashMap<>();
        for (int i = 1; i < book.size(); i++) {
            for (Entry<String, Integer> item : names.entrySet()) {
                if (item.getValue() == i) {
                    sortedNames.put(item.getKey(), item.getValue());
                }
            } 
        }
        return sortedNames;
    }
}

