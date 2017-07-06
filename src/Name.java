
class Name {

    private static String  name;
    int i;

    public String getName(){
         i++;
        System.out.println("run get name " + i);
        return this.name;
    }

    public void setName( String name){

        System.out.println("run set name");
        this.name = name;
    }
}
