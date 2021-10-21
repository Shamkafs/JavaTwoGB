package HomeWork3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {

    Map<String, List<String>> phoneDirectory = new HashMap<>();
    List<String> phoneNumberList = new LinkedList<>();

    public void add(String surname, String phoneNumber) {
        if (phoneDirectory.containsKey(surname)){
            phoneNumberList = phoneDirectory.get(surname);
        } else {
            phoneNumberList = new LinkedList<>();
        }
        phoneNumberList.add(phoneNumber);
        phoneDirectory.put(surname, phoneNumberList);
    }

    public List<String> get(String surname) {
        return phoneDirectory.get(surname);
    }

    public static void main(String[] args) {

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        telephoneDirectory.add("Mudrov", "89661257896");
        telephoneDirectory.add("Panov", "89163667412");
        telephoneDirectory.add("Mudrov", "89638819923");

        System.out.println(telephoneDirectory.phoneDirectory);
        System.out.println();
        System.out.println(telephoneDirectory.get("Mudrov"));
    }
}
