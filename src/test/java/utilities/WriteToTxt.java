package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {

    public static void writeToMethot(String  T, String filepath){
        try{
            FileWriter fileWriter = new FileWriter(filepath,false);

            BufferedWriter writer = new BufferedWriter(fileWriter);


                writer.append(T);



            writer.close();

        }catch(Exception e){
            e.printStackTrace();

        }



    }
}