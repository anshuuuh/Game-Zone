import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TicTacToeController {

    private TicTacToe game = new TicTacToe();

    @GetMapping("/makeMove")
    public Map<String, Object> makeMove(
        @RequestParam int row,
        @RequestParam int col) {

        boolean moveMade = game.makeMove(row, col);
        boolean win = game.checkWin();
        boolean draw = game.isDraw();

        Map<String, Object> response = Map.of(
            "moveMade", moveMade,
            "currentPlayer", game.getCurrentPlayer(),
            "win", win,
            "draw", draw
        );

        // Switch player only if the move was valid and the game is not over
        if (moveMade && !win && !draw) {
            game.switchPlayer();
        }

        return response;
    }

    @GetMapping("/getBoard")
    public char[][] getBoard() {
        return game.getBoard();
    }

    @PostMapping("/reset")
    public String resetGame() {
        game.resetGame();
        return "Game reset!";
    }
}