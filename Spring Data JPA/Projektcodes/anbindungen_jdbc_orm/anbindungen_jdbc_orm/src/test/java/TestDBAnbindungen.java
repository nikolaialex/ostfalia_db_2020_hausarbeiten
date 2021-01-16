import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class TestDBAnbindungen {

    Logger log = Logger.getLogger(this.getClass().getName());

    @Test
    public void testJDBC() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/miniwelt_hochschule",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Suchbegriff: ");
            String userinput = "%" + br.readLine() + "%";

            String query = "SELECT * FROM sportgeraete where bezeichnung like ? and anschaffungsdatum >'1999-12-31'";
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setString(1, userinput);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int matrnr = rs.getInt("matrnr");
                String name = rs.getString("name");
                System.out.println("MatrNr = " + matrnr);
                System.out.println("Name = " + name);
                System.out.println("\n");
            }
            rs.close();
            pstmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    @Test
    public void testHibernate() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miniwelt_hochschule");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Studi> criteria = cb.createQuery(Studi.class);
        Root<Studi> root = criteria.from(Studi.class);
        criteria.where(cb.equal(root.get("name"), "Meier"));
        List<Studi> topics = em.createQuery(criteria).getResultList();

        em.getTransaction().commit();
        em.close();
        emf.close();
    }


}
