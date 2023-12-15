package Lorenzo_Baldassari.Entities;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue
    private  long id;

    @Column(name = "data_inizio_presito")
    private LocalDate rentStartDate;
    @Column(name = "data_fine_prestito_prevista")
    private LocalDate rentAssumedEndDate;
    @Column(name = "data_fine_prestito_effettiva") //non da inserire ma solo modificabile
    //tramite setter
    private LocalDate rentEffectiveEndDate;

    @ManyToOne
//    (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Utente utente;

    @OneToOne
//            (cascade = CascadeType.ALL)
    @JoinColumn(name = "prestito_id",unique = true)
    private TextObject object;


    public Prestito(LocalDate rentStartDate, Utente utente,TextObject rentedObjects) {
        this.rentStartDate = rentStartDate;
        this.rentAssumedEndDate = rentStartDate.plusDays(30);
        this.utente = utente;
        this.object = rentedObjects;
    }

    public Prestito() {
    }

    public long getId() {
        return id;
    }

    public LocalDate getRentStartDate() {
        return rentStartDate;
    }

    public LocalDate getRentAssumedEndDate() {
        return rentAssumedEndDate;
    }

    public LocalDate getRentEffectiveEndDate() {
        return rentEffectiveEndDate;
    }

    public Utente getUtente() {
        return utente;
    }

    public TextObject getRentedObjects() {
        return object;
    }


    public void setRentStartDate(LocalDate rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public void setRentAssumedEndDate(LocalDate rentAssumedEndDate) {
        this.rentAssumedEndDate = rentAssumedEndDate;
    }

    public void setRentEffectiveEndDate(LocalDate rentEffectiveEndDate) {
        this.rentEffectiveEndDate = rentEffectiveEndDate;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setRentedObjects(TextObject rentedObjects) {
        this.object = rentedObjects;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", rentStartDate=" + rentStartDate +
                ", rentAssumedEndDate=" + rentAssumedEndDate +
                ", rentEffectiveEndDate=" + rentEffectiveEndDate +
                ", utente=" + utente +
                ", rentedObjects=" + object +
                '}';
    }
}
