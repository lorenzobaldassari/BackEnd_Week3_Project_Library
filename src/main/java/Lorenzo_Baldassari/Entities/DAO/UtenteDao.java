package Lorenzo_Baldassari.Entities.DAO;

import Lorenzo_Baldassari.Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UtenteDao {
    private final EntityManager em;

    public UtenteDao(EntityManager em){
        this.em= em;
    }

    public void save(Utente utente){
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("elemento "+ utente.getName()+" salvato con successo");
    }

    public Utente findById(long id){
        Utente find= em.find(Utente.class, id);
        if (find!=null){
            System.out.println("elemento trovato "+find );
            return find;
        }else{
            System.out.println("id non trovato");
            return null;
        }
    }

    public void findByIdAndDelete(long id){

        EntityTransaction transaction=em.getTransaction();
        Utente utente = findById(id);
        if (utente !=null){
            transaction.begin();
            em.remove(utente);
            transaction.commit();
            System.out.println("elemento "+utente.getName() +" eliminato");
        }else{
            System.out.println("non esiste l'elemento");
        }
    }


}
