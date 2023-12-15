package Lorenzo_Baldassari.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "cognome")
    private String lastname;

    @Column(name = "data_di_nascita")
    private LocalDate dateOfBirth;

    @Column(name = "numero_di_tessera",unique = true)
    private String cardNumber;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> rentedList;

    public Utente(String name, String lastname, LocalDate dateOfBirth, String cardNumber) {
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
    }

    public Utente() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
