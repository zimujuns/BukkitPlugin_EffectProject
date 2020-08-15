package com.ZiMuJun.EffectProject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringToLocation {
    public static Map<String, Object> toLocation(String a){
        String patt1 = "(\\w+=\\w+)},(\\w*=\\W*\\d*\\W*\\d*),(\\w*=\\W*\\d*\\W*\\d*),(\\w*=\\W*\\d*\\W*\\d*),(\\w*=\\W*\\d*\\W*\\d*),(\\w*=\\W*\\d*\\W*\\d*)(})";
        Map<String, Object> map = new HashMap<String, Object>();
        Pattern pattern = Pattern.compile(patt1);
        Matcher matcher = pattern.matcher(a);
        if(matcher.find()){
            for(int i=1;i<matcher.groupCount();i++){
                String b = matcher.group(i);
                String[] arr1 = b.split("=");
                if(arr1[0].equalsIgnoreCase("name")){
                    arr1[0] = "world";
                }
                map.put(arr1[0], arr1[1]);
            }
        }
        return map;
    }
}
