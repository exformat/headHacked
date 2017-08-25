import DeCrypt.DeCrypt;
import crypt.Crypt;
import users.authorization.Authorization;
import users.registration.Registration;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {


        Authorization auth = new Authorization();
        Registration reg = new Registration();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("authorization: input 1 ");
        System.out.println("registration: input 2 ");

        int i = Integer.parseInt(reader.readLine());

        if (i == 1){
            auth.authorization();
        }
        if (i == 2){
            reg.registration();
        }
        /*
        int[] count;
        long p;

        String a = "";
        String b = "";

        count = count(100_000);
        for (int i = 99999; i > 10_000; i--){

            if (count[i] == 1){

                for (int z = 99999; z > 10_000; z--){
                    if (count[z] == 1){

                        System.out.println("progress: " + i + " " + z);
                        p = i * z;

                        a += p;
                        b += p;

                        b = new StringBuffer(b).reverse().toString();

                        if (a.equals(b)){
                            System.out.println(i + " * " + z + " = " + p);
                            break;
                        }
                    }
                }
            }
        }*/




       /*long p = 0;
       String a = "";
       String b = "";
       String result;






       }/*

    }

    public static int[] count(int n){

        int S[] = new int[n];
        S[1] = 0; // 1 - не простое число
        // заполняем решето единицами
        for(int k = 2; k<n; k++)
            S[k]=1;

        for(int k=2; k*k<=n; k++){
            // если k - простое (не вычеркнуто)
            if(S[k]==1){
                // то вычеркнем кратные k
                for(int l=k*k; l<n; l+=k){
                    S[l]=0;
                }
            }
        }
        return S;
    }*/

    }
}