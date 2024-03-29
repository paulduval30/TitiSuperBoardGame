package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Character.actions.*;
import fr.paulduval30.titisuperboardgame.game.Character.status.DammageBoost;
import fr.paulduval30.titisuperboardgame.game.Character.status.Poison;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.Team;
import fr.paulduval30.titisuperboardgame.screens.BoardScreen;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;

public class CharacterPicker extends Component
{
    HashMap<String, String[]> characters;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int size;
    private String choice;
    private Game game;
    private int nbPick;
    private HashMap<String, Image> images;
    private CharacterPickDescription characterPickDescription;
    private Image po;
    private Image pm;
    private Image life;

    public CharacterPicker(HashMap<String, String[]> characters, Game g)
    {
        this.characters = characters;
        this.choice = "";
        this.game = g;
        this.nbPick = 0;
        this.images = new HashMap<>();
        try
        {
            this.po = ImageIO.read(new File("res/PO.png"));
            this.pm = ImageIO.read(new File("res/PM.png"));
            this.life = ImageIO.read(new File("res/life.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        for(String s : characters.keySet())
        {
            try
            {
                images.put(s, ImageIO.read(new File("res/" + s + ".jpg")));
            }
            catch (IOException e)
            {
                System.out.println(s);

                e.printStackTrace();
            }
        }
        this.characterPickDescription = new CharacterPickDescription(null, false);
    }

    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        if(!characterPickDescription.getState())
        {
            gg.setColor(Color.BLACK);
            gg.fillRect(0,0, engine.getWidth(), engine.getHeight());
            gg.setColor(Color.WHITE);
            gg.fillRoundRect(this.posX, this.posY,this.width, this.height,10,10);
            gg.setColor(Color.DARK_GRAY);
            int line = 0;
            int col = 0;
            if(characters.get((characters.keySet().toArray()[0]))[10].equals("true"))
            {
                gg.setColor(new Color(0,0,0,150));
            }
            else
            {
                gg.setColor(new Color(0,0,0,0));
            }
            gg.drawImage(images.get(characters.keySet().toArray()[0]),this.posX + (col )* size,this.posY + line * size, size,size);
            gg.fillRect(this.posX + (col )* size,this.posY + line * size, size,size);
            if(this.choice.equals(characters.keySet().toArray()[0]))
            {
                gg.setColor(new Color(Color.GREEN.getRed(), Color.GREEN.getGreen(), Color.GREEN.getBlue(),150));
                gg.fillRect(this.posX + (col )* size, this.posY+line*size,size,size);

            }


            for(int i = 1; i < characters.keySet().toArray().length; i++)
            {
                if(i%10 == 0)
                {
                    line ++;
                    col = 0;
                }
                else
                    col ++;

                if(i >= characters.size())
                {
                    continue;
                }
                gg.setColor(Color.BLACK);
                gg.drawImage(images.get(characters.keySet().toArray()[i]),this.posX + (col )* size,this.posY + line * size, size,size);
                gg.drawRect(this.posX + (col )* size,this.posY + line * size, size,size);
                if(characters.get((characters.keySet().toArray()[i]))[10].equals("true"))
                {
                    gg.setColor(new Color(0,0,0,150));
                    gg.fillRect(this.posX + (col )* size,this.posY + line * size, size,size);

                }

                if(this.choice.equals(characters.keySet().toArray()[i]))
                {
                    gg.setColor(new Color(Color.GREEN.getRed(), Color.GREEN.getGreen(), Color.GREEN.getBlue(),150));
                    gg.fillRect(this.posX + (col )* size, this.posY+line*size,size,size);

                }
            }
            gg.setColor(Color.lightGray);
            gg.fillRoundRect(this.posX, this.posY + this.height, this.width, this.height / 10, 10,10);
            gg.setColor(Color.BLACK);
            if(!choice.equals(""))
            {
                gg.drawString("Name : " + choice, this.posX, this.posY + this.height + this.height / 15);
                gg.drawImage(this.life, this.posX + this.width / 5, this.posY + this.height + (this.height / 10) / 2 - 10, 20 , 20);
                gg.drawString( " : " + this.characters.get(choice)[1], this.posX + this.width / 5 + 20, this.posY + this.height + this.height / 15);
                gg.drawImage(this.po, this.posX + this.width / 5 * 2, this.posY + this.height + (this.height / 10) / 2 - 10, 20 , 20);
                gg.drawString( " : " + this.characters.get(choice)[6], this.posX + this.width / 5 * 2 + 20, this.posY + this.height + this.height / 15);
                gg.drawImage(this.pm, this.posX + this.width / 5 * 3, this.posY + this.height + (this.height / 10) / 2 - 10, 20 , 20);
                gg.drawString( " : " + this.characters.get(choice)[5], this.posX + this.width / 5 * 3 + 20, this.posY + this.height + this.height / 15);

            }
        }
        else
            characterPickDescription.render(engine,gg);

    }

    @Override
    public void update(GameEngine engine)
    {
        characterPickDescription.update(engine);
        this.posX = (int)(engine.getWidth() * 0.1f);
        this.posY = (int)(engine.getHeight() * 0.1f);
        this.width = (int)(engine.getWidth() * 0.8f);
        this.size = this.width/10;
        this.height = (int)(size * (characters.keySet().toArray().length / 10));

        int mouseX = engine.getInput().getMouseX();
        int mouseY = engine.getInput().getMouseY();

        if(mouseX > this.posX && mouseX < this.posX + this.width && mouseY > this.posY && mouseY < this.posY + this.height)
        {
            mouseX -= this.posX;
            mouseY -= this.posY;
            int ligne = mouseY / size;
            int col = mouseX / size;
            this.choice = (String)characters.keySet().toArray()[ligne * 10 + col];
            String[] data = characters.get(choice);
            String name = data[0];
            String life = data[1];
            String armure = data[2];
            String arme = data[3];
            String coupsournois = data[4];
            String pm = data[5];
            String po = data[6];
            String att1 = data[7];
            String att2 = data[8];
            String att3 = data[9];
            String state = data[10];
            int lvlArmure = armure.equals("LEG") ? 1 : armure.equals("INT") ? 2 : 3;
            if(!characterPickDescription.getState() && engine.getInput().isMousePressed(MouseEvent.BUTTON1) && state.equals("false"))
            {
                ArrayList<Team> teams = game.getTeams();
                Team picking = teams.get(0);
                for(Team t : teams)
                {
                    if(t.getCharacters().size() < picking.getCharacters().size())
                    {
                        picking = t;
                    }
                }
                int line = 0;
                int colonne = 0;
                if(game.getCharacter(0,0) != null)
                {
                    line = game.getMap().getNbLine() - 1;
                    colonne = game.getMap().getNbCol() - 1;
                }
                if(game.getCharacter(game.getMap().getNbLine() - 1, game.getMap().getNbCol() - 1) != null)
                {
                    line = game.getMap().getNbLine() - 1;
                    colonne = 0;
                }
                if(game.getCharacter(game.getMap().getNbLine() - 1, 0) != null)
                {
                    line = 0;
                    colonne = game.getMap().getNbCol() - 1;
                }
                Character c = new Character(name, line, colonne, new Integer(pm),2, new Integer(life), game, picking);
                picking.addCharacter(c);
                game.addPlayer(c, picking);
                nbPick ++;
                characters.get(choice)[10] = "true";

                if(nbPick == 4)
                {
                    game.getPlayers().get(0).addAction("Derobade", new Derobade(6, true,"Derobade" , true, game));
                    game.getPlayers().get(0).addAction("Promesse", new Promesse(6, true, "Promesse", true, game));
                    game.getPlayers().get(0).addAction("Arme LVL 3", new AttaqueArmeNiveauTrois(6, true, "Arme LVL 3", false, game));
                    game.getPlayers().get(0).addAction("Lame Du Sacrifice", new LameDuSacrifice(6, true, "Lame Du Sacrifice", true, game));
                    game.getPlayers().get(1).addAction("Arme LVL 1", new AttaqueArmeNiveauUn(6, true, "Arme LVL 1", true, game));
                    game.getPlayers().get(1).addAction("Arme LVL 2", new AttaqueArmeNiveauDeux(6, true, "Arme LVL 2", true, game));
                    game.getPlayers().get(1).addAction("Arme LVL 3", new AttaqueArmeNiveauTrois(6, true, "Arme LVL 3", true, game));
                    game.getPlayers().get(1).addAction("Lame Du Sacrifice", new LameDuSacrifice(6, true, "Lame Du Sacrifice", false, game));
                    game.getPlayers().get(2).addAction("Arme LVL 1", new AttaqueArmeNiveauUn(6, true, "Arme LVL 1", true, game));
                    game.getPlayers().get(2).addAction("Arme LVL 2", new AttaqueArmeNiveauDeux(6, true, "Arme LVL 2", true, game));
                    game.getPlayers().get(2).addAction("Arme LVL 3", new AttaqueArmeNiveauTrois(6, true, "Arme LVL 3", true, game));
                    game.getPlayers().get(2).addAction("Lame Du Sacrifice", new LameDuSacrifice(6, true, "Lame Du Sacrifice", false, game));
                    game.getPlayers().get(3).addAction("Arme LVL 1", new AttaqueArmeNiveauUn(6, true, "Arme LVL 1", true, game));
                    game.getPlayers().get(3).addAction("Arme LVL 2", new AttaqueArmeNiveauDeux(6, true, "Arme LVL 2", true, game));
                    game.getPlayers().get(3).addAction("Arme LVL 3", new AttaqueArmeNiveauTrois(6, true, "Arme LVL 3", true, game));
                    game.getPlayers().get(3).addAction("Lame Du Sacrifice", new LameDuSacrifice(6, true, "Lame Du Sacrifice", false, game));
                    engine.setScreen(new BoardScreen(game));
                }
            }
            if(engine.getInput().isMousePressed(MouseEvent.BUTTON3))
            {
                this.characterPickDescription.setData(characters.get(choice));
                this.characterPickDescription.setState(true);
            }
        }
        else
            choice = "";
    }
}
