package fr.paulduval30.titisuperboardgame;

import fr.paulduval30.titisuperboardgame.engine.GameEngine;

import javax.swing.*;

import fr.paulduval30.titisuperboardgame.screens.MainScreen;
import paulduval30.fr.titisuperboardgame.screens.*;
public class Main
{
    public static void main(String[] argv)
    {
        SwingUtilities.invokeLater(() ->
        {
            GameEngine engine = new GameEngine("Super Tower Defense", 1280, 720);
            engine.start();
            engine.setScreen(new MainScreen());
        });
    }
}
