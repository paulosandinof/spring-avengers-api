package com.sandino.avengers.resource.avenger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sandino.avengers.domain.avenger.Avenger;

@Entity
@Table(name = "avenger")
public class AvengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nick;

    @Column(nullable = false)
    private String person;

    @Column
    private String description;

    @Column
    private String history;

    public static AvengerEntity from(Avenger avenger) {
        return new AvengerEntity(avenger.getId(), avenger.getNick(), avenger.getPerson(), avenger.getDescription(),
                avenger.getHistory());
    }

    public Avenger toAvenger() {
        return new Avenger(id, nick, person, description, history);
    }

    public AvengerEntity() {
    }

    public AvengerEntity(long id, String nick, String person, String description, String history) {
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
        return "AvengerEntitity [description=" + description + ", history=" + history + ", id=" + id + ", nick=" + nick
                + ", person=" + person + "]";
    }
}
