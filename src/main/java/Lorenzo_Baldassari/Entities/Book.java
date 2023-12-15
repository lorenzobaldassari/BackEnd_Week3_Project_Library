package Lorenzo_Baldassari.Entities;

import Lorenzo_Baldassari.Entities.Enum.Genere;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("libro")
public class Book extends TextObject{

    protected String autore;

    @Enumerated(EnumType.STRING)
    protected Genere genere;

    public Book(String ISBNcode, String title, LocalDate relaseDate, int numberOfPAge, String autore, Genere genere) {
        super(ISBNcode, title, relaseDate, numberOfPAge);
        this.autore = autore;
        this.genere = genere;
    }

    public Book() {
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                ", id=" + id +
                ", ISBNcode='" + ISBNcode + '\'' +
                ", title='" + title + '\'' +
                ", relaseDate='" + relaseDate + '\'' +
                ", numberOfPAge=" + numberOfPAge +
                '}';
    }
}
