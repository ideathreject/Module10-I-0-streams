import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Person {
    private String name;
    private int age;

    public Person (){

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
    public void readPersonFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\obuc\\Module10\\src\\main\\resources\\fileName.txt"))) {
            String line;
            line = reader.readLine();
            File file = new File("D:\\obuc\\Module10\\src\\main\\resources\\user.json");
            int count = 0;
            while ((line = reader.readLine()) != null) {
                try (FileWriter writer = new FileWriter(file, true))
                {
                    String[] temp = line.split(" ");
                    Person person = new Person(temp[0], Integer.parseInt(temp[1]));
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String json = gson.toJson(person);

                    if (count == 0){
                        json = "["+json+",";
                    }
                    count++;

                    if (count == 2){
                        json = json+"]";
                    }

                    writer.write(json);
                    writer.flush();


                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }


            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

