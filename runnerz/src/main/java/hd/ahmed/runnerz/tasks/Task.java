package hd.ahmed.runnerz.tasks;

public record Task(
        Integer id,
        String text,
        String day,
        Boolean reminder
        ) {
}
