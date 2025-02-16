import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void readPersonFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            File file = new File("src\\main\\resources\\user.json");
            int count = 0;

            try (FileWriter writer = new FileWriter(file, true)) {
                while ((line = reader.readLine()) != null) {
                        String[] temp = line.split(" ");
                        Person person = new Person(temp[0], Integer.parseInt(temp[1]));
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String json = gson.toJson(person);
                        if (count == 0) {
                            json = "[" + json + ",";
                        }
                        count++;
                        if (count == 2) {
                            json = json + "]";
                        }
                        writer.write(json);
                        writer.flush();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

