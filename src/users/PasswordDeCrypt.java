package users;

import DeCrypt.DeCrypt;

/**
 * Created by Exformat on 23.08.17.
 */
public class PasswordDeCrypt {

    private DeCrypt deCrypt = new DeCrypt();

    public String passDeCrypt(String nickname, String password){

        StringBuilder tmp = new StringBuilder();

        int count;

        for (int i = 0; i < nickname.length()/2; i++){
            count = nickname.charAt(i);
            tmp.append(count);
        }
        //
        password = password.replaceAll("✏","\n");

        password = this.deCrypt.deCrypt(tmp.toString(), password);

        return password;
    }
}
