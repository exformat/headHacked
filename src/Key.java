class Key {

    private static int key;

    public int getKey(){
        System.out.println("run get key");
        return key;
    }
    public void setKey(int key){
        System.out.println("run set key");
        this.key = key;
    }
}
