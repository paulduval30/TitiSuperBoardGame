package fr.paulduval30.titisuperboardgame.game.Character;

import fr.paulduval30.titisuperboardgame.game.Character.actions.Action;
import fr.paulduval30.titisuperboardgame.game.Game;

import java.util.ArrayList;
import java.util.HashMap;

public class Character
{
    private String name;

    private int line;
    private int col;
    private int pm;
    private int currentPM;
    private int nbAction;
    private HashMap<String, Action> powers;
    private boolean isCurrent;
    private int[][] matricePoids;
    private Game game;

    public Character(String name, int line, int col, int pm, int nbAction, Game game)
    {
        this.name = name;
        this.line = line;
        this.col = col;
        this.pm = pm;
        this.nbAction = nbAction;
        this.powers = new HashMap<>();
        this.isCurrent = false;
        this.game = game;
        this.game.getMap().getGrid()[line][col].setWalkable(false);
        this.matricePoids = new int[game.getMap().getNbLine()][game.getMap().getNbCol()];
        for(int i = 0; i < matricePoids.length; i++)
        {
            for(int j = 0; j < matricePoids.length; j++)
            {
                this.matricePoids[i][j] = 10000;
            }
        }

        this.calculerMatricePoids(0, this.line, this.col);
    }

    /**
     * Fonction qui gère les deplacement des personnages
     * @param line la ligne ou l'on veut se deplacer
     * @param col la colonne ou l'on veut se deplacer
     * @return boolean deplacement effecttué
     */
    public boolean deplacer(int line, int col)
    {
        if(matricePoids[line][col] <= currentPM)
        {
            this.line = line;
            this.col = col;
            currentPM -= matricePoids[line][col];
            for(int i = 0; i < matricePoids.length; i++)
            {
                for(int j = 0; j < matricePoids.length; j++)
                {
                    this.matricePoids[i][j] = 10000;
                }
            }
            this.calculerMatricePoids(0, this.line, this.col);
            return  true;

        }
        for(int i = 0; i < matricePoids.length; i++)
        {
            for(int j = 0; j < matricePoids.length; j++)
            {
                this.matricePoids[i][j] = 10000;
            }
        }
        this.calculerMatricePoids(0, this.line, this.col);

        return false;
    }

    /**
     * Fonction qui renvoie le nombre de PM restant
     * @return currentPM les pm restant
     */
    public int getCurrentPM()
    {
        return this.currentPM;
    }

    /**
     * Fonction qui initie le début de tour en remettant a jours la matrice de coup, les PM et les statuts;
     */
    public void startTurn()
    {
        for(int i = 0; i < matricePoids.length; i++)
        {
            for(int j = 0; j < matricePoids.length; j++)
            {
                this.matricePoids[i][j] = 10000;
            }
        }
        this.calculerMatricePoids(0, this.line, this.col);
        this.currentPM = this.pm;
        this.isCurrent = true;
    }

    /**
     * Fonction qui termine le tour en remettant a jours les statuts
     */
    public void endTurn()
    {
        this.isCurrent = false;
    }

    public void addAction(String name, Action a)
    {
        this.powers.put(name, a);
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

    public boolean isCurrent()
    {
        return this.isCurrent;
    }

    /**
     * Fonction récursive qui calcul la matrice de poids (PathFinding
     * @param id le poids actuel
     * @param ligneSource  la ligne de l'entité dont l'on calcul le poids
     * @param colSource la colonne de l'entite dont l'on calcul le poids
     */
    private void calculerMatricePoids(int id, int ligneSource, int colSource)
    {
        matricePoids[ligneSource][colSource] = id;
        id += this.game.getMap().getCost(ligneSource, colSource);

        if(id <= this.pm)
        {
            if(ligneSource - 1 >= 0 && this.game.getMap().getGrid()[ligneSource - 1][colSource].isWalkable()
                    && matricePoids[ligneSource - 1][colSource] > id)
            {
                this.calculerMatricePoids(id, ligneSource - 1, colSource);
            }
            if(ligneSource + 1 < this.game.getMap().getNbLine() && this.game.getMap().getGrid()[ligneSource + 1][colSource].isWalkable()
                    && matricePoids[ligneSource + 1][colSource] > id)
                this.calculerMatricePoids(id, ligneSource + 1, colSource);
            if(colSource - 1 >= 0 && this.game.getMap().getGrid()[ligneSource][colSource - 1].isWalkable()
                    && matricePoids[ligneSource][colSource - 1] > id)
                this.calculerMatricePoids(id, ligneSource, colSource - 1);
            if(colSource + 1 < this.game.getMap().getNbCol() && this.game.getMap().getGrid()[ligneSource][colSource + 1].isWalkable()
                    && matricePoids[ligneSource][colSource + 1] > id)
                this.calculerMatricePoids(id, ligneSource, colSource + 1);
        }
    }

    public int[][] getMatricePoids()
    {
        return this.matricePoids;
    }

    public int attack(int dammage, Character target)
    {
        return dammage - target.defend();
    }

    private int defend()
    {
        return 0;
    }
}
