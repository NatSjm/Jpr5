package phonebook;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private String name;
    private List<String> phones;

    public Record(String name, String phone) {
        this.name = name;
        phones = new ArrayList<>();
        addPhone(phone);
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void addPhone(String phone) {
        phones.add(phone);
    }
}
