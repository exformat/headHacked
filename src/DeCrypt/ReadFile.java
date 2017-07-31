package DeCrypt;

import java.io.*;

/**
 * Created by Exformat on 28.07.17.
 */
public class ReadFile {

    private CryptMessage cryptMessage = new CryptMessage();
    private Key key = new Key();

    public void read(){

        String adress = "/home/exformat/IdeaProjects/headHacked/src/res/";
        String txt = ".txt";
        String cryptMessage = "";
        String key = "";
        int element;

        try(FileReader fileReader = new FileReader(adress + "Сергей" + txt)) {


            for (int i = 0; i < 8; i++){
                key += (char) fileReader.read();
            }
            System.out.println("key " + key);
            this.key.setKey(key);


            while ((element = fileReader.read()) != -1){
                cryptMessage += (char)element;
            }
            System.out.println("message " + cryptMessage);
            this.cryptMessage.setCryptMessage(cryptMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
