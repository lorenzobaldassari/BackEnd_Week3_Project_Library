package Lorenzo_Baldassari.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="oggetto_estuale")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="tipo_oggetto_testuale")

public abstract class TextObject {

    @Id
    @GeneratedValue
    protected long id;
    @Column(name="codice_ISBN",unique = true)
    protected String ISBNcode;
    @Column(name="titolo")
    protected  String title;
    @Column(name="anno_di_pubblicazione")
    protected LocalDate relaseDate;
    @Column(name="numero_di_pagine")
    protected int numberOfPAge;

    @OneToOne(mappedBy = "object")
    private Prestito prestito;

    public TextObject(String ISBNcode, String title, LocalDate relaseDate, int numberOfPAge) {
        this.ISBNcode = ISBNcode;
        this.title = title;
        this.relaseDate = relaseDate;
        this.numberOfPAge = numberOfPAge;
    }

    public TextObject() {
    }

    public String getISBNcode() {
        return ISBNcode;
    }

    public void setISBNcode(String ISBNcode) {
        this.ISBNcode = ISBNcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(LocalDate relaseDate) {
        this.relaseDate = relaseDate;
    }

    public int getNumberOfPAge() {
        return numberOfPAge;
    }

    public void setNumberOfPAge(int numberOfPAge) {
        this.numberOfPAge = numberOfPAge;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TextObject{" +
                "id=" + id +
                ", ISBNcode='" + ISBNcode + '\'' +
                ", title='" + title + '\'' +
                ", relaseDate='" + relaseDate + '\'' +
                ", numberOfPAge=" + numberOfPAge +
                '}';
    }
}
