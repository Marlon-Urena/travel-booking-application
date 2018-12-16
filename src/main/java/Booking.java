import java.util.List;

public abstract class Booking {
    protected String apiKey = "JDyCGQgGGU0GMzHNY8ck0b7vtZLwgpuz";
    public abstract void receiveRequest(Estimate estimate, Schedule schedule);
    public abstract List<Object> provideOptions(List<String> list); //Think about return type for this

}

