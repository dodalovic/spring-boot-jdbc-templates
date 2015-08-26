package demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/person")
    public
    @ResponseBody
    Person dailyStats(@RequestParam Integer id) {
        String query = "SELECT first_name, last_name, age" +
                " from person where person.id = " + id;

        return jdbcTemplate.queryForObject(query, (resultSet, i) -> {
            return new Person(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
        });

    }


}
