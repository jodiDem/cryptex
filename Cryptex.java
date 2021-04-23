import java.util.Scanner;
public class Cryptex
{
    static Scanner l = new Scanner(System.in);
    
    int letters;
    String blockword;
    String secretword;
    String rings[];
    int index;
    char finletter;//letter to look for
    int finalpos;//position of the actual word to be found
    public static void main()
    {
        System.out.print('\u000c');
        Cryptex cryptex = new Cryptex();
        
        System.out.print("Cases:");
        int cases = l.nextInt();
        int x = 0;
        
        do
        {
        cryptex.Readblock();
        cryptex.Readstrings();
        cryptex.Getblockword();
        cryptex.Getsecret();
        cryptex.Printsecret();
        x++;
       }
       while (x<cases);
    }
    public void Readblock()
    {
        System.out.print("Number of Letters:");
        letters = l.nextInt();
        
        System.out.print("Unblocking Word:");
        blockword = l.next();
        
        System.out.print("Secret Word:");
        secretword = l.next();
        
        rings = new String[letters];
    }
    public void Readstrings()
     {    
        System.out.print("Rings:");
         for(int i = 0; i < letters; i++)
        {           
            rings[i] = l.next();
        }
    }
    public void Getblockword()
    {
        for(int i = 0; i < rings.length; i++)
        {
            String substr = rings[i].substring(rings[i].indexOf(blockword.charAt(i)), rings[i].length());
            rings[i] = substr + rings[i].substring(0,rings[i].indexOf(blockword.charAt(i)));
            
        }
    }
    public void Getsecret()
    {
        for (int i = 0; i < secretword.length(); i++)
       {
           if ((int)secretword.charAt(i)>= 65 && (int)secretword.charAt(i) <= 90)
           {
               finletter = secretword.charAt(i);
               index = secretword.indexOf(secretword.charAt(i));
           }
       }
       finalpos = rings[index].indexOf(finletter);
    }
    public void Printsecret()
    {
        System.out.print(blockword + " ");
        for (int i = 0; i < letters; i++)
        {
            System.out.print(rings[i].charAt(finalpos));
        }
        System.out.println();
    }
}
