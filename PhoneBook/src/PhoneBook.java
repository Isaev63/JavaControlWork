import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        // Проверяем, существует ли запись с именем name
        if (phoneBook.containsKey(name)) {
            // Если запись существует, добавляем новый номер телефона
            phoneBook.get(name).add(phoneNum);
        } else {
            // Если записи нет, создаем новую запись
            ArrayList<Integer> phoneList = new ArrayList<>();
            phoneList.add(phoneNum);
            phoneBook.put(name, phoneList);
        }
    }

    public List<Integer> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        // Возвращаем всю телефонную книгу
        return phoneBook;
    }

    public static void main(String[] args) {
        String name1 = "Ivanov";
        String name2 = "Petrov";
        int phone1 = 892777777;
        int phone2 = 892555555;
        int phone3 = 892222222;

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone3);

        List<String> sortedKeys = phoneBook.keySet().stream().sorted((key1, key2) ->
                Integer.compare(phoneBook.get(key2).size(), phoneBook.get(key1).size())).collect(Collectors.toList());

        for (String key : sortedKeys) {
            System.out.println(key + ": " + phoneBook.get(key));
        }

        System.out.println(myPhoneBook.find("Me"));
    }
}