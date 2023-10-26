import java.util.*;

import phonebook.PhoneBook;
import phonebook.Record;

public class Main {
    public static void main(String[] args) {
        List<String> randomWords = List.of("Moon", "Zoom zoom zoom", "mock", "do do do");
        String substring = "oo";
        int totalOccurrences = countOccurance(randomWords, substring);
        System.out.println(totalOccurrences);

        Integer[] integerArray = {1, 2, 3};
        List<Integer> integers = toList(integerArray);
        System.out.println(integers);

        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(4);

        List<Integer> uniqueList = findUnique(inputList);
        System.out.println(uniqueList);


        String[] words = {"bird", "fox", "bird", "cat", "bird", "dog", "cat", "bird", "fox", "elephant"};
        calcOccurance(words);


        List<String> wordList = new ArrayList<>();
        wordList.add("bird");
        wordList.add("fox");
        wordList.add("bird");
        wordList.add("cat");
        wordList.add("bird");

        List<Map<String, Object>> result = findOccurrence(wordList);

        for (Map<String, Object> occurrence : result) {
            System.out.println("name: " + occurrence.get("name") + ", occurrence: " + occurrence.get("occurrence"));
        }


        PhoneBook phoneBook = new PhoneBook();

        Record record1 = new Record("John", "123-456-7890");
        Record record2 = new Record("Alice", "987-654-3210");
        Record record3 = new Record("John", "555-555-5555");

        phoneBook.add(record1);
        phoneBook.add(record2);
        phoneBook.add(record3);

        Record foundRecord = phoneBook.find("Alice");
        if (foundRecord != null) {
            System.out.println("Found record: " + foundRecord.getName() + " - " + foundRecord.getPhones());
        } else {
            System.out.println("Record not found.");
        }

        List<Record> foundRecords = phoneBook.findAll("John");
        if (foundRecords != null) {
            System.out.println(foundRecords.size() + " records for John:");
            for (Record record : foundRecords) {
                System.out.println(record.getName() + " - " + record.getPhones());
            }
        } else {
            System.out.println("Records for John not found.");
        }

    }


    //1
    public static int countOccurance(List<String> list, String substring) {
        int totalCount = 0;

        for (String str : list) {
            int countInElement = 0;
            int fromIndex = 0;
            while ((fromIndex = str.indexOf(substring, fromIndex)) != -1) {
                countInElement++;
                fromIndex += substring.length();
            }
            totalCount += countInElement;
        }

        return totalCount;
    }

    //2
    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    //3
    public static List<Integer> findUnique(List<Integer> inputList) {
        Set<Integer> uniqueSet = new HashSet<>();
        List<Integer> uniqueList = new ArrayList<>();

        for (Integer number : inputList) {
            if (uniqueSet.add(number)) {
                uniqueList.add(number);
            }
        }

        return uniqueList;
    }


    //4
    public static void calcOccurance(String[] wordArray) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : wordArray) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static List<Map<String, Object>> findOccurrence(List<String> wordList) {
        List<Map<String, Object>> occurrences = new ArrayList<>();

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : wordList) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            Map<String, Object> occurrence = new HashMap<>();
            occurrence.put("name", entry.getKey());
            occurrence.put("occurrence", entry.getValue());
            occurrences.add(occurrence);
        }

        return occurrences;
    }

}










