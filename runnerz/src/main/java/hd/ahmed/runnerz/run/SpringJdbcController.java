package hd.ahmed.runnerz.run;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api2/runs")
public class SpringJdbcController {

    private final RunRepository runRepository;
    private final Logger logger= LoggerFactory.getLogger(SpringJdbcController.class);
    public SpringJdbcController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        logger.info("spring jdbc function");
        return runRepository.findAll();

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
        runRepository.save(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateRun(@PathVariable Integer id, @Valid @RequestBody Run updatedRun) {
        if (!runRepository.existsById(id)) {
            logger.error("run not found");
        }

        // Ensure the ID in the URL matches the ID in the provided object
        Run runToSave = new Run(id, updatedRun.title(), updatedRun.startedOn(),
                updatedRun.completedOn(), updatedRun.miles(),
                updatedRun.location(), updatedRun.version());

        runRepository.save(runToSave); // Update the existing record
    }


    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(runRepository.findById(id).get());
    }

    @GetMapping("/loc/{location}")
    List<Run> findByLocation(@PathVariable String location){
        return runRepository.findAllByLocation(location);
    }


}
