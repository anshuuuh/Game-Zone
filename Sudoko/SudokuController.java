import Sudoku;

package Su;
import Su.Sudoku;

@RestController
public class SudokuController {
    private Sudoku game = new Sudoku();

    @GetMapping("/validateMove")
    public Map<String, Object> validateMove(
        @RequestParam int row,
        @RequestParam int col,
        @RequestParam int num) {

        boolean success = game.setNumber(row, col, num);
        return Map.of("valid", success);
    }

    @GetMapping("/getBoard")
    public int[][] getBoard() {
        return game.getBoard();
    }
}
