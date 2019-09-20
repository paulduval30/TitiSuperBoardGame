package fr.paulduval30.titisuperboardgame.MapEditor.screen;

import fr.paulduval30.titisuperboardgame.component.GameGrid;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.board.Cell;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GridComponentEdition extends GameGrid
{
    private Game game;
    private String cell;
    private static int SIZE = 0;
    public GridComponentEdition(Game game)
    {
        super(game);
        this.game = game;
        this.cell = "f";
    }

    @Override
    public void update(GameEngine engine)
    {
        super.update(engine);
        int s1 = ((engine.getHeight() - (int)(engine.getHeight() * 0.2)) / game.getMap().getNbLine());
        int s2 = ((engine.getWidth() - (int)(engine.getWidth() * 0.4)) / game.getMap().getNbCol());
        SIZE = s1 < s2 ? s1 : s2;
        if(SIZE == 0)
            return;
        int line = (engine.getInput().getMouseY() - 20) / SIZE;
        int col = (engine.getInput().getMouseX() - 20) / SIZE;
        if(engine.getInput().isKeyDown(KeyEvent.VK_F))
        {
            this.cell = "f";
        }
        if(engine.getInput().isKeyDown(KeyEvent.VK_W))
            this.cell = "w";
        if(engine.getInput().isKeyDown(KeyEvent.VK_S))
            this.cell = "s";
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
