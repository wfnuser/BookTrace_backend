package booktrace;

/**
 * Created by wfnuser on 16/12/24.
 */

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userrepository;
    @Autowired
    private BookRepository bookrepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userrepository.deleteAll();
        bookrepository.deleteAll();

        // save a couple of customers
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("tall super is awesome", "ts1"));
        comments.add(new Comment("tall super is awesome", "ts2"));
        comments.add(new Comment("tall super is awesome", "ts3"));
        userrepository.save(new User("Alice", "123123"));
        userrepository.save(new User("Bob", "123123"));
        bookrepository.save(new Book("高超", new Author("高超","中国"), "高超高超高超", comments, 9.9));
        bookrepository.save(new Book("另一个高超", new Author("高超2","中国"), "6666666", comments, 9.9));

//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (Customer customer : repository.findAll()) {
//            System.out.println(customer);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("Alice"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Customer customer : repository.findByLastName("Smith")) {
//            System.out.println(customer);
//        }

    }

}