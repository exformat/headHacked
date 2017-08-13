package crypt;

import java.io.IOException;

public class Crypt {


    private RandomKey setRandomKey = new RandomKey();
    private Name name = new Name();
    private Key key = new Key();
    private Message message = new Message();
    private EndCrypt endCrypt = new EndCrypt();
    private InputMessage inMessage = new InputMessage();
    private WriteToFile writeToFile = new WriteToFile();

    private String endFirstCrypt;
    private String doubleCrypt = "";

    public void crypt() throws IOException {
        try {
            this.inMessage.inputMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setRandomKey.randomKey();
        int key = this.key.getKey();
        String name = this.name.getName();


        System.out.println( name + " пишет: " + "(" + key + ")" + this.message.getMessage());

        generalCrypt();
        firstCrypt();
        doubleCrypt();
        mixCrypt();
        this.writeToFile.write();
    }
    private void generalCrypt(){

        int key = this.key.getKey();
        String message = this.name.getName() +" Пишет: " + this.message.getMessage();

        String key_string = Integer.toString(key);

        //write key in array
        int[] key_array = new int[key_string.length()];
        for (int i = 0; i < key_string.length() ;i++){
            int count = Character.getNumericValue(key_string.charAt(i));
            key_array[i] = count;
        }

		int count = 0;
		String tmp = "";
        for (int i = 0; i < message.length(); i++){
			char element = message.charAt(i);
            element = (char) (element + key_array[count]);
            tmp = tmp + element;
			count++;
			if(count == key_string.length() - 1){
				count = 0;
        	}
			if(i != message.length() - 1){
				element = message.charAt(i + 1);
                element = (char) (element - key_array[count + 1]);
                tmp = tmp + element;
				i++;
				if(count == key_string.length()){
					count = 0;
				}
			}
		}
		this.endFirstCrypt = tmp;
		System.out.println("general crypt " + tmp);
    }
    private void firstCrypt(){

        int key = this.key.getKey();
        String message = this.endFirstCrypt;

        String key_string = Integer.toString(key);

         //write key in array
         int[] key_array = new int[8];
         for (int i = 0; i < key_string.length() ;i++){
             int count = Character.getNumericValue(key_string.charAt(i));
             key_array[i] = count;
         }

         //logic
         boolean rotate = key_array[1] % 2 != 0;


         //оcновной цикл с колличеством итераций
         if (rotate){

             String end_crypt  = "";

             for (int iteration = 0; iteration < key_array[0]; iteration++){

                 //вложенный цикл. поэлементная обработка
                 for (int elem = 0; elem < message.length(); elem++){
                     char element = message.charAt(elem);

                     //вложенный цикл. Обработка элемента по колличеству знаков в ключе
                     for (int count = 0; count < key_array.length; count++){
                         element = (char) (element -  key_array[count]);
                         count++;
                     }
                     for (int count = 1; count < key_array.length; count++){
                         element = (char) (element +  key_array[count]);
                         count++;
                     }
                     end_crypt = end_crypt + element;
                 }
                 this.endFirstCrypt = end_crypt;
                 end_crypt = "";
             }
             System.out.println("First crypt: " + this.endFirstCrypt);
         }
         else {

             String end_crypt  = "";

             for (int iteration = 0; iteration < key_array[0]; iteration++){

                 //вложенный цикл. поэлементная обработка
                 for (int elem = 0; elem < message.length(); elem++){
                     char element = message.charAt(elem);

                     //вложенный цикл. Обработка элемента по колличеству знаков в ключе
                     for (int count = 0; count < key_array.length; count++){
                         element = (char) (element +  key_array[count]);
                         count++;
                     }
                     for (int count = 1; count < key_array.length; count++){
                         element = (char) (element -  key_array[count]);
                         count++;
                     }
                     end_crypt = end_crypt + element;
                 }
                 this.endFirstCrypt = end_crypt;
                 end_crypt = "";
             }
             System.out.println("First crypt: " + this.endFirstCrypt);
         }
     }
    private void doubleCrypt(){//удвоение строки случайными символами

        String message = this.endFirstCrypt;
        this.endFirstCrypt = "";
        for (int i = 0; i < message.length(); i++){
            char element = message.charAt(i);
            char random_char = (char) Math.round(Math.random() * 256);
            this.doubleCrypt = this.doubleCrypt + element + random_char;
        }
        System.out.println("Удвоение строки случайными символами: " + doubleCrypt);
    }
    private void mixCrypt(){ //Перемешка символов

        String mix_crypt = "";
         int index = doubleCrypt.length() / 2;
         for (int i = 0; i < doubleCrypt.length(); i++){
             char element_1 = doubleCrypt.charAt(index);
             char element_2 = doubleCrypt.charAt(i);
             mix_crypt = mix_crypt + element_1 + element_2;
             index++;
             if (index == doubleCrypt.length()){
                 break;
             }
         }
        this.doubleCrypt = "";
        this.endCrypt.setCrypt(mix_crypt);
        System.out.println("после перемешки: " + mix_crypt);
     }
}
