package DeCrypt;

/**
 * Created by Exformat on 20.017.
 */
public class DeCrypt {

    private ReadFile readFile = new ReadFile();
    private Key getKey = new Key();
    private CryptMessage cryptMessage = new CryptMessage();

    private String deMixMessage = "";
    private String deDoubleMessage = "";
    private String deCryptMessage = "";

        public void deCrypt(){
            this.readFile.read();
            deMix();
            deDouble();
            deCrypt_1();
            deCrypt_2();
        }
    private void deMix(){

            String message = cryptMessage.getCryptMessage();

            String dMix = "";
            String dMix2 = "";

            for (int i = 0; i < message.length(); i++){
                dMix += message.charAt(i);
                i++;
                dMix2 += message.charAt(i);
            }
            this.deMixMessage = dMix2 + dMix;

        System.out.println("demix message " + this.deMixMessage);
    }

    private void deDouble(){

            String message = cryptMessage.getCryptMessage();
            char element;
            String tmp = "";

            for(int i = 0; i < message.length(); i++){
                element = this.deMixMessage.charAt(i);
                tmp += element;
                i++;
            }

            this.deDoubleMessage = tmp;
        System.out.println("dedouble message " + this.deDoubleMessage);
        }

    private void deCrypt_1(){

        String key = getKey.getKey();

        int[] keyArray = new int[8];
            for (int i = 0; i < key.length() ;i++){
                int count = Character.getNumericValue(key.charAt(i));
                keyArray[i] = count;
            }

            boolean rotate = keyArray[1] % 2 != 0;

            if(rotate){
                String endCrypt  = "";

                for (int iteration = 0; iteration < keyArray[0]; iteration++){

//вложенный цикл. поэлементная обработка
                    for (int elem = 0; elem < this.deDoubleMessage.length(); elem++){

                        char element = this.deDoubleMessage.charAt(elem);

//вложенный цикл. Обработка элемента по колличеству знаков в ключе
                        for (int count = 0; count < keyArray.length; count++){
                            element = (char) (element +  keyArray[count]);
                            count++;
                        }
                        for (int count = 1; count < keyArray.length; count++){
                            element = (char) (element -  keyArray[count]);
                            count++;
                        }
                        endCrypt += element;
                    }
                    this.deCryptMessage = endCrypt;
                    endCrypt = "";
                }
            }
            else {

                String endCrypt  = "";

                for (int iteration = 0; iteration < keyArray[0]; iteration++){

//вложенный цикл. поэлементная обработка
                    for (int elem = 0; elem < this.deDoubleMessage.length(); elem++){

                        char element = this.deDoubleMessage.charAt(elem);

//вложенный цикл. Обработка элемента по колличеству знаков в ключе
                        for (int count = 0; count < keyArray.length; count++){
                            element = (char) (element - keyArray[count]);
                            count++;
                        }
                        for (int count = 1; count < keyArray.length; count++){
                            element = (char) (element +  keyArray[count]);
                            count++;
                        }
                        endCrypt += element;
                    }
                    this.deCryptMessage = endCrypt;
                    endCrypt = "";
                }
                System.out.println( "decrypt message " + this.deCryptMessage);
            }
        }

    private void deCrypt_2(){


            String key = getKey.getKey();

            int[] keyArray = new int[8];

            for (int i = 0; i < key.length() ;i++){
                int count = Character.getNumericValue(key.charAt(i));
                keyArray[i] = count;
            }

            int count = 0;
            String tmp = "";

            for (int i = 0; i < this.deCryptMessage.length(); i++){

                char element = this.deCryptMessage.charAt(i);
                element -= keyArray[count];
                tmp += element;
                count++;

                if(count == 7){
                    count = 0;
                }

                if (i != this.deCryptMessage.length() - 1) {

                    element = this.deCryptMessage.charAt(i + 1);
                    element += keyArray[count + 1]; //TODO fuuuUUUUck
                    tmp += element;
                    i++;
                }
            }

        DecryptMessage.setEndCryptMessage(tmp);
        System.out.println("end decrypt " + tmp);
        }
    }


