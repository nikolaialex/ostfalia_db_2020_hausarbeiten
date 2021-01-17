package brokerage.dao;

import java.util.List;
import java.util.Optional;

import brokerage.model.Stock;

public class DAOApp {

    private static StockDAO<Stock> jpaStockDao = new StockDAOImpl();
 
    public static void main(String[] args) {
    	
    	jpaStockDao.save(new Stock("Infineon", "623100"));
    	Stock stock1 = jpaStockDao.findByCompanyName("Infineon").get(0);
        System.out.println(stock1);
        stock1.setCompanyName("Royal Dutch");
        stock1.setWkn( "A0ER6S");
        jpaStockDao.update(stock1);
        jpaStockDao.save(new Stock("Deutsche Bank", "514000"));
        jpaStockDao.delete(jpaStockDao.get(2));
        jpaStockDao.getAll().forEach(stock -> System.out.println("Stockname:"+stock.getCompanyName()+ ", WKN: " + stock.getWkn()));
        if(jpaStockDao.findByWkn("A0ER6S").size()>0) {
        	System.out.println("CompanyName gefunden über WKN-Suche: " + jpaStockDao.findByWkn("A0ER6S").get(0).getCompanyName());
        }
    }
}
