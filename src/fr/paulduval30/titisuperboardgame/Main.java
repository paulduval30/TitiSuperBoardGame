package fr.paulduval30.titisuperboardgame;

import fr.paulduval30.titisuperboardgame.dialog.ActionDialogBox;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;

import javax.swing.*;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Character.actions.AttaqueArmeNiveauTrois;
import fr.paulduval30.titisuperboardgame.game.Character.actions.AttaqueArmeNiveauUn;
import fr.paulduval30.titisuperboardgame.game.Character.actions.LameDuSacrifice;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.Team;
import fr.paulduval30.titisuperboardgame.game.board.Map;
import fr.paulduval30.titisuperboardgame.screens.BoardScreen;
public class Main
{
    public static void main(String[] argv)
    {
        SwingUtilities.invokeLater(() ->
        {
            GameEngine engine = new GameEngine("Titi super board game", 1280, 720);
            String map[][] = new String[][]{
                    {"e","w","e","e","f","f","m","w","e","m","w","w","w","w","w","w","w","w","w"},
                    {"f","w","e","f","f","f","e","w","w","w","w","w","w","f","f","e","e","e","w"},
                    {"f","w","e","f","f","f","e","f","f","f","f","w","w","f","f","e","e","e","w"},
                    {"f","w","e","f","f","f","e","w","w","w","w","w","w","f","f","e","e","e","w"},
                    {"f","w","e","f","f","f","e","w","w","w","w","w","w","f","f","e","e","e","w"},
                    {"f","w","e","f","w","f","e","w","w","f","m","e","w","f","m","w","e","e","w"},
                    {"e","w","e","w","e","f","w","f","e","w","m","e","f","f","m","w","w","w","w"},
                    {"f","w","e","w","w","f","e","w","w","w","w","w","w","f","f","e","e","e","w"},
                    {"e","w","e","w","e","f","w","f","e","w","m","e","w","f","m","w","w","w","w"}
            };
            Game g = new Game(2, new Map(map));
            Team red = new Team();
            Team blue = new Team();
            g.addPlayer(new Character("Aragorn", 0,0,4,0, 180, g, red), red);
            g.getPlayers().get(0).addAction("Arme LVL 3", new AttaqueArmeNiveauTrois(6, true));
            g.getPlayers().get(0).addAction("Lame Du Sacrifice", new LameDuSacrifice(6, true));
            g.addPlayer(new Character("Legolas", 2,2,4,0, 90, g, blue), blue);
            engine.setScreen(new BoardScreen(g));
            engine.start();
            g.initGame();

        });
    }
}
