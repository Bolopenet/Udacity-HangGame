import java.util.regex.Pattern;

public class Alpha {
   private void check(String chooseLetter){
       if(!Pattern.matches("[a-zA-Z]+",chooseLetter)) { System.out.println("Choose a letter"); }
   }
}
