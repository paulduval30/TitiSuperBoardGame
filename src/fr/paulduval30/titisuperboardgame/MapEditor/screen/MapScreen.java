package fr.paulduval30.titisuperboardgame.MapEditor.screen;

import fr.paulduval30.titisuperboardgame.MapEditor.Component.GridComponentEdition;
import fr.paulduval30.titisuperboardgame.component.CharacterDescription;
import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.screens.BoardScreen;

import java.util.ArrayList;

public class MapScreen extends BoardScreen
{
    private static int SIZE = 50;
    private final Game game;
    private ArrayList<Component> components;

    public MapScreen(Game g)
    {
        super(g);
        this.game = g;
        this.components = new ArrayList<>();
        this.components.add(new GridComponentEdition(game));
        if(game.getPlayers().size() != 0)
            this.components.add(new CharacterDescription(game.getCurrentPlayer(), game));
        game.initGame();
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
