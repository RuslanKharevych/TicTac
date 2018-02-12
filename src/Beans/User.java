package Beans;

public class User {

    private int id;
    private String name;
    private int victories;
    private int losses;

    public User(int id, String name, int victories, int losses) {
        this.id = id;
        this.name = name;
        this.victories = victories;
        this.losses = losses;
    }

    public User() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
