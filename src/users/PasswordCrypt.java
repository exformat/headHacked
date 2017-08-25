package users;

import crypt.Crypt;

/**
 * Created by Exformat on 22.08.17.
 */
public class PasswordCrypt {

    private Crypt crypt = new Crypt();

    public String passCrypt(String nickname, String password){

        StringBuilder tmp = new StringBuilder();

        int count;

        for (int i = 0; i < nickname.length()/2; i++){

            count = nickname.charAt(i);
            tmp.append(count);
        }
        password = this.crypt.crypt(tmp.toString(), password);

        password = password.replaceAll("\n","✏");

        return password;
    }





















































}
