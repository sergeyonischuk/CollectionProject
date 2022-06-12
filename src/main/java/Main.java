
public class Main {
    public static void main(String[] args) {
        MyHashMap<String, String> hashMap = new MyHashMap<>();

        hashMap.put("1", "privet");
        hashMap.put("2", "Drakosha");
        hashMap.put("3", "pechenki");
        hashMap.put("4", "GLORY OF THE ROMAN EMPIRE IS IMMORTAL");
        hashMap.put("2", "-_-_-");
        System.out.println(hashMap);
        System.out.println(hashMap.size());

        System.out.println(hashMap.get("0"));

    }
}
