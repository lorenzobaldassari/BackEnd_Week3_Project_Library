package Lorenzo_Baldassari;

import Lorenzo_Baldassari.Entities.*;
import Lorenzo_Baldassari.Entities.DAO.BookDao;
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
        //libro perche dalla consegna ho capito richiere un solo elemento prestato ma perche ragionando ho trovato utile
        //associare ad una istanza di prestito un solo elemento piuttosto che una lista; premetto che avevo inizialmente
        //impostato per essere una lista di elementi per presito semplicemnte sostituendo TextObject con List<TextObject>
        //e cambiando la relazione in many to one (nelle operazioni commentate utilizzate per creare il database puoi
        // trovare ancora le liste create inizalmente che non cancello volutamente)

        //mentre ho utilizzato un one to many per collegare utnete a prestito perche ho pensato che un utente puo fare
        //piu istanze di prestito
        //infine ho utilizzato TABLE PER CLASS per unire le entita in relazione perche mi interessava che ogni istanza di rivista
        // o libro mostrasse tutti i propri dati ,nascondendo la classe astratta TextObject per generarli; non ho usato
        //single table perche non volevo mostrare valori null

        //le operazioni richieste si trovano in fondo prima del "hello world"

        //-----------START------------------

        EntityManager em =emf.createEntityManager();
        PrestitoDao prestDao= new PrestitoDao(em);
        UtenteDao uteDao= new UtenteDao(em);
        TextObjectDao objecDao= new TextObjectDao(em);
        BookDao bookDao= new BookDao(em);

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

        //----------------------------------------------
        //sezione liste che ho deciso di non utilizzare cambianso in una relazione on to one
//        List<TextObject> raidenRentList= new ArrayList<>();
//        List<TextObject> gianniRentList= new ArrayList<>();
//
//        raidenRentList.add(wolverine);
//        raidenRentList.add(spiderman);
//        gianniRentList.add(donnaModerna);
//        --------------------------------------------------------------------


        Prestito rentByRaiden= new Prestito(LocalDate.now(),raiden,spiderman);
        Prestito rentByGianni= new Prestito(LocalDate.now(),gianni,donnaModerna);
//        rentByGianni.setRentEffectiveEndDate(LocalDate.of(2025,12,25));

//        uteDao.save(gianni);
//        uteDao.save(raiden);
//        objecDao.save(donnaModerna);
//        objecDao.save(wolverine);
//        objecDao.save(spiderman);
//        prestDao.save(rentByRaiden);
//        prestDao.save(rentByGianni);
//
//        Utente raidenFromdb=uteDao.findById(137);
//        TextObject bookFromDb= objecDao.findById(140);
//        Prestito rentByRaidenFromDb= new Prestito(LocalDate.now(),raidenFromdb,bookFromDb);
//        prestDao.save(rentByRaidenFromDb);



//        OPERAZIONI DELLA CONSEGNA-----------------i codici sono nei rispettivi Dao


//       1) aggiunta elemento al catalogo

//        objecDao.save(spiderman);

//        2)rimozione elemento dal catalogo

//        objecDao.findByISBNAndDelete("D1DAFA-snduja5");

//        3) ricerca per ISBN

//        objecDao.findByISBN("D1DAFA-sndSDASDja5");

//        4)ricerca per anno di pubblicazione

//            objecDao.findByRelaseYear(2005);

//        5) ricerca per autore

//        bookDao.findByWriter("Marvel");

//        6) ricerca per titolo o parte di esso

//        objecDao.findByPartialTitle("spi");

//        7)ricerca per numero di tessera se ci sono libri in presito

//        prestDao.findByCardNumberFromRented("841161616516");

//        8)Ricerca prestiti scaduti non ancora restituiti

//        prestDao.findByOutOfDateRent();


        System.out.println("funziona tutto, FINE!");
        em.close();
        emf.close();
    }
}
