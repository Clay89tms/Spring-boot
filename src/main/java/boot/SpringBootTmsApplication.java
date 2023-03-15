package boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTmsApplication implements CommandLineRunner {

//    @Autowired
//    private BookService service;

//    @Bean
//    DataSource dataSource(){
//        return new DriverManagerDataSource();
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTmsApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");
    }
}
