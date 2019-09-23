package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;

public class FlecheDeTeleportation extends Action
{
    public FlecheDeTeleportation(int po, boolean ldv, String name, boolean defendable, Game game)
    {
        super(po, ldv, name, defendable, game);
    }

    @Override
    public void act(Character target, Character origin, int line, int col)
    {
        if(game.getMap().getGrid()[line][col].isWalkable())
        {
            origin.setLine(line);
            origin.setCol(col);
            origin.nextAction();
        }

    }
}
