package fr.paulduval30.titisuperboardgame.game.board;

public class Cell
{
    private int line;
    private int col;
    private String type;

    public Cell(int line, int col, String type)
    {
        this.line = line;
        this.col = col;
        this.type = type;
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
