package crypt;

import DeCrypt.DeCrypt;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Exformat on 31.07.17.
 */
public class Test {

    private Message message = new Message();
    private Crypt crypt = new Crypt();
    private DeCrypt deCrypt = new DeCrypt();

    public void test() throws IOException {

        String a = "a";

        for (int i = 0; i < 10; i++){
            System.out.println("loop №: " + (i + 1) + "============================");
            message.setMessage(a);
            crypt.crypt();
            deCrypt.deCrypt();
            a += "a";
            System.out.println("loop №: " + (i + 1) + "============================");
        }
    }

    public  void test_2()throws IOException{

        Date date = new Date();

        String a = "a";
        for (int i = 0; i < 10; i++){
            a += "a";
        }
        long d = date.getTime();
        System.out.println(d);
		
        message.setMessage(a);
        crypt.crypt();
        deCrypt.deCrypt();
		
        Date date1 = new Date();
        long d2 = date1.getTime();
        System.out.println(d2);
		
        long dEnd = d2 - d;
        System.out.println(dEnd);
    }
}
