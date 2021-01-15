package volkan.guelsen.brokerage.dao;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("hiding")
public interface StockDAO<Stock> {

    Stock get(long id);

    List<Stock> getAll();

    void save(Stock t);

    void update(Stock t);

    void delete(Stock t);
    
    List<Stock> findByCompanyName(String companyName);
    
    List<Stock> findByWkn(String wkn);
}
