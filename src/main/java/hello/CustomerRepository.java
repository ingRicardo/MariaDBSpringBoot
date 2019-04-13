/**
 * 
 */
package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author alfredo
 *
 */
@Repository
public class CustomerRepository {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Diabtype> findAll() {

        List<Diabtype> result = jdbcTemplate.query(
                "SELECT id, name FROM diabetestype",
                (rs, rowNum) -> new Diabtype(rs.getInt("id"),
                        rs.getString("name"))
        );

        return result;

    }

}
