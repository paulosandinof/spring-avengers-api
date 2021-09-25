package com.sandino.avengers.application.web.resource.request;

import javax.validation.constraints.NotBlank;

import com.sandino.avengers.domain.avenger.Avenger;

public class AvengerRequest {

    @NotBlank
    private String nick;

    @NotBlank
    private String person;

    private String description;

    private String history;

    public static Avenger toAvenger(long id, AvengerRequest request) {
        return new Avenger(id, request.getNick(), request.getPerson(), request.getDescription(), request.getHistory());
    }

    public Avenger toAvenger() {
        return new Avenger(nick, person, description, history);
    }

    public AvengerRequest() {
    }

    public AvengerRequest(String nick, String person, String description, String history) {
        this.nick = nick;
        this.person = person;
        this.description = description;
        this.history = history;
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
        return "AvengerRequest{" + "nick='" + nick + '\'' + ", person='" + person + '\'' + ", description='"
                + description + '\'' + ", history='" + history + '\'' + '}';
    }
}
