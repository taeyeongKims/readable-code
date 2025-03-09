package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.minesweeper.MineSweeper;
import cleancode.minesweeper.tobe.minesweeper.config.GameConfig;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Advanced;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig(
            new Advanced(),
            new ConsoleInputHandler(),
            new ConsoleOutputHandler()
        );

        MineSweeper mineSweeper = new MineSweeper(gameConfig);
        mineSweeper.initialize();
        mineSweeper.run();
    }

    /**
     * DIP (Dependency Inversion Principle)
     *
     * DI (Dependency Injection) - "3"
     * 제 3자가 객체간 의존성을 맺어줘야 한다.
     *
     * IOC (Inversion of Control)
     */
}
