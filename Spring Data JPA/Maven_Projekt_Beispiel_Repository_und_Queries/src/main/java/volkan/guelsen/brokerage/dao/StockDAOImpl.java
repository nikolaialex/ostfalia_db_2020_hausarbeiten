package volkan.guelsen.brokerage.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.web.bind.annotation.PathVariable;

import volkan.guelsen.brokerage.model.Stock;

public class StockDAOImpl implements StockDAO<Stock> {
    
    private EntityManager em;
    
    // standard constructors
    
    public  StockDAOImpl() {
		// TODO Auto-generated constructor stub
    	EntityManagerFactory emfactory = Persistence.
    		      createEntityManagerFactory( "myJPA" );
    		      em = emfactory.
    		      createEntityManager( );
	}
    
    @Override
    public Stock get(long id) {
        return em.find(Stock.class, id);
    }
    
    @Override
    public List<Stock> getAll() {
        Query query = em.createQuery("SELECT a FROM Stock a");
        return query.getResultList();
    }
    
    @Override
    public void save(Stock stock) {
        execute(em -> em.persist(stock));
    }
    
    @Override
    public void update(Stock stock) {
        execute(em -> em.merge(stock));
    }
    
    @Override 
    public void delete(Stock stock) {
        execute(em -> em.remove(stock));
    }
    
	@Override
	public List<Stock> findByWkn(@PathVariable("wkn") String wkn) {
		 Query query = em.createQuery("SELECT c FROM Stock c WHERE c.wkn='"+wkn+"'");
		 List<Stock> list =query.getResultList();
	     return list;
	}

	@Override
	public List<Stock> findByCompanyName(String companyName) {
		Query query = em.createQuery("SELECT c FROM Stock c WHERE c.companyName='"+companyName+"'");
		List<Stock> list =query.getResultList();
		return list;
	}
	
    private void execute(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit(); 
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
