package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Character.status.DerobadeBuff;
import fr.paulduval30.titisuperboardgame.game.Character.status.Status;
import fr.paulduval30.titisuperboardgame.game.Game;

public class Derobade extends Action
{
    public Derobade(int po, boolean ldv, String name, boolean defendable, Game game)
    {
        super(po, ldv, name, defendable, game);
    }

    @Override
    public void act(Character target, Character origin, int line, int col)
    {
        boolean exist = false;
        for(Status s : origin.getStatus())
        {
            if(s.getName().equals("Derobade"))
            {
                exist = true;
                boolean success = ((DerobadeBuff)s).addTurn();
                if(success)
                {
                    origin.nextAction();
                    return;
                }
            }

        }
        if(!exist)
        {
            origin.addStatus(new DerobadeBuff(1, game));
            origin.nextAction();
        }
    }
}
