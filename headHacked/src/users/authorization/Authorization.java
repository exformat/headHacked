package users.authorization;

import crypt.Name;
import users.UserListReader;
import users.registration.Registration;
import users.registration.SetRegistration;

import java.io.*;

/**
 * Created by Exformat on 11.08.17.
 */
public class Authorization {

    private UserListReader userList = new UserListReader();
    private SetRegistration registration = new SetRegistration();
    private Name name = new Name();

    private String nickname;
    private String password;

    public void authorization() throws IOException{

        this.userList.userListReader();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {


            System.out.println("input nickname: ");
            this.nickname = reader.readLine();

            for (int i = 0; i < this.userList.getUsers().size() - 1; i++){
                if (this.nickname.equals(
                        this.userList.
                                getUsers().
                                get(i).
                                getNickname())){

                    System.out.println("input password: ");

                    this.password = reader.readLine();
                    if (this.password.equals(
                            this.userList.
                                    getUsers().
                                    get(i).
                                    getPassword())){

                        System.out.println("confirmed!");
                        name.setName(this.nickname);
                        break;
                    }
                    else {
                        System.out.println("not correct password!");
                        this.authorization();
                    }

                }
                else {
                    System.out.println("user not found!" +
                            "\n" +
                            "input 1: Tray again" +
                            "\n" +
                            "input 2: Registration");

                    int integerReadLine = Integer.parseInt(reader.readLine());

                    if (integerReadLine == 1){
                        this.authorization();
                        break;}
                    else if (integerReadLine == 2){
                            this.registration.getRegistration().registration();
                            break;}
                         else {
                            System.out.println("WTF? Please input 1 or 2");
                            this.authorization();
                            break;}

                }
            }



        }catch (IOException e){
            System.out.println("error BufferedReader!!!");
            e.printStackTrace();
        }
    }
}
