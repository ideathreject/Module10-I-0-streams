import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        ValidNumber validNumber = new ValidNumber();
        validNumber.readFile();

        Person person = new Person();
        person.readPersonFile();

        UniqueWords uniqueWords = new UniqueWords();
        uniqueWords.uniqueWordsCounter();



    }
}
