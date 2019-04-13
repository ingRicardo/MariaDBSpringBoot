package hello;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@Autowired
    DataSource dataSource;

    @Autowired
    private CustomerRepository customerRepository;
	
	
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("DATASOURCE = " + dataSource);
        
        List<Diabtype> list = customerRepository.findAll();

        list.forEach(x -> System.out.println("id -> "+ x.getId()+ " name -> "+ x.getName()));
        model.addAttribute("diabetes", list);
    	model.addAttribute("name", name);
        return "greeting";
    }

}
