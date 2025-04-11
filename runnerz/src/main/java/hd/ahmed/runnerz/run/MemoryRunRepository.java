package hd.ahmed.runnerz.run;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryRunRepository {

    private List<Run> runs=new  ArrayList<>() ;
    public List<Run> findAll() {
        return runs;
    }
//    @PostConstruct //this method get called after the injection of the class
//    private void init() {
//        runs.add(new Run(1,
//                "monday",
//                LocalDateTime.now(),
//                LocalDateTime.now().plusHours(1),
//                5,
//                Location.INDOOR))  ;
//        runs.add(new Run(2,
//                "tuesday",
//                LocalDateTime.now(),
//                LocalDateTime.now().plusHours(1),
//                10,
//                Location.OUTDOOR))  ;
//
//    }
    Optional<Run>  findById(Integer  id) {
        return this.runs.stream().filter(run ->run.id()==id ).findFirst() ;
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run,Integer id) {
        Optional<Run>  findRun = this.findById(id);
        findRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
//        if(findRun.isPresent()) {
//            runs.set(runs.indexOf(findRun.get()),run);
//        }
    }

    void delete(Integer id) {
        runs.removeIf((run ->run.id().equals(id)));
    }

}
