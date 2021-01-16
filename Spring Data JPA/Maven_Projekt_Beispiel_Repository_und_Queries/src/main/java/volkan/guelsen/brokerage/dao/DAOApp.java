package volkan.guelsen.brokerage.dao;

import java.util.List;
import java.util.Optional;

import volkan.guelsen.brokerage.model.Stock;

public class DAOApp {

    private static StockDAO<Stock> jpaStockDao = new StockDAOImpl();
 
    public static void main(String[] args) {
    	
    	jpaStockDao.save(new Stock("Infineon", "623100"));
    	Stock stock1 = jpaStockDao.findByCompanyName("Infineon").get(0);
        System.out.println(stock1);
        stock1.setCompanyName("Royal Dutch");
        stock1.setWkn( "A01ESR");
        jpaStockDao.update(stock1);
        jpaStockDao.save(new Stock("Deutsche Bank", "514000"));
        jpaStockDao.delete(jpaStockDao.get(2));
        jpaStockDao.getAll().forEach(stock -> System.out.println("Stockname:"+stock.getCompanyName()+ ", WKN: " + stock.getWkn()));
        if(jpaStockDao.findByWkn("A01ESR1").size()>0) {
        	System.out.println("CompanyName gefunden durch WKN-Suche: " + jpaStockDao.findByWkn("A01ESR").get(0).getCompanyName());
        }
    }
}
