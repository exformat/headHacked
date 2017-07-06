
class Crypt {

    private Logic logic = new Logic();
    private EndCrypt endCrypt = new EndCrypt();
    private Name getMessage = new Name();
    private Key getKey = new Key();


    private String end_first_crypt;
    private String double_crypt = "";
    private String mix_crypt = "";

    public void crypt(){
         this.logic.randomName();

        int key = getKey.getKey();
        String message = getMessage.getName();

         System.out.println("оригинальное сообщение: " + message);
         System.out.println("ключ: " + key);

         first_crypt();
         double_crypt();
         mix_crypt();
         this.endCrypt.setCrypt(this.mix_crypt);
    }
    private void first_crypt(){

         String key_string = Integer.toString(getKey.getKey());
        System.out.println(key_string);

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
                 for (int elem = 0; elem < getMessage.getName().length(); elem++){
                     char element = getMessage.getName().charAt(elem);

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
                 this.end_first_crypt = end_crypt;
                 end_crypt = "";
             }
             System.out.println("зашифрованное сообщение: " + this.end_first_crypt);
         }
         else {

             String end_crypt  = "";

             for (int iteration = 0; iteration < key_array[0]; iteration++){

                 //вложенный цикл. поэлементная обработка
                 for (int elem = 0; elem < getMessage.getName().length(); elem++){
                     char element = getMessage.getName().charAt(elem);

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
                 this.end_first_crypt = end_crypt;
                 end_crypt = "";
             }
             System.out.println("зашифрованное сообщение: " + this.end_first_crypt);
         }
     }
    private void double_crypt(){//удвоение строки случайными символами

        for (int i = 0; i < this.end_first_crypt.length(); i++){
            char element = this.end_first_crypt.charAt(i);
            char random_char = (char) Math.round(Math.random() * 1000);
            this.double_crypt = this.double_crypt + element + random_char;
        }
        System.out.println("Удвоение строки случайными символами: " + double_crypt);
    }
    private void mix_crypt(){ //Перемешка символов


         int index = double_crypt.length() / 2;
         for (int i = 0; i < double_crypt.length(); i++){
             char element_1 = double_crypt.charAt(i);
             char element_2 = double_crypt.charAt(index);
             this.mix_crypt = this.mix_crypt + element_2 + element_1;
             index++;
             if (index == double_crypt.length()){
                 break;
             }
         }
         System.out.println("после перемешки: " + this.mix_crypt);
     }
}
