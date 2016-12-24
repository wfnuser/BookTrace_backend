package booktrace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wfnuser on 16/12/24.
 */

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    @RequestMapping("/search")
    public Book search(@RequestParam(value="title") String title) {
        return  repository.findByTitleLike(title);
    }


}
