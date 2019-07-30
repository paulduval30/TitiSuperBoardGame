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
            g.addPlayer(new Character("Aragorn", 0,0,4,0, 180, g, red), red);
            g.addPlayer(new Character("Drizzt", 0,1,5,0, 180, g, red), red);
            g.addPlayer(new Character("Legolas", 2,2,4,0, 90, g, blue), blue);
            g.addPlayer(new Character("Oziris", 2,3,4,0, 180, g, blue), blue);
            g.getPlayers().get(0).addAction("Arme LVL 1", new AttaqueArmeNiveauUn(6, true,"Arme LVL 1" , true));
            g.getPlayers().get(0).addAction("Arme LVL 2", new AttaqueArmeNiveauDeux(6, true, "Arme LVL 2", true));
            g.getPlayers().get(0).addAction("Arme LVL 3", new AttaqueArmeNiveauTrois(6, true, "Arme LVL 3", false));
            g.getPlayers().get(0).addAction("Lame Du Sacrifice", new LameDuSacrifice(6, true, "Lame Du Sacrifice", true));
            g.getPlayers().get(1).addAction("Arme LVL 1", new AttaqueArmeNiveauUn(6, true, "Arme LVL 1", true));
            g.getPlayers().get(1).addAction("Arme LVL 2", new AttaqueArmeNiveauDeux(6, true, "Arme LVL 2", true));
            g.getPlayers().get(1).addAction("Arme LVL 3", new AttaqueArmeNiveauTrois(6, true, "Arme LVL 3", true));
            g.getPlayers().get(1).addAction("Lame Du Sacrifice", new LameDuSacrifice(6, true, "Lame Du Sacrifice", false));
            g.getPlayers().get(2).addAction("Arme LVL 1", new AttaqueArmeNiveauUn(6, true, "Arme LVL 1", true));
            g.getPlayers().get(2).addAction("Arme LVL 2", new AttaqueArmeNiveauDeux(6, true, "Arme LVL 2", true));
            g.getPlayers().get(2).addAction("Arme LVL 3", new AttaqueArmeNiveauTrois(6, true, "Arme LVL 3", true));
            g.getPlayers().get(2).addAction("Lame Du Sacrifice", new LameDuSacrifice(6, true, "Lame Du Sacrifice", false));
            g.getPlayers().get(3).addAction("Arme LVL 1", new AttaqueArmeNiveauUn(6, true, "Arme LVL 1", true));
            g.getPlayers().get(3).addAction("Arme LVL 2", new AttaqueArmeNiveauDeux(6, true, "Arme LVL 2", true));
            g.getPlayers().get(3).addAction("Arme LVL 3", new AttaqueArmeNiveauTrois(6, true, "Arme LVL 3", true));
            g.getPlayers().get(3).addAction("Lame Du Sacrifice", new LameDuSacrifice(6, true, "Lame Du Sacrifice", false));
            engine.setScreen(new CharacterPickerScreen(g));
            engine.start();
            g.initGame();

        });
    }
}
