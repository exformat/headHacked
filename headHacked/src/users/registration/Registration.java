package users.registration;

import res.UserList;
import users.UserListReader;
import users.authorization.Authorization;
import users.authorization.SetAuthorization;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Exformat on 11.08.17.
 */
public class Registration {

    private int id;
    private String nickname;
    private String password;

    private SetAuthorization authorization = new SetAuthorization();
    private UserListReader userListReader = new UserListReader();
    private UserList userList = new UserList();

    public void registration()throws IOException{

        this.userListReader.userListReader();
        this.id = this.userListReader.getLastUser();

        String linc = "/home/exformat/IdeaProjects/headHacked/src/res/userList";


        try(FileWriter writer = new FileWriter(linc,true)) {

            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

                    System.out.println("enter new nickname: ");
                    this.nickname = reader.readLine();

                    if (this.nickname == null){
                        System.out.println("please input new nickname");
                        this.registration();
                    }
                    if (this.nickname.length() <= 4){
                        System.out.println("min 5 character");
                        this.registration();
                    }

                    for (int i = 0; i < userList.getUserList().size(); i++){

                        if (this.nickname.equals(this.userList.getUserList().get(i).getNickname())){

                            System.out.println("Busy nickname!");
                            this.registration();
                        }
                    }

                    System.out.println("enter password: ");
                    password = reader.readLine();

                    if (this.password == null){

                        System.out.println("Please!!! input correct password.");
                        this.registration();
                    }

                    this.id++;
                    writer.write(this.id+ "!" + this.nickname + "!" + this.password + "\n");
                System.out.println("registration complete!\nPlease enter in system!");
                this.authorization.getSetAuthorization().authorization();
            }
            catch (IOException e){
                System.out.println("read line error");
                e.printStackTrace();
            }

        }
        catch (IOException e){
            System.out.println("write error");
            e.printStackTrace();
        }

    }
}
