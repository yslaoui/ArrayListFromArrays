package arrays;

public class Main {
    public static void main(String[] args) {
//        List<String> myList = new List<>();
//        System.out.println(myList.contains("A"));
//        myList.add("A");
//        System.out.println(myList.contains("A"));
//        myList.add("B");
//        myList.add("CD");
//        System.out.println(myList);
//        System.out.println(myList.size());
//        myList.remove("A");
//        System.out.println(myList);
//        System.out.println(myList.size());
//        System.out.println("getting value at index");
//        System.out.println(myList.value(1));

//        Pair<String, String> pair = new Pair("Alain", "Minc");
//        System.out.println(pair.getKey());
//        System.out.println(pair.getValue());

        MyHashMap<String, String> myMap = new MyHashMap<>();
        myMap.add("Alain", "Minc");
        myMap.add("Jordan", "Bardella");
        myMap.add("Alain", "Dubois");
        myMap.add("Marine", "lepen");
        System.out.println(myMap.get("Marine"));
        myMap.remove("Marine");
        System.out.println(myMap.get("Marine"));


    }
}
