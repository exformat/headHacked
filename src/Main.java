import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;

/**
 * Created by exformat on 11.06.17.
 */
public class Main {



    public static void main(String[] args) {

        Crypt class_crypt = new Crypt();
        EndCrypt getCrypt = new EndCrypt();
        Name name = new Name();
        Key key = new Key();


        class_crypt.crypt();

        String crypt = getCrypt.getCrypt();

        try(FileWriter writer = new FileWriter(
                "/home/exformat/IdeaProjects/headHacked/src/crypt.txt", false)) {
            writer.write("построчная запись: " + key.getKey() + " " + name.getName() + " " + crypt + "\n");

           /* writer.write("посимвольная запись: ");



            for (int i = 0; i < crypt.length(); i++){
                char nameChar = crypt.charAt(i);
                writer.append(nameChar);
            }
            writer.append('\n');*/

        }




        catch (IOException ex){


            System.out.println(ex.getMessage());
        }
    }
}
