/**
 * Created by Exformat on 04.07.17.
 */
class EndCrypt {
    private static String  crypt;

    public String getCrypt(){
        System.out.println("run get crypt");
        return this.crypt;
    }

    public void setCrypt( String crypt){
        System.out.println("run set crypt");
        this.crypt = crypt;
    }
}
