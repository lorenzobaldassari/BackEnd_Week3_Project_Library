package Lorenzo_Baldassari.Entities.DAO;

import Lorenzo_Baldassari.Entities.TextObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class TextObjectDao {

    private final EntityManager em;

    public TextObjectDao(EntityManager em){
        this.em= em;
    }

    public void save(TextObject textObject){
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(textObject);
        transaction.commit();
        System.out.println("elemento "+ textObject.getTitle()+" salvato con successo");
    }

    public TextObject findById(long id){
        TextObject find= em.find(TextObject.class, id);
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
        TextObject textObject = findById(id);
        if (textObject !=null){
            transaction.begin();
            em.remove(textObject);
            transaction.commit();
            System.out.println("elemento "+textObject.getTitle() +" eliminato");
        }else{
            System.out.println("non esiste l'elemento");
        }
    }


}
