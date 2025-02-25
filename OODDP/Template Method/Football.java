public class Football extends Game {
    @Override
    void endPlay() {
        System.out.println("Football game finished.");
    }

    @Override
    void initialize() {
        System.out.println("Football game initialized.");
    }

    @Override
    void startPlay() {
        System.out.println("Football game started. Enjoy the game.");
    }
}
