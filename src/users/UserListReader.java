package users;

import res.UserList;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Exformat on 13.08.17.
 */
public class UserListReader {

    private UserList userList = new UserList();
    private int lastUser;

    private ArrayList<User> users = new ArrayList<>();


    public void userListReader()throws IIOException {

        int mark = 0;
        String tmp;
        StringBuilder id       = new StringBuilder();
        StringBuilder nickname = new StringBuilder();
        StringBuilder password = new StringBuilder();



        String linc = "/home/exformat/IdeaProjects/headHacked/src/res/userList";
        try(BufferedReader reader = new BufferedReader(new FileReader(linc))) {

            while ((tmp = reader.readLine()) != null){

                //read id
                for (int i = 0; i < tmp.length(); i++){
                    if ('!' == tmp.charAt(i)){
                        mark = ++i;
                        break;
                    }
                    id.append(tmp.charAt(i));
                }

                //read nickname
                for (;mark < tmp.length();mark++){
                    if ('!' == tmp.charAt(mark)){
                        mark++;
                        break;
                    }
                    nickname.append(tmp.charAt(mark));
                }

                //read password
                for (;mark < tmp.length();mark++){
                    password.append(tmp.charAt(mark));
                }

                //add user in List
                this.users.add(new User(
                        Integer.parseInt(id.toString()),
                        nickname.toString(),
                        password.toString()));

                this.lastUser = Integer.parseInt(id.toString());
                this.userList.setUserList(users);

                id.delete(0,id.length());
                nickname.delete(0,nickname.length());
                password.delete(0,password.length());

            }
        }catch (IOException e) {
            System.out.println("read error");
            e.printStackTrace();
        }
    }

    public int getLastUser() {
        return lastUser;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }
}
