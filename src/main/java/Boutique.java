
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daoma
 */
public class Boutique {
    public static void main(String...arg){
        System.out.println("Boutique App");
        
        Categorie c1 = new Categorie("conserve","Description conserve");
        Categorie c2 = new Categorie("Boisson","Description boisson");
        
        Produit p1 = new Produit("Sardine Princesse", 450.0, LocalDate.of(2022,1,1), c1);
        Produit p2 = new Produit("Djama", 500, LocalDate.of(2022,6,1), c2);
        Produit p3 = new Produit("Cocktail", 400, LocalDate.of(2022,6,1), c2);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("boutiquePU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        try {
            em.persist(c1);
            em.persist(c2);
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            
            Query query = em.createQuery("SELECT p FROM Produit p ORDER BY p.libelle");
            List<Produit> list  = query.getResultList();
            for (Produit produit : list) {
                System.out.println(produit);
            }
            
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
        
        emf.close();
    }
    
}
