package users.authorization;

import users.PasswordDeCrypt;
import users.UserListReader;
import users.registration.Registration;

import java.io.*;

/**
 * Created by Exformat on 11.08.17.
 */
public class Authorization {

    private UserListReader userList = new UserListReader();
    private PasswordDeCrypt passwordDeCrypt = new PasswordDeCrypt();

    private String nickname;
    private String password;

    public void authorization() throws IOException{

        this.userList.userListReader();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {


            System.out.println("input nickname: ");
            this.nickname = reader.readLine();

            for (int i = 0; i < this.userList.getLastUser(); i++){

                if (this.nickname.equals(
                        this.userList.
                                getUsers().
                                get(i).
                                getNickname())){

                    System.out.println("input password: ");

                    this.password = reader.readLine();

                    if (this.password.equals(
                            this.passwordDeCrypt.passDeCrypt(
                                    this.nickname, this.userList.getUsers().get(i).getPassword()))){


                        //=======================

                        System.out.println("confirmed!");

                        //=======================

                        break;
                    }
                    else {
                        System.out.println("not correct password!");
                        this.authorization();
                        break;
                    }

                }
                else {
                    if (i == this.userList.getLastUser() - 1) {
                        System.out.println("user not found!" +
                                "\n" +
                                "input 1: Tray again" +
                                "\n" +
                                "input 2: Registration");

                        String stringReadLine = reader.readLine();
                        int integerReadLine = Integer.parseInt(stringReadLine);

                        if (integerReadLine == 1) {
                            this.authorization();
                            break;
                        } else if (integerReadLine == 2) {
                            new Registration().registration();
                            break;
                        } else {
                            System.out.println("WTF? Please input 1 or 2");
                            this.authorization();
                            break;
                        }
                    }
                }
            }



        }catch (IOException e){
            System.out.println("error BufferedReader!!!");
            e.printStackTrace();
        }
    }
}
