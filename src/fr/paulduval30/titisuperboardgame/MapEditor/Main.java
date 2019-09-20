package fr.paulduval30.titisuperboardgame.MapEditor;

import fr.paulduval30.titisuperboardgame.MapEditor.screen.MapScreen;
import fr.paulduval30.titisuperboardgame.component.GameGrid;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.Team;
import fr.paulduval30.titisuperboardgame.game.board.Map;
import fr.paulduval30.titisuperboardgame.screens.BoardScreen;
import fr.paulduval30.titisuperboardgame.screens.CharacterPickerScreen;

import javax.swing.*;

public class Main
{
    public static void main(String[] argv)
    {
        SwingUtilities.invokeLater(() ->
    {
        GameEngine engine = new GameEngine("Game editor", 1280, 720);
        String map[][] = new String[][]{
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
                {"e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e","e"},
        };
        Game g = new Game(2, new Map(map));
        engine.setScreen(new MapScreen(g));
        engine.start();

    });
    }

}
