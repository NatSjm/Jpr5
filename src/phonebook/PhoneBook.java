package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Record> records;

    public PhoneBook() {
        records = new ArrayList<>();
    }

    public void add(Record record) {
        records.add(record);
    }

    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(name)) {
                foundRecords.add(record);
            }
        }
        if (foundRecords.isEmpty()) {
            return null;
        } else {
            return foundRecords;
        }
    }
}
