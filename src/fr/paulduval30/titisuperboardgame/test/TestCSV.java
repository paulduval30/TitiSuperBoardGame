package fr.paulduval30.titisuperboardgame.test;

import java.io.*;
import java.util.HashMap;

public class TestCSV {
    public static void main(String[] argv)
    {
        HashMap<String, String[]> characters = new HashMap<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(new File("res/FICHE-PERSO.csv")));
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
                String[] data = line.split(",");
//                String name = data[0];
//                String life = data[1];
//                String jsaispas = data[2];
//                String armure = data[3];
//                String coupsournois = data[4];
//                String pm = data[5];
//                String po = data[6];
//                String att1 = data[7];
//                String att2 = data[8];
//                String att3 = data[9];
                characters.put(data[0], data);

            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
