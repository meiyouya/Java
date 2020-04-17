package com.zql;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HashMap<Double, Integer> map = new HashMap<>();
        int salary = 5000;
        double bili = 0.05;
        while (salary<40000){
            while (bili < 1.0) {
                if (map.containsKey(salary*bili)) {
                    Integer count = map.get(salary * bili);
                    map.put(salary*bili,count+1);
                } else {
                    map.put(salary*bili,1);
                }
                bili += 0.05;
            }
            salary += 1000;
            bili = 0.05;
        }
        for (Double aDouble : map.keySet()) {
            System.out.println(aDouble + "::" + map.get(aDouble));
        }
    }
}
