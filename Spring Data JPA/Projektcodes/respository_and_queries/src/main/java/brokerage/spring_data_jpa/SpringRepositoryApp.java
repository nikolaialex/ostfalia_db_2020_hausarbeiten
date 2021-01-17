package brokerage.spring_data_jpa;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import brokerage.model.Stock;
import brokerage.spring_data_jpa.StockRepository;


@SpringBootApplication
@EntityScan("brokerage.*") 
public class SpringRepositoryApp {

  private static final Logger log = LoggerFactory.getLogger(SpringRepositoryApp.class);

  public static void main(String[] args) {
    SpringApplication.run(SpringRepositoryApp.class);
  }

  @Bean
  public CommandLineRunner demonstrateRepositoryMethods(StockRepository repository) {
    return (args) -> {
    	repository.save(new Stock("Infineon", "623100"));
    	Stock stock1 = repository.findByCompanyName("Infineon");
        stock1.setCompanyName("Royal Dutch");
        stock1.setWkn( "A0ER6S");
        repository.save(stock1);
        repository.save(new Stock("Deutsche Bank", "514000"));
        repository.delete(repository.findByCompanyName("Deutsche Bank"));
        repository.findAll().forEach(stock -> System.out.println("Stockname:"+stock.getCompanyName()+ ", WKN: " + stock.getWkn()));
        if(repository.findByWkn("A0ER6S")!=null) {
        	System.out.println("CompanyName gefunden über WKN-Suche: " + repository.findByWkn("A0ER6S").getCompanyName());
        }
    };
  }

}