package crypt;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Exformat on 20.07.17.
 */
class WriteToFile {

    private EndCrypt endcrypt = new EndCrypt();
    private Key key = new Key();

    void write() {

        String crypt = this.endcrypt.getCrypt();
        this.endcrypt.setCrypt("");

        String adress = "/home/exformat/IdeaProjects/headHacked/src/res/history";

        try (FileWriter writer = new FileWriter(
                adress, false)) {

            writer.write(this.key.getKey() + crypt);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
