class PuzzleController{
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();
        // System.out.println(puzzle.getTenRolls());
        // System.out.println(puzzle.randomLetter());
        // System.out.println(puzzle.generatePassword(10));
        System.out.println(puzzle.getNewPasswordSet(4, 8));
    }
}