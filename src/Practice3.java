import java.util.*;

public class Practice3 {
    static String [] s={"godfather","inception","goodfellas","matrix","se7en","interstellar","whiplash"};
    static String stared="";
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rnd=new Random();
        String miss="";
        String guess=new String();
        int index=rnd.nextInt(7);
        String encrypted = Encrypting(s[index]);

        for(int i=10;i>0;i--){
            System.out.println("Word: "+encrypted);
            System.out.println("Miss: "+miss);
            System.out.println("Try: "+i);
            System.out.print("Guess: ");
            guess=scn.next();
            System.out.println();
            if(stared.contains(guess)){encrypted=Decrypting(guess.charAt(0),encrypted.toCharArray(),index);}
            else{miss+=guess;}
            if(encrypted.equals(s[index])){
                System.out.println(encrypted);
                break;}
        }
    }
    public static String Encrypting(String chosenW){
        String temp="";
        for(int i=1;i<chosenW.length();i+=2){
            stared +=chosenW.charAt(i-1);
            temp+= "*"+chosenW.charAt(i); }

        if(chosenW.length()%2==0){ return temp;}
        else{return temp+chosenW.charAt(chosenW.length()-1);}
    }
    public static String Decrypting(char guess,char[] hidden,int index){
        char[] ss=s[index].toCharArray();
        for(int i=0;i<ss.length;i++){
            if(ss[i]==guess)
                hidden[i]=guess;
        }
        String temphidden="";
        for(char i:hidden){temphidden+=i;}
        return temphidden;
    }
}

