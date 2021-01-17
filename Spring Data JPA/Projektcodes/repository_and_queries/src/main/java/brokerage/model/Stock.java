package brokerage.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable {
    
 
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    /**
     * wkn Wertpapierkennnummer
     */
	private String wkn; 
	private String companyName; 
	
	public Stock(){
		
	};
	
	public Stock(String companyName, String wkn) {
		this.companyName = companyName; 
		this .wkn = wkn;
	}

	public String getWkn() {
		return wkn;
	}

	public void setWkn(String wkn) {
		this.wkn = wkn;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}