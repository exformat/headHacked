package crypt;

class Logic {

    private DataBase names = new DataBase();
    private Key setKey = new Key();
    private Name setName = new Name();

    void randomName(){

        /*int random = (int) Math.round(Math.random() * (this.names.namesBase().size() - 1));
        String randomName = (String) this.names.namesBase().get(random);*/
        this.setName.setName("Сергей");
        this.setKey.setKey(randomKey());
    }

    private int randomKey(){

        int key = 0;

        for (int i = 0; i < 1; i++){
            int randomKey = (int) Math.round(Math.random() * 100_000_000);
            if (randomKey < 10_000_000){
                i--;
            }
            else key = randomKey;
        }
        return key;
    }
}
