package fr.paulduval30.titisuperboardgame.game.Character;

public class Character
{
    private String name;

    private int line;
    private int col;
    private int pm;
    private int nbAction;

    public Character(String name, int line, int col, int pm, int nbAction)
    {
        this.name = name;
        this.line = line;
        this.col = col;
        this.pm = pm;
        this.nbAction = nbAction;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getLine()
    {
        return line;
    }

    public void setLine(int line)
    {
        this.line = line;
    }

    public int getCol()
    {
        return col;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public int getPm()
    {
        return pm;
    }

    public void setPm(int pm)
    {
        this.pm = pm;
    }

    public int getNbAction()
    {
        return nbAction;
    }

    public void setNbAction(int nbAction)
    {
        this.nbAction = nbAction;
    }
}
