package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;

public class LameDuSacrifice extends Action
{
    public LameDuSacrifice(int po, boolean ldv, String name, boolean defendable, Game game)
    {
        super(po, ldv, name, defendable, game);
    }

    @Override
    public void act(Character target, Character origin, int line, int col)
    {
        target.health((int)(Math.random() * 10) +2);
        origin.dammage((int)(Math.random() * 19) + 1);
        origin.nextAction();
    }
}
