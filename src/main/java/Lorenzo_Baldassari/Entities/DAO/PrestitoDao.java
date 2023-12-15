package Lorenzo_Baldassari.Entities.DAO;

import Lorenzo_Baldassari.Entities.Book;
import Lorenzo_Baldassari.Entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
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

    public void findByCardNumberFromRented(String cardNumber){
        Query getELementsQuery= em.createQuery("SELECT p FROM Prestito p WHERE p.utente.cardNumber =:cardNumber", Prestito.class);
        getELementsQuery.setParameter("cardNumber",cardNumber);
        List<Prestito> elements= getELementsQuery.getResultList();
        if (elements.size()>0){

            elements.forEach(elem->{
                if(elem.getRentEffectiveEndDate() !=null){
                    System.out.println("OGGETTO "+elem);
                }
            });

        }else{
            System.out.println("non ci sono elementi associati alla tessere");
        }
    }
    public void findByOutOfDateRent(){
        Query getELementsQuery= em.createQuery("SELECT p FROM Prestito p", Prestito.class);
        List<Prestito> elements= getELementsQuery.getResultList();
        if (elements.size()>0){

            elements.forEach(elem->{
                if(elem.getRentEffectiveEndDate()==null || elem.getRentEffectiveEndDate().isBefore(LocalDate.now())){
                    System.out.println("la data di riconsegna di "+elem+ " e' Scaduta! avvisare il cliente");
                }
            });

        }else{
            System.out.println("non ci sono ancora elementi nel database! aggiungene uno!");
        }
    }


}
