
class Logic {

    private DataBase names = new DataBase();
    private Key setKey = new Key();
    private Name setName = new Name();

    void randomName(){
        System.out.println("run");

        int key = (int) Math.round(Math.random() * 10_000_000);
        int random = (int) Math.round(Math.random() * (this.names.namesBase().size() - 1));
        String randomName = (String) this.names.namesBase().get(random);
        System.out.println(randomName);
        System.out.println(key);
        this.setName.setName(randomName);
        this.setKey.setKey(key);
     }
}
