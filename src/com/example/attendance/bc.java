
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TusharKinG
 */
public class Bc {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
        
           try{
        FileInputStream fin = new FileInputStream(br.readLine());
                    System.out.println(" file found");

        }
        catch(Exception e)
        {
            e.getMessage().toString();
            System.out.println(" file not found");
        }
    }
    
}
