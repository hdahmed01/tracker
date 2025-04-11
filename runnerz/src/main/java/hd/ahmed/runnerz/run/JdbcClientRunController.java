package hd.ahmed.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class JdbcClientRunController {

    private final JdbcClientRunRepositoryInMemory runRepository;
//    private final RunRepositoryInMemory runRepositoryInMemory;
//    @Autowired no need for it because we have only one constructor
    JdbcClientRunController(JdbcClientRunRepositoryInMemory runRepository) {
        this.runRepository = runRepository ;
//        this.runRepositoryInMemory = runRepositoryInMemory;
    }


    @GetMapping("")
    List<Run> findAll(){
        return runRepository.findAll() ;
    }

    @GetMapping("/{id}")
    Run findById( @PathVariable Integer id){
        Optional<Run> run =runRepository.findById(id) ;
        if(run.isEmpty()){
            throw  new RunNotFoundException();
//           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Run not found");
        }
        return run.get();
    }
    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody  Run run){
        runRepository.create(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run,id);
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }




/*  @RequestMapping(path="/hello", method= RequestMethod.GET)
    @GetMapping("/hello")
    String home(){
        return "hello runners";}*/
}
