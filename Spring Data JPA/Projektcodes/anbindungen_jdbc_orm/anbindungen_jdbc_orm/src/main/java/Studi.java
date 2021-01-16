import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "studi")
public class Studi {

    @Id
    @Column(name = "matrnr", updatable = false, nullable = false)
    private int matrnr;

    @Column(name = "name", updatable = false, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Studi() {
    }

    public Studi(int matrnr) {
        this.matrnr = matrnr;
    }

    public int getMatrnr() {
        return matrnr;
    }

    public void setMatrnr(int matrnr) {
        this.matrnr = matrnr;
    }
}
