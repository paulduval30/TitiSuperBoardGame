package fr.paulduval30.titisuperboardgame.game.Character.status;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.board.Cell;

public class DerobadeBuff extends Status
{
    private Character origin;

    public DerobadeBuff(int nbTurn, Game game)
    {
        super(nbTurn, "onDefend", "Derobade", game);
    }

    public void setOrigin(Character origin)
    {
        this.origin = origin;
    }

    public boolean addTurn()
    {
        if(this.nbTurn < 2)
        {
            this.nbTurn ++;
            return true;
        }
        return false;
    }

    @Override
    public void act(Character target)
    {
        if(this.nbTurn == 0)
            return;
        int line = target.getLine();
        int col = target.getCol();
        Cell[][] map = game.getMap().getGrid();
        if(line > 0)
        {
            if(map[line - 1][col].isWalkable())
                target.setLine(line - 1);
        }

        else if(line < map.length - 1)
        {
            if(map[line + 1][col].isWalkable())
                target.setLine(line + 1);
        }

        else if(col > 0)
        {
            if(map[line][col - 1].isWalkable())
                target.setCol(col - 1);
        }

        else if(col > map[line].length - 1)
        {
            if(map[line][col + 1].isWalkable())
                target.setCol(col + 1);
        }
        else
            target.setLife(target.getLife() - (int)(Math.random() * 3) + 1);
        this.nbTurn--;
    }
}
