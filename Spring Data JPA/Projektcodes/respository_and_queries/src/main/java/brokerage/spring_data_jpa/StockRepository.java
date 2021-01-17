package brokerage.spring_data_jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import brokerage.model.Stock;



/**
 * This interface extends the database-operations for the Entity-Class Stock
 * @author Volkan
 *
 */
@Repository
@Service
public interface StockRepository extends JpaRepository<Stock, Long>{

	Stock findByWkn(String wkn);
	Stock findByCompanyName(String companyName);
}
