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
    public void findByISBNAndDelete(String ISBN){

        EntityTransaction transaction=em.getTransaction();
        Query getELementByISBNN= em.createQuery("SELECT t FROM TextObject t WHERE t.ISBNcode =:ISBN",TextObject.class);
            getELementByISBNN.setParameter("ISBN",ISBN);
        List<TextObject> elementsToRemove= getELementByISBNN.getResultList();
        if (elementsToRemove.size()>0){
            transaction.begin();
            elementsToRemove.forEach(elem->em.remove(elem));
            transaction.commit();
            System.out.println("elemento "+elementsToRemove +" eliminato");
        }else{
            System.out.println("non esiste l'elemento");
        }
    }
    public void findByISBN(String ISBN){
        Query getELementByISBNN= em.createQuery("SELECT t FROM TextObject t WHERE t.ISBNcode =:ISBN",TextObject.class);
        getELementByISBNN.setParameter("ISBN",ISBN);
        List<TextObject> elementsToFind= getELementByISBNN.getResultList();
        if (elementsToFind.size()>0){
            System.out.println("elemento trovato");
            elementsToFind.forEach(elem->System.out.println(elem));
        }else{
            System.out.println("ISBN non trovato");
        }
    }

    public void findByPartialTitle(String title){
        Query getELementByISBNN= em.createQuery("SELECT t FROM TextObject t WHERE t.title LIKE :title",TextObject.class);
        getELementByISBNN.setParameter("title","%"+title+"%");
        List<TextObject> elementsToFind= getELementByISBNN.getResultList();
        if (elementsToFind.size()>0){
            System.out.println("elemento trovato");
            elementsToFind.forEach(elem->System.out.println(elem));
        }else{
            System.out.println("titolo non trovato");
        }
    }





}
