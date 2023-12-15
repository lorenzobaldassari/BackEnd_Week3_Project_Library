package Lorenzo_Baldassari;

import Lorenzo_Baldassari.Entities.*;
import Lorenzo_Baldassari.Entities.DAO.PrestitoDao;
import Lorenzo_Baldassari.Entities.DAO.TextObjectDao;
import Lorenzo_Baldassari.Entities.DAO.UtenteDao;
import Lorenzo_Baldassari.Entities.Enum.Genere;
import Lorenzo_Baldassari.Entities.Enum.Periodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("Project-Library");
    public static void main(String[] args) {

        //commento introduttivo per riccardo!
        //ciao! due parole sull'impostazione delle relazioni: ho utilizzato il oneToOne per collegare prestito a
        //libro perche oltre che dalla consegna richiede elemnto unico prestato ma perche ragionando ho trovato utile
        //associare ad una istanza di prestito un solo elemento piuttosto che una lista
        //mentre ho utilizzato un one to many per collegare utnete a prestito perche ho pensato che un utente puo fare
        //piu istanze di prestito
        //infine ho utilizzato TABLE PER CLASS per unire le entita in relazione perche mi interessava che ogni istanza di rivista
        // o libro mostrasse tutti i propri dati ,nascondendo la classe astratta TextObject per generarli; non ho usato
        //single table perche non volevo mostrare valori null

        //-----------START------------------

        EntityManager em =emf.createEntityManager();
        PrestitoDao prestDao= new PrestitoDao(em);
        UtenteDao uteDao= new UtenteDao(em);
        TextObjectDao objecDao= new TextObjectDao(em);

        Book spiderman= new Book("D1AS1-asda1sd","spiderman nella notte oscura",
                LocalDate.of(2001,5,20),
                600,"Marvel", Genere.FANTASCIENZA);
        Book wolverine= new Book("D1DAFA-snduja5","wolverine nella notte oscura",
                LocalDate.of(2005,8,10),
                1001,"Marvel", Genere.FANTASCIENZA);
        Magazine donnaModerna= new Magazine("D1DAFA-sndSDASDja5","DONNA MODERNA",
                LocalDate.of(2005,8,10),
                1001, Periodicita.GIORNALIERO);
        Utente gianni= new Utente("Gianni","Morandi",
                LocalDate.of(1980,7,10),"841161616516");
        Utente raiden= new Utente("Gianluca","Raiden",
                LocalDate.of(1986,7,18),"841841165151");

        Prestito rentByRaiden= new Prestito(LocalDate.now(),raiden,spiderman);
        Prestito rentByGianni= new Prestito(LocalDate.now(),gianni,donnaModerna);

//        uteDao.save(gianni);
//        uteDao.save(raiden);
//        objecDao.save(donnaModerna);
//        objecDao.save(wolverine);
//        objecDao.save(spiderman);
//        prestDao.save(rentByRaiden);
//        prestDao.save(rentByGianni);






        TextObject bookFromDb= objecDao.findById(110);
        Utente raidenFromdb=uteDao.findById(108);
        Prestito rentByRaidenFromDb= new Prestito(LocalDate.now(),raidenFromdb,bookFromDb);
        prestDao.save(rentByRaidenFromDb);




        System.out.println("funziona tutto, FINE!");
        em.close();
        emf.close();
    }
}
