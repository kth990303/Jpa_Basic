package jpabook.jpashop;

import javassist.compiler.ast.Member;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em=emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Book book=new Book();
            book.setName("JPA");
            book.setAuthor("kth990303");
            book.setCreatedBy("kth990303");
            book.setPrice(20000);
            book.setIsbn("123-456");
            book.setCreatedDate(LocalDateTime.now());

            em.persist(book);

            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
