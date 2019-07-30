package fr.paulduval30.titisuperboardgame.game.board;

public class Map
{
    private int nbLine;
    private int nbCol;
    private Cell[][] grid;

    public Map(int nbLine, int nbCol)
    {
        this.nbLine = nbLine;
        this.nbCol = nbCol;

        this.grid = new Cell[nbLine][nbCol];
        for(int i = 0; i < nbLine; i++)
        {
            for(int j = 0; j < nbCol; j++)
            {
                this.grid[i][j] = new Cell(i, j, "empty", true, 1);
            }
        }
    }

    public Map(String[][] map)
    {
        this.grid = new Cell[map.length][map[0].length];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[0].length; j++)
            {
                if(map[i][j].equals("f"))
                    this.grid[i][j] = (new Cell(i,j,"forest", true,3));
                if(map[i][j].equals("w"))
                    this.grid[i][j] = (new Cell(i,j,"water", true,1));
                if(map[i][j].equals("m"))
                    this.grid[i][j] = (new Cell(i,j,"mountain", false,1));
                if(map[i][j].equals("e"))
                    this.grid[i][j] = (new Cell(i,j,"empty", true,1));
                if(map[i][j].equals("s"))
                    this.grid[i][j] = (new Cell(i,j,"sand", true,2));
            }
        }

        this.nbLine = grid.length;
        this.nbCol = grid[0].length;
    }

    public int getNbLine()
    {
        return nbLine;
    }

    public void setNbLine(int nbLine)
    {
        this.nbLine = nbLine;
    }

    public int getNbCol()
    {
        return nbCol;
    }

    public void setNbCol(int nbCol)
    {
        this.nbCol = nbCol;
    }

    public Cell[][] getGrid()
    {
        return grid;
    }

    public void setGrid(Cell[][] grid)
    {
        this.grid = grid;
    }

    public void setCell(int line, int col, String type, boolean walkable, int cost)
    {
        this.grid[line][col] = new Cell(line, col, type, walkable, cost);
    }

    public int getCost(int line, int col)
    {
        return this.grid[line][col].getCost();
    }
}
