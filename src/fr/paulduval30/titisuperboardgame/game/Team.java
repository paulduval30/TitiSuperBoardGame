package fr.paulduval30.titisuperboardgame.game;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

import java.util.ArrayList;

public class Team
{
    public ArrayList<Character> characters;
    public ArrayList<Integer> nbAction;

    public Team()
    {
        this.characters = new ArrayList<>();
        this.nbAction = new ArrayList<>();
        this.initNbAction();
    }

    public void addCharacter(Character c)
    {
        this.characters.add(c);
    }

    public void initNbAction()
    {
        nbAction.add(1);
        nbAction.add(2);
        nbAction.add(3);
        nbAction.add(4);
    }

    public int takeAction(int action)
    {
        for(Integer i : nbAction)
        {
            if(i.equals(new Integer(action)))
            {
                nbAction.remove(i);
                if(nbAction.size() == 0)
                    this.initNbAction();
                return i;

            }
        }
        return -1;
    }

    public ArrayList<Character> getCharacters()
    {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters)
    {
        this.characters = characters;
    }

    public ArrayList<Integer> getNbAction()
    {
        return nbAction;
    }

    public void setNbAction(ArrayList<Integer> nbAction)
    {
        this.nbAction = nbAction;
    }
}
