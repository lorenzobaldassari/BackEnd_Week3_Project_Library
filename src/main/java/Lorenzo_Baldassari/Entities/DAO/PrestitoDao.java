package Lorenzo_Baldassari.Entities.DAO;

import Lorenzo_Baldassari.Entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PrestitoDao {
    private final EntityManager em;

    public PrestitoDao(EntityManager em){
        this.em= em;
    }

    public void save(Prestito prestito){
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("il prestito con id  "+ prestito.getId()+" salvato con successo");
    }

    public Prestito findById(long id){
        Prestito find= em.find(Prestito.class, id);
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
        Prestito prestito = findById(id);
        if (prestito !=null){
            transaction.begin();
            em.remove(prestito);
            transaction.commit();
            System.out.println("elemento "+prestito.getId() +" eliminato");
        }else{
            System.out.println("non esiste l'elemento");
        }
    }


}
