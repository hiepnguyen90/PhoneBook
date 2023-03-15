package com.zipcodewilmington.phonebook;

import com.google.inject.internal.util.Lists;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        this.phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(String s: phonebook.keySet())
            if(phonebook.get(s).contains(phoneNumber))
                return s;

        return null;
    }

    public List<String> getAllContactNames() {
        List<String> newList = new ArrayList<>();
        for (String s : phonebook.keySet()){
            newList.add(s);
        }
        return newList;
    }



    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
