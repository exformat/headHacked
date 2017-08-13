package crypt;

class RandomKey {

    private Key setKey = new Key();

    void randomKey(){


        for (int i = 0; i < 1; i++){
            int randomKey = (int) Math.round(Math.random() * 100_000_000);
            if (randomKey < 10_000_000){
                i--;
            }
            else setKey.setKey(randomKey);
        }
    }
}
