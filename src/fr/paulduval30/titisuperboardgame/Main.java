package fr.paulduval30.titisuperboardgame;

import fr.paulduval30.titisuperboardgame.dialog.ActionDialogBox;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;

import javax.swing.*;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Character.actions.AttaqueArmeNiveauDeux;
import fr.paulduval30.titisuperboardgame.game.Character.actions.AttaqueArmeNiveauTrois;
import fr.paulduval30.titisuperboardgame.game.Character.actions.AttaqueArmeNiveauUn;
import fr.paulduval30.titisuperboardgame.game.Character.actions.LameDuSacrifice;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.Team;
import fr.paulduval30.titisuperboardgame.game.board.Map;
import fr.paulduval30.titisuperboardgame.screens.BoardScreen;
import fr.paulduval30.titisuperboardgame.screens.CharacterPickerScreen;

public class Main
{
    public static void main(String[] argv)
    {
        SwingUtilities.invokeLater(() ->
        {
            GameEngine engine = new GameEngine("Titi super board game", 1280, 720);
            String map[][] = new String[][]{
                    {"f","f","f","f","f","f","e","e","e","e","s","w","w","w","w","w","w","f","f","f","f","e","e","e"},
                    {"f","f","f","f","f","e","e","e","e","e","s","w","w","w","w","w","w","f","f","f","f","e","e","e"},
                    {"f","f","f","f","f","e","e","e","e","s","s","w","w","w","w","w","f","f","f","f","f","e","e","e"},
                    {"f","f","e","e","e","e","e","e","s","s","w","w","w","w","w","w","f","f","f","f","f","e","e","e"},
                    {"e","e","e","e","e","e","e","s","s","s","w","w","w","w","w","w","f","f","f","e","e","e","e","e"},
                    {"e","e","e","e","e","e","e","s","w","w","w","w","w","w","f","f","f","f","e","e","e","e","e","e"},
                    {"e","e","e","e","e","e","e","s","w","w","e","e","w","w","s","e","e","e","e","e","e","e","e","e"},
                    {"e","e","e","e","e","e","f","f","w","w","e","e","w","w","s","e","e","e","e","e","e","e","e","e"},
                    {"e","e","e","e","e","e","f","f","w","w","w","w","w","w","s","e","e","e","e","e","e","e","e","e"},
                    {"e","e","e","e","e","e","f","f","f","w","w","w","w","s","s","e","e","e","e","e","e","e","e","e"},
                    {"e","e","e","e","e","f","f","f","f","w","w","w","s","s","e","e","e","e","e","e","e","e","e","e"},
                    {"e","e","e","e","e","f","f","f","f","w","w","w","s","s","e","e","e","e","e","e","e","e","e","e"},
                    {"e","e","e","e","e","f","f","f","f","w","w","w","s","s","e","e","e","e","e","e","e","e","e","e"},
                    {"e","e","e","e","e","f","f","f","f","w","w","w","s","s","e","e","f","f","f","e","e","e","e","e"},
                    {"f","f","e","e","e","f","f","f","w","w","w","w","w","s","s","e","f","f","f","f","f","f","f","f"},
                    {"f","f","f","e","e","f","f","f","w","w","w","w","w","s","e","f","f","f","f","f","f","f","f","f"},
                    {"f","f","f","f","e","f","f","f","w","w","w","w","w","f","f","f","f","f","f","f","f","f","f","f"},
                    {"f","f","f","f","e","f","f","f","w","w","w","w","w","f","f","f","f","f","f","f","f","f","f","f"},
            };
            Game g = new Game(2, new Map(map));
            Team red = new Team("red");
            Team blue = new Team("blue");
            g.addTeam(red);
            g.addTeam(blue);
            engine.setScreen(new CharacterPickerScreen(g));
            engine.start();

        });
    }
}
