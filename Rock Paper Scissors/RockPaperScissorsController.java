import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rps")
public class RockPaperScissorsController {

    private RockPaperScissors game = new RockPaperScissors();

    @PostMapping("/play")
    public Map<String, String> playGame(@RequestParam String playerChoice) {
        game.playRound(playerChoice);

        return Map.of(
            "playerChoice", game.getPlayerChoice(),
            "computerChoice", game.getComputerChoice(),
            "result", game.getResult()
        );
    }

    @PostMapping("/reset")
    public String resetGame() {
        game = new RockPaperScissors();
        return "Game reset!";
    }
}