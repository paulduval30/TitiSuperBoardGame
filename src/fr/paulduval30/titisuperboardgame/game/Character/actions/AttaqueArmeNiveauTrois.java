package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Character.status.Status;
import fr.paulduval30.titisuperboardgame.game.Game;

public class AttaqueArmeNiveauTrois extends Action
{
    public AttaqueArmeNiveauTrois(int po, boolean ldv,String name, boolean defendable, Game game)
    {
        super(po, ldv, name, defendable, game);
    }

    @Override
    public void act(Character target, Character origin, int line, int col)
    {
        if(target != null)
        {
            target.dammage((int)(Math.random() * 14) +2);
            for(Status s : origin.getStatus())
            {
                if(s.getTrigger().equals("onHit"))
                {
                    s.act(target);
                }
            }
            origin.nextAction();

        }


    }
}
