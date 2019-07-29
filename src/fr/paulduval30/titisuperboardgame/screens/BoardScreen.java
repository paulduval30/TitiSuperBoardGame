package fr.paulduval30.titisuperboardgame.screens;

import fr.paulduval30.titisuperboardgame.component.CharacterDescription;
import fr.paulduval30.titisuperboardgame.component.CharacterMenu;
import fr.paulduval30.titisuperboardgame.component.GameGrid;
import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.engine.Screen;
import fr.paulduval30.titisuperboardgame.game.Game;

import java.util.ArrayList;

public class BoardScreen extends Screen
{
    private static int SIZE = 50;
    private final Game game;
    private ArrayList<Component> components;

    public BoardScreen(Game g)
    {
        super();
        this.game = g;
        this.components = new ArrayList<>();
        this.components.add(new GameGrid(game));
        this.components.add(new CharacterMenu(game));
        this.components.add(new CharacterDescription(game.getCurrentPlayer(), game));
    }
    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        for(Component c : components)
        {
            c.render(engine, gg);
        }
    }

    @Override
    public void update(GameEngine engine)
    {
        for(Component c : components)
        {
            c.update(engine);
        }
    }
}
