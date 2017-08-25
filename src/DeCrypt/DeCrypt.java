package DeCrypt;

/**
 * Created by Exformat on 20.017.
 */
public class DeCrypt {

    public String deCrypt(String key, String message){

        String tmp;

        tmp = deMix(message);

        tmp = deDouble(tmp);

        tmp = deCrypt_1(key, tmp);

        tmp = deCrypt_2(key, tmp);

        return tmp;
    }
    private String deMix(String message){

        StringBuilder dMix = new StringBuilder();
        StringBuilder dMix2 = new StringBuilder();

        for (int i = 0; i < message.length(); i++){
            dMix.append(message.charAt(i));
            i++;
            dMix2.append(message.charAt(i));
        }

        message = dMix2.append(dMix).toString();
        return message;
    }

    private String deDouble(String message){

        char element;
        StringBuilder tmp = new StringBuilder();

        for(int i = 0; i < message.length(); i++){
            element = message.charAt(i);
            tmp.append(element);
            i++;
        }
        return tmp.toString();
    }

    private String deCrypt_1(String key, String message){

        int[] keyArray = new int[key.length()];
            for (int i = 0; i < key.length() ;i++){
                int count = Character.getNumericValue(key.charAt(i));
                keyArray[i] = count;
            }

            boolean rotate = keyArray[1] % 2 != 0;

            if(rotate){
                StringBuilder endCrypt  = new StringBuilder();

                for (int iteration = 0; iteration < keyArray[0]; iteration++){

//вложенный цикл. поэлементная обработка
                    for (int elem = 0; elem < message.length(); elem++){

                        char element = message.charAt(elem);

//вложенный цикл. Обработка элемента по колличеству знаков в ключе
                        for (int count = 0; count < keyArray.length; count++){
                            element = (char) (element +  keyArray[count]);
                            count++;
                        }
                        for (int count = 1; count < keyArray.length; count++){
                            element = (char) (element -  keyArray[count]);
                            count++;
                        }
                        endCrypt.append(element);
                    }
                    message = endCrypt.toString();
                    endCrypt = new StringBuilder();
                }
            }
            else {

                StringBuilder endCrypt  = new StringBuilder();

                for (int iteration = 0; iteration < keyArray[0]; iteration++){

//вложенный цикл. поэлементная обработка
                    for (int elem = 0; elem < message.length(); elem++){

                        char element = message.charAt(elem);

//вложенный цикл. Обработка элемента по колличеству знаков в ключе
                        for (int count = 0; count < keyArray.length; count++){
                            element = (char) (element - keyArray[count]);
                            count++;
                        }
                        for (int count = 1; count < keyArray.length; count++){
                            element = (char) (element +  keyArray[count]);
                            count++;
                        }
                        endCrypt.append(element);
                    }
                    message = endCrypt.toString();
                    endCrypt = new StringBuilder();
                }
            }
            return message;
        }

    private String deCrypt_2(String key, String message){

            int[] keyArray = new int[key.length()];

            for (int i = 0; i < key.length() ;i++){
                int count = Character.getNumericValue(key.charAt(i));
                keyArray[i] = count;
            }

            int count = 0;
            StringBuilder tmp = new StringBuilder();

            for (int i = 0; i < message.length(); i++){

                char element = message.charAt(i);
                element -= keyArray[count];
                tmp.append(element);
                count++;

                if(count == 7){
                    count = 0;
                }

                if (i != message.length() - 1) {

                    element = message.charAt(i + 1);
                    element += keyArray[count + 1]; //TODO fuuuUUUUck
                    tmp.append(element);
                    i++;
                }
            }
        return tmp.toString();
        }
    }


