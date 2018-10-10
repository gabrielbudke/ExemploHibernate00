
import bean.Aluno;
import bean.Sistema;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Gabriel Budke
 */
public class Principal {

    public static void main(String[] args) {

        
        Configuration conf = new Configuration();
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        SessionFactory factory = new Configuration().buildSessionFactory(sr);

        Transaction transaction = null;
        try {
            Session session = factory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            
            //'Save'  armazena informação no banco
            /*Sistema sistemaDoKleiton = new Sistema();
            sistemaDoKleiton.setNome("Kleyton");
            sistemaDoKleiton.setId(1);
            session.save(sistemaDoKleiton);*/
            
            //'Update' altera informação no banco
            /*Sistema sistemaDoKleiton = new Sistema();
            sistemaDoKleiton.setNome("Kleyton");
            sistemaDoKleiton.setId(1);
            session.update(sistemaDoKleiton);*/
           
            /* Obter todos 
            List resultdados = session.createQuery("from Sistema").list();
            for (Sistema sistema : (List<Sistema>)resultdados) {
                System.out.println(sistema.getNome()); 
            }
            */
            
            /* 'Remove' remove informação no banco
            Sistema sistema = new Sistema();
            sistema.setId(1);
            session.remove(sistema);
            */
            
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();

            }
        }finally{
            factory.close();
        }

    }
}
