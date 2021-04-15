import java.util.Enumeration;
import java.util.Scanner;
import java.lang.reflect.Array;

public class frequency {
    public static void main(String args[])
    {
        char str[] = new char[100];
        int i;
        char c;
        int freq[] = new int[256];
        str[0]='h';
        str[1]='e';
        str[2]='l';
        str[3]='l';
        str[4]='o';
        for (i = 0; str[i] != '\0'; i++)
        {
            freq[str[i]]++;
        }
        for (i =0; i <256;i++)
        {
            if(freq[i] != 0 )
            {
                System.out.println(i+freq[i]);
            }
        }


    }
}
