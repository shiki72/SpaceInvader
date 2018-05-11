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

    public Board()
    {
        id = 0;
        name="";
        score=0;
    }

    public Board(Integer id, String name, int score)
    {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    public int getId() {
        return id;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setScore(int s) {
        this.score=s;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //@Override
    public String toString()
    {
        return "Player: " + this.id + ", " + this.name + ", " + this.score;
    }

}