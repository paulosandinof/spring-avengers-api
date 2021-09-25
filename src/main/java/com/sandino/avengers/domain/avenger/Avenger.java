package com.sandino.avengers.domain.avenger;

public class Avenger {

    private long id;

    private String nick;

    private String person;

    private String description;

    private String history;

    public Avenger() {
    }

    public Avenger(String nick, String person, String description, String history) {
        this.nick = nick;
        this.person = person;
        this.description = description;
        this.history = history;
    }

    public Avenger(long id, String nick, String person, String description, String history) {
        this.id = id;
        this.nick = nick;
        this.person = person;
        this.description = description;
        this.history = history;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Avenger [description=" + description + ", history=" + history + ", id=" + id + ", nick=" + nick
                + ", person=" + person + "]";
    }
}
