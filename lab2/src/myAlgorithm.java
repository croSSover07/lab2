import java.io.IOException;

/**
 * Created by UMF on 19.12.2016.
 */
public class myAlgorithm {
    public static String findByAlgorithm(String s, String patter)//Функция поиска алгоритмом КМП
    {

        String str="";
        int m=patter.length();
        if(m==0)
        {
            return str;
        }
        int []p=indexesOf(patter);
        int i=0,j;
        while(i<s.length())
        {
            for(j=0;(i<s.length())&&(j<patter.length());i++,j++)
                while((j>=0)&&(patter.charAt(j)!=s.charAt(i)))
                    j=p[j];
            if(j==patter.length())
                str=str+Integer.toString((i-j)+1)+" ";
        }

        return str;
    }
    public static int [] indexesOf (String s)//Префикс-функция для КМП
    {
        int n=s.length();
        int []p=new int[n];
        int i=0; int j=-1;
        p[0]=-1;
        //Вычисление префикс-функции
        while(i<s.length()-1)
        {
            while((j>=0)&&(s.charAt(j)!=s.charAt(i)))
                j=p[j];
            i++;
            j++;
            if(s.charAt(i)==s.charAt(j))
                p[i]=p[j];
            else
                p[i]=j;

        }
        return p;
    }

    public static String find(String s, String patter)//Алгоритм грубой силы
    {

        String str="";
        int k=1;
        for(int i=0;i<s.length()-1;i++)
        {
            k=1;
            if(s.charAt(i)==patter.charAt(0))
                for(int j=1;j<patter.length();j++)
                {
                    if(s.charAt(i+j)==patter.charAt(0+j))
                        k++;
                }
            if(k==patter.length())
                str=str+Integer.toString(i+1)+" ";
        }

        return str;
    }


}

