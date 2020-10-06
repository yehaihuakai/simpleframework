package demo.generic;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: liyang07
 * @date: 2020/10/03
 **/
public class GenericDemo {

    public static void main(String[] args) {
        List<String> linkList = new LinkedList<String>();
        linkList.add("words");
//        linkList.add(1);
        for (int i = 0; i < linkList.size(); i++) {
            String item = (String) linkList.get(i);
            System.out.println(item);
        }
    }
}
