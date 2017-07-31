package crypt;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Exformat on 20.07.17.
 */
class WriteToFile {

    private EndCrypt endcrypt = new EndCrypt();
    private Name name = new Name();
    private Key key = new Key();

    void write() {

        String crypt = this.endcrypt.getCrypt();
        this.endcrypt.setCrypt("");

        String adress = "/home/exformat/IdeaProjects/headHacked/src/res/";
        String txt = ".txt";

        try (FileWriter writer = new FileWriter(
                adress + this.name.getName() + txt, false)) {

            writer.write(this.key.getKey() + crypt);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
