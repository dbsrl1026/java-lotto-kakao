package straddcal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {

    private String input;

    public Separator(String s) {
        this.input = s;
    }

    public List<NumberObject> split(){
        List<NumberObject> list = new ArrayList<>();
        for (String s : input.split(regex())) {
            list.add(new NumberObject(s));
        }
        return list;
    }

    String regex(){
        return ":|,";
    }
}
