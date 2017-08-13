package crypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputMessage {

    private Message message = new Message();

    //ввод сообщения
    void inputMessage() throws IOException {
        System.out.println("Введите кодируемое сообщение");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.message.setMessage(reader.readLine());
    }
}
