package fr.paulduval30.titisuperboardgame;

import fr.paulduval30.titisuperboardgame.engine.GameEngine;

import javax.swing.*;

import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.board.Map;
import fr.paulduval30.titisuperboardgame.screens.BoardScreen;
public class Main
{
    public static void main(String[] argv)
    {
        SwingUtilities.invokeLater(() ->
        {
            GameEngine engine = new GameEngine("Super Tower Defense", 1280, 720);
            engine.start();
            Game g = new Game(0, null, new Map(20, 20));
            engine.setScreen(new BoardScreen(g));
        });
    }
}
