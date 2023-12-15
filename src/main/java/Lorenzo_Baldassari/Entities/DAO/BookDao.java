package Lorenzo_Baldassari.Entities.DAO;

import Lorenzo_Baldassari.Entities.Book;
import Lorenzo_Baldassari.Entities.TextObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class BookDao {


    private final EntityManager em;
    public BookDao(EntityManager em){this.em=em;}

    public void findByWriter(String writer){
        Query getELementByIWriter= em.createQuery("SELECT b FROM Book b WHERE b.autore =:writer", Book.class);
        getELementByIWriter.setParameter("writer",writer);
        List<Book> elementsToFind= getELementByIWriter.getResultList();
        if (elementsToFind.size()>0){
            System.out.println("elemento trovato"+elementsToFind);
            elementsToFind.forEach(elem->System.out.println(elem));

        }else{
            System.out.println("autore non trovato");
        }
    }



}
