package com.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Temp {
    public static void main(String[] args) {

        Map<String,Integer> map1 = new HashMap<String, Integer>();
        map1.put("java",10);
        map1.put("c",20);
        map1.put("python",15);

        List<Map> maps = new ArrayList<>();
        maps.add(map1);
        List<String> course=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for (Map map:maps){
            //获取map集合的所有键名
            for (Object key : map.keySet()) {
                if(map.get(key) instanceof String){
                    course.add(map.get(key).toString());
                }else{
                    count.add(Integer.parseInt(map.get(key).toString()));
                }
            }
        }

        for (String s :course) {
            System.out.println(s);
        }

        for (Integer integer :count) {
            System.out.println(integer);
        }


    }
}
