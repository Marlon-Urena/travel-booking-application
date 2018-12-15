public abstract class Booking {
    protected String apiKey = "JDyCGQgGGU0GMzHNY8ck0b7vtZLwgpuz";
    public abstract void receiveRequest(Estimate estimate, Schedule schedule);
    public abstract void provideOptions(); //Think about return type for this

}

