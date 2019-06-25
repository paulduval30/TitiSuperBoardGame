package fr.paulduval30.titisuperboardgame;

import fr.paulduval30.titisuperboardgame.engine.GameEngine;

import javax.swing.*;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.board.Map;
import fr.paulduval30.titisuperboardgame.screens.BoardScreen;
public class Main
{
    public static void main(String[] argv)
    {
        SwingUtilities.invokeLater(() ->
        {
            GameEngine engine = new GameEngine("Titi super board game", 1280, 720);
            Game g = new Game(2, new Map(21, 21));
            g.addPlayer(new Character("Paul", 0,0,6,0, g));
            g.addPlayer(new Character("Titi", 20,20,6,0, g));
            engine.setScreen(new BoardScreen(g));
            engine.start();
            g.initGame();
        });
    }
}
