package com.sandino.avengers.application.web.resource.response;

import com.sandino.avengers.domain.avenger.Avenger;

public class AvengerResponse {
    private long id;
    private String nick;
    private String person;
    private String description;
    private String history;

    public AvengerResponse() {
    }

    public AvengerResponse(long id, String nick, String person, String description, String history) {
        this.id = id;
        this.nick = nick;
        this.person = person;
        this.description = description;
        this.history = history;
    }

    public static AvengerResponse from(Avenger avenger) {
        return new AvengerResponse(avenger.getId(), avenger.getNick(), avenger.getPerson(), avenger.getDescription(),
                avenger.getHistory());
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
        return "AvengerResponse [description=" + description + ", history=" + history + ", id=" + id + ", nick=" + nick
                + ", person=" + person + "]";
    }
}