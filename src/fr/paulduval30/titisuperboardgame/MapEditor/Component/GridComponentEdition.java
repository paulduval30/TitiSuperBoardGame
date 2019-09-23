package fr.paulduval30.titisuperboardgame.MapEditor.Component;

import fr.paulduval30.titisuperboardgame.component.GameGrid;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.board.Cell;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GridComponentEdition extends GameGrid
{
    private Game game;
    private String cell;
    public GridComponentEdition(Game game)
    {
        super(game);
        this.game = game;
        this.cell = "f";
        this.deltaX = 0;
        this.deltaY = 0;
    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        super.render(engine, gg);
        gg.setColor(Color.WHITE);
        for(int i = 0; i < this.game.getMap().getNbCol(); i++)
        {

            for (int j = 0; j < this.game.getMap().getNbLine(); j++)
            {

                gg.drawRect(deltaX + i * this.size, deltaY + j * this.size, this.size, this.size);

            }
        }
    }

    @Override
    public void update(GameEngine engine)
    {
        super.update(engine);
        int s1 = ((engine.getHeight())) / game.getMap().getNbLine();
        int s2 = ((engine.getWidth())) / game.getMap().getNbCol();
        this.size = s1 < s2 ? s1 : s2;
        if(this.size == 0)
            return;
        int line = (engine.getInput().getMouseY()) / this.size;
        int col = (engine.getInput().getMouseX()) / this.size;
        if(engine.getInput().isKeyDown(KeyEvent.VK_F))
            this.cell = "f";
        if(engine.getInput().isKeyDown(KeyEvent.VK_W))
            this.cell = "w";
        if(engine.getInput().isKeyDown(KeyEvent.VK_S))
            this.cell = "s";
        if(engine.getInput().isKeyDown(KeyEvent.VK_E))
            this.cell = "e";
        if(engine.getInput().isKeyDown(KeyEvent.VK_M))
            this.cell = "m";
        if(engine.getInput().isKeyDown(KeyEvent.VK_F1))
        {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(this.game.getMap().toMapString()),new StringSelection(this.game.getMap().toMapString()));
        }
        if(engine.getInput().isMouseDown(MouseEvent.BUTTON1))
        {

            if(line >= 0 && line < game.getMap().getNbLine() && col >= 0 && col < game.getMap().getNbCol())
            {
                System.out.println("ok");
                if (cell.equals("f"))
                    this.game.getMap().setCell(line, col, "forest", true, 3);
                if (cell.equals("w"))
                    this.game.getMap().setCell(line, col, "water", true, 3);
                if (cell.equals("m"))
                    this.game.getMap().setCell(line, col, "mountain", false, 1000);
                if (cell.equals("e"))
                    this.game.getMap().setCell(line, col, "empty", true, 1);
                if (cell.equals("s"))
                    this.game.getMap().setCell(line, col, "sand", true, 2);
            }
        }
    }


}
