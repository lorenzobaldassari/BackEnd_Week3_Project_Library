package Lorenzo_Baldassari.Entities;

import Lorenzo_Baldassari.Entities.Enum.Periodicita;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("rivista")
public class Magazine extends TextObject {

    @Enumerated(EnumType.STRING)
    protected Periodicita periodicita;


    public Magazine(String ISBNcode, String title, LocalDate relaseDate, int numberOfPAge, Periodicita periodicita) {
        super(ISBNcode, title, relaseDate, numberOfPAge);
        this.periodicita = periodicita;
    }

    public Magazine() {
    }

    public Magazine(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicita=" + periodicita +
                ", id=" + id +
                ", ISBNcode='" + ISBNcode + '\'' +
                ", title='" + title + '\'' +
                ", relaseDate='" + relaseDate + '\'' +
                ", numberOfPAge=" + numberOfPAge +
                '}';
    }
}
