package users.registration;

import res.UserList;
import users.PasswordCrypt;
import users.UserListReader;
import users.authorization.Authorization;
import java.io.*;
import java.util.logging.Logger;

/**
 * Created by Exformat on 11.08.17.
 */
public class Registration {

    private static Logger LOG = Logger.getLogger(Registration.class.getName());

    private UserList userList = new UserList();
    private UserListReader userListReader = new UserListReader();
    private Authorization authorization = new Authorization();
    private PasswordCrypt passwordCrypt = new PasswordCrypt();

    private int id;
    private String nickname;
    private String password;



    public void registration()throws IOException{

        this.userListReader.userListReader();
        this.id = this.userListReader.getLastUser();

        String linc = "/home/exformat/IdeaProjects/headHacked/src/res/";

            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("enter new nickname: ");
                this.nickname = reader.readLine();

                if (this.nickname == null) {
                    System.out.println("please input new nickname");
                    this.registration();
                }
                if (this.nickname.length() <= 4) {
                    System.out.println("min 5 character");
                    this.registration();
                }

                for (int i = 0; i < userList.getUserList().size(); i++) {

                    if (this.nickname.equals(this.userList.getUserList().get(i).getNickname())) {

                        System.out.println("Busy nickname!");
                        this.registration();
                    }
                }

                System.out.println("enter new password: \n(min 8 character!)");
                password = reader.readLine();

                if (this.password == null || this.password.length() < 8) {

                    System.out.println("Please!!! input correct password.");
                    this.registration();
                }

                this.id++;

                // create new Folder.
                File newFolder = new File(linc + "UserHistory/" + this.nickname);
                if (!newFolder.mkdir()){
                    LOG.info("cannot create directories" + newFolder);
                }


                //password crypt
                this.password = this.passwordCrypt.passCrypt(this.nickname, this.password);

                //write to database.
                try (FileWriter writer = new FileWriter(linc + "userList", true)) {
                    writer.write(this.id + "!" +
                                    this.nickname + "!" +
                                    this.password + "\n");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("write error");
                    e.printStackTrace();
                }


                System.out.println("registration complete!\nPlease enter in system!");
                this.authorization.authorization();
            }
            catch (IOException e){
                System.out.println("read line error");
                e.printStackTrace();
            }
    }
}
