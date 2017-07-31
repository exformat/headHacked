package crypt;

import java.util.ArrayList;
import java.util.List;
class DataBase {


    List namesBase(){
        List<String> names = new ArrayList<>();
            names.add(0,"Кристина");
            names.add(1, "Сергей");
            names.add(2, "Артём");
            names.add(3, "Никита");
        return names;
    }

}