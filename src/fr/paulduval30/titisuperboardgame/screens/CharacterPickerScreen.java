package fr.paulduval30.titisuperboardgame.screens;

import fr.paulduval30.titisuperboardgame.component.CharacterPicker;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.engine.Screen;
import fr.paulduval30.titisuperboardgame.game.Game;

import java.io.*;
import java.util.HashMap;

public class CharacterPickerScreen extends Screen
{

    private final Game game;
    private HashMap<String, String[]> characters;
    private CharacterPicker picker;

    public CharacterPickerScreen(Game g)
    {
        this.game = g;
        this.characters = new HashMap<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(new File("res/FICHE-PERSO.csv")));
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
                String[] data = line.split(",");
//
                characters.put(data[0], data);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        this.picker = new CharacterPicker(characters, game);
    }
    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        picker.render(engine, gg);
    }

    @Override
    public void update(GameEngine engine)
    {
        picker.update(engine);
    }
}
