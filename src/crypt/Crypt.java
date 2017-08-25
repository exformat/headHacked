package crypt;

public class Crypt {

    public String crypt(String key, String message){

        String tmp;

        tmp = crypt_1(key, message);

        tmp = crypt_2(key, tmp);

        tmp = doubleCrypt(tmp);

        tmp = mixCrypt(tmp);



        return tmp;
    }


    private String crypt_1(String key, String message){


        //write key in array
        int[] key_array = new int[key.length()];
        for (int i = 0; i < key.length() ;i++){
            int count = Character.getNumericValue(key.charAt(i));
            key_array[i] = count;
        }

		int count = 0;

		StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < message.length(); i++){

            char element = message.charAt(i);
            element = (char) (element + key_array[count]);
            tmp.append(element);
			count++;

			if(count == key.length() - 1){
				count = 0;
        	}
			if(i != message.length() - 1){
				element = message.charAt(i + 1);
                element = (char) (element - key_array[count + 1]);
                tmp.append(element);
				i++;
				if(count == key.length()){
					count = 0;
				}
			}
		}
		return tmp.toString();
    }

    private String crypt_2(String key, String message){


         //write key in array
         int[] key_array = new int[key.length()];
         for (int i = 0; i < key.length() ;i++){
             int count = Character.getNumericValue(key.charAt(i));
             key_array[i] = count;
         }

         //logic
         boolean rotate = key_array[1] % 2 != 0;


         //оcновной цикл с колличеством итераций
         if (rotate){

             StringBuilder end_crypt  = new StringBuilder();

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
                     end_crypt.append(element);
                 }
                 message = end_crypt.toString();
                 end_crypt = new StringBuilder();
             }
         }
         else {

             StringBuilder end_crypt  = new StringBuilder();

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
                     end_crypt.append(element);
                 }
                 message = end_crypt.toString();
                 end_crypt = new StringBuilder();
             }
         }
         return message;
     }

    private String doubleCrypt(String message){
        //удвоение строки случайными символами


        StringBuilder tmp = new StringBuilder();
        StringBuilder element = new StringBuilder();

        for (int i = 0; i < message.length(); i++){
            element.append(message.charAt(i));
            char random_char = (char) Math.round(Math.random() * 256);
            tmp.append(element.append(random_char));
            element = new StringBuilder();
        }
        return tmp.toString();
    }

    private String mixCrypt(String message){ //Перемешка символов

        StringBuilder mixCrypt = new StringBuilder();
        StringBuilder element_1 = new StringBuilder();
        StringBuilder element_2 = new StringBuilder();

        int index = message.length() / 2;

        for (int i = 0; i < message.length(); i++){

            element_1.append(message.charAt(index));
            element_2.append(message.charAt(i));

            mixCrypt.append(element_1.append(element_2));

            index++;

            element_1 = new StringBuilder();
            element_2 = new StringBuilder();

            if (index == message.length()){
                break;
            }
        }
        return mixCrypt.toString();
     }
}
