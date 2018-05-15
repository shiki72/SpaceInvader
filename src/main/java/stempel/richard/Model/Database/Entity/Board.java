package stempel.richard.Model.Database.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ScoreBoard")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "SCORE")
    private int score;

    /**The constructor of the {@code Board} with no parameter.*/
    public Board()
    {
        id = 0;
        name="";
        score=0;
    }

    /**The constructor of the {@code Board}
     *
     * @param id is the player's id
     * @param name is the player's name.
     * @param score is the player's time score.*/
    public Board(Integer id, String name, int score)
    {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    /**@return the name of the player.*/
    public String getName()
    {
        return name;
    }

    /**@return the player's score.*/
    public int getScore()
    {
        return score;
    }

    /**@return the player's id.*/
    public int getId() {
        return id;
    }

    /**@param n will be set to the player's name.*/
    public void setName(String n) {
        this.name = n;
    }

    /**@param s will be set to the player's score.*/
    public void setScore(int s) {
        this.score=s;
    }

    /**@param id will be set to the player's id.*/
    public void setId(Integer id) {
        this.id = id;
    }

    /**this will override the toString method of the {@code Object} class.*/
    @Override
    public String toString()
    {
        return "Player: " + this.id + ", " + this.name + ", " + this.score;
    }

}