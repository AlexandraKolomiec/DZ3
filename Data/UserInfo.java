package Data;
import java.util.Scanner;
import java.io.*;
//import java.nio.charset.StandardCharsets;

public class UserInfo{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in= new Scanner(System.in);
        
        System.out.println("Enter your surname ");
        String surname = in.nextLine();

        System.out.println("Enter your name ");
        String name = in.nextLine();

        System.out.println("Enter your fathername ");
        String fname = in.nextLine();

        System.out.println("Enter your Date of Birth dd.mm.yyyy");
        String datebirth = in.nextLine();       

        System.out.println("Enter your phonenumber ");
        String phonenum=in.nextLine();
        int phonestr=Integer.parseInt(phonenum);
        System.out.println(phonestr);

        System.out.println("Enter sex: f or m");
        String sex=in.nextLine(); 
        
        // //проверка данных по количеству
        // String enter;
        // int ph;
        // while(true) {
        //     enter = in.nextLine();
        //     ph=phonestr;
        //     if(!(enter == surname && enter==name && enter==fname && enter==datebirth && enter==phonenum && ph==phonestr && enter==sex))
        //     System.out.println("You have not entered all data, please be attantive try again!");
        //     else break;
        // }
        in.close();       
        
        File  fileName=new File(("File.txt"));
        File surnameFile= new File(surname);
        boolean renamed=fileName.renameTo(surnameFile);
        if(renamed){
            System.out.println("File has not been renamed");
        }
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter(surnameFile,true))) {
            // значения удваиваются почему-то
            out.write(surname+" ");
            out.write(name+ " ");
            out.write(fname+" ");
            out.write(datebirth+" ");
            out.write(phonenum+" ");
            out.write(sex);
            if (surname.equalsIgnoreCase(surname)) {
                
                out.append('\n');
                out.append(surname+" ");
                out.append(name+ " ");
                out.append(fname+" ");
                out.append(datebirth+" ");
                out.append(phonenum+" ");
                out.append(sex);
            }
            out.close();
        } catch (IOException e) {
           System.out.println("Error while writing file!");
            e.printStackTrace();
        }
        
        
        
    }
}