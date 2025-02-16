import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String filePathNumber = ("src\\main\\resources\\fileNumber.txt");
        ValidNumber validNumber = new ValidNumber();
        validNumber.readFile(filePathNumber);
        String filePathPerson = ("src\\main\\resources\\fileName.txt");
        Person person = new Person();
        person.readPersonFile(filePathPerson);
        String filePathWords = ("src\\main\\resources\\words.txt");
        UniqueWords uniqueWords = new UniqueWords();
        uniqueWords.uniqueWordsCounter(filePathWords);
    }
}
