import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private String[] choices = { "Rock", "Paper", "Scissors" };
    private String playerChoice;
    private String computerChoice;
    private String result;

    public void playRound(String playerInput) {
        playerChoice = formatChoice(playerInput);
        if (!isValidChoice(playerChoice)) {
            result = "Invalid input! Please choose Rock, Paper, or Scissors.";
            return;
        }

        computerChoice = getComputerChoice();
        result = determineWinner(playerChoice, computerChoice);
    }

    private String formatChoice(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private boolean isValidChoice(String choice) {
        for (String option : choices) {
            if (option.equals(choice))
                return true;
        }
        return false;
    }

    private String getComputerChoice() {
        Random random = new Random();
        return choices[random.nextInt(3)];
    }

    private String determineWinner(String player, String computer) {
        if (player.equals(computer))
            return "It's a draw! Both chose " + player + ".";

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
                (player.equals("Paper") && computer.equals("Rock")) ||
                (player.equals("Scissors") && computer.equals("Paper"))) {
            return "You win! " + player + " beats " + computer + ".";
        } else {
            return "You lose! " + computer + " beats " + player + ".";
        }
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public String getResult() {
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RockPaperScissors game = new RockPaperScissors();
        String playAgain;

        do {
            System.out.print("Enter Rock, Paper, or Scissors: ");
            String input = scanner.nextLine();
            game.playRound(input);

            System.out.println("Computer chose: " + game.getComputerChoice());
            System.out.println(game.getResult());

            System.out.print("Play again? (yes/no): ");
            playAgain = scanner.nextLine().toLowerCase();
        } while (playAgain.equals("yes")