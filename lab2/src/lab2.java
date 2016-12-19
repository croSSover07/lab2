import javax.xml.soap.SOAPPart;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by UMF on 19.12.2016.
 */
public class lab2 {



    public static String file (String filename)
    {
        String str = "";
        Scanner sc;
        sc = new Scanner(System.in);
        try{
            sc=new Scanner(new File(filename));
        }catch (Exception e)
        {
            System.err.println(e.toString());
        }
        while(sc.hasNext())
            str=str+sc.next()+" ";

        return str;
    }
    public static String writeAllText()
    {
        System.out.print("\tВходная строка : ");
        Scanner sc = new Scanner(System.in);
        String str=sc.next();

        return str;
    }
    public static String searchingText()
    {

        System.out.print("\tИскать : ");
        Scanner sc = new Scanner(System.in);
        String str=sc.next();

        return str;
    }
    public static void compareAlgorithm(String allText,String searchText)
    {
        long time;
        time=System.currentTimeMillis();
        String indexOfFindingText=myAlgorithm.find(allText, searchText);
        time=System.currentTimeMillis()-time;
        System.out.println("Алгоритм грубой силы");
        System.out.println(indexOfFindingText);
        System.out.println("time :"+time);

        time=System.currentTimeMillis();
        indexOfFindingText=myAlgorithm.findByAlgorithm(allText, searchText);
        time=System.currentTimeMillis()-time;
        System.out.println("Алгоритмом КМП");
        System.out.println(indexOfFindingText);
        System.out.println("time :"+time);
    }





    public static void main(String[] args)  {
        String text="";
        String searchText="";



        System.out.println("\tC Consol\n\tF File");
        int switch_on = 0;
        try {
            switch_on = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch(switch_on){
            case 'c':
            case 'C':
                text=writeAllText();
                searchText=searchingText();
                compareAlgorithm(text,searchText);
                break;
            case 'f':
            case 'F':
                System.out.println("\tФайл : ");
                Scanner sc = new Scanner(System.in);
                String filename=sc.next();
                text=file(filename);
                searchText=searchingText();
                compareAlgorithm(text,searchText);

                break;

        }

    }
}
