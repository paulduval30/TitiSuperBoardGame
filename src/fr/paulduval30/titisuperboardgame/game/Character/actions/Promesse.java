package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Character.status.DammageBoost;
import fr.paulduval30.titisuperboardgame.game.Game;

public class Promesse extends Action
{
    public Promesse(int po, boolean ldv, String name, boolean defendable, Game game)
    {
        super(po, ldv, name, defendable, game);
    }

    @Override
    public void act(Character target, Character origin, int line, int col)
    {
        if(target != null && target.getTeam().equals(origin.getTeam()))
        {
            int tmpLine = target.getLine();
            int tmpCol = target.getCol();

            target.setLine(origin.getLine());
            target.setCol(origin.getCol());

            origin.setLine(tmpLine);
            origin.setCol(tmpCol);

            game.setState("acting",origin.getActions().get("Arme LVL 3"));
            origin.addStatus(new DammageBoost(1,1,10));

            origin.nextAction();
        }
    }
}
