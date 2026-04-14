package org.prog.session7;
import java.util.*;

    public class HomeWorkIvan7 {

        public static void main(String[] args) {

            Map<String, List<String>> phoneBook = new HashMap<>();
            phoneBook.put("+111", new ArrayList<>());
            phoneBook.put("+222", new ArrayList<>());

            phoneBook.get("+111").addAll(addContact("John", "Johny", "Dude", "John"));
            phoneBook.get("+222").addAll(addContact("Kate", "Katty", "Kate", "Sister"));
            System.out.println(phoneBook);

        }

        public static List<String> addContact(String... names ) {
            return Arrays.asList(names);

        }

    }
