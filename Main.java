import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int howManyUnderScores = 0;
    public static void main(String[] args) {

        ArrayList<String> guesses = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        words.add("PYTHON");
        words.add("FOOD");
        words.add("ZEPPELIN");
        words.add("VALKYRIE");
        words.add("AUDACITY");
        words.add("CERAMIC");
        words.add("XYLOPHONE");
        words.add("POLYCHROMATIC");
        words.add("ZOOTOPIA");
        words.add("LETTUCE");
        words.add("TRIGONOMETRIC");
        Random r = new Random();
        System.out.println(r.nextInt(words.size()));
        String answer = words.get(r.nextInt(words.size()));
        howManyUnderScores = answer.length();
        DrawTheGuy coolGuy = new DrawTheGuy();
        System.out.println(answer);
        Scanner input= new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            String guess = input.next(); //
            guesses.add(guess.toUpperCase());
            System.out.println(guesses); //All of our current guesses are being printed
            for (int j = 0; j < answer.length(); j++) {
                if(guesses.contains(String.valueOf(answer.charAt(j)))) {
                    System.out.print(answer.charAt(j));
                }else{
                    System.out.print("_");
                    howManyUnderScores++;
                }
            }
            if(guess.length() > 1){
                System.out.println("You typed too many letters ");
            }


            for(int j = 0; j < answer.length()-1; j++) {
                if( String.valueOf(answer.charAt(j)).equals(guess.toUpperCase()) ){
                    System.out.println("you guessed correctly");

                    i--;

                    break;
                }

            }
            if(howManyUnderScores == 0) {
                break;
            }
        }


    }
}
