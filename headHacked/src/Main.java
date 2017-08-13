import java.io.*;
import java.util.ArrayList;
import crypt.*;
import DeCrypt.*;
import users.authorization.Authorization;

public class Main {

    public static void main(String[] args) throws IOException {

        Authorization auth = new Authorization();
        Crypt crypt = new Crypt();
        DeCrypt deCrypt = new DeCrypt();
        auth.authorization();
        crypt.crypt();
        deCrypt.deCrypt();

    }
}