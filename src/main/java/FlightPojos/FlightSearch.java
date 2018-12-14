
package FlightPojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "results"
})
public class FlightSearch {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("results")
    private List<Result> results ;

    private Fare fare ;
    private PricePerAdult pricePerAdult;
    private PricePerChild pricePerChild=null ;
    private PricePerInfant pricePerInfant =null;

    private Itinerary itinerary ; // May not use because want to follow my format
    private Inbound inbound ;
    private Outbound outbound ;
    private List<Flight> flight ;
    private Origin origin ;
    private Destination destination ;
    private BookingInfo bookingInfo ;





    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FlightSearch() {
    }

    /**
     * 
     * @param results
     * @param currency
     */
    public FlightSearch(String currency, List<Result> results) {
        super();
        this.currency = currency;
        this.results = results;
    }
    @JsonProperty("destination")
    public void setDestination(Destination destination) {
        this.destination = destination;
    }
    @JsonProperty("origin")
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }
    @JsonProperty("outbound")
    public void setOutbound(Outbound outbound) {
        this.outbound = outbound;
    }
    @JsonProperty("inbound")
    public void setInbound(Inbound inbound) {
        this.inbound = inbound;
    }
    @JsonProperty("pricePerAdult")
    public void setPricePerAdult(PricePerAdult pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }
    @JsonProperty("pricePerChild")
    public void setPricePerChild(PricePerChild pricePerChild) {
        this.pricePerChild = pricePerChild;
    }
    @JsonProperty("pricePerInfant")
    public void setPricePerInfant(PricePerInfant pricePerInfant) {
        this.pricePerInfant = pricePerInfant;
    }
    @JsonProperty("fare")
    public void setFare(Fare fare) { this.fare = fare;}

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        //return new ToStringBuilder(this).append("currency", currency).append("results", results).append("additionalProperties", additionalProperties).toString();
        StringBuilder sb = new StringBuilder();

            sb.append("********************** Flight Result ***********************\n");
            sb.append("***[Outbound]***********************************************\n");
        for(int i = 0; i < outbound.getFlights().size(); i++ ) {
            sb.append("Airline: (" + outbound.getFlights().get(i).getMarketingAirline() + ") (" + outbound.getFlights().get(i).getFlightNumber() + ")" + "\n");
            sb.append("Operated By: (" + outbound.getFlights().get(i).getOperatingAirline() + ")" + "\n");
            sb.append("(" +  outbound.getFlights().get(i).getOrigin().getAirport() + ")\t" + "--->\t(" +  outbound.getFlights().get(i).getDestination().getAirport()+ ")\t\tFlight Duration: (" + outbound.getDuration() + ")" + "\n");
            sb.append("Terminal (" + outbound.getFlights().get(i).getOrigin().getTerminal() + ")\tTerminal (" + outbound.getFlights().get(i).getDestination().getTerminal() + "\n\n");
            sb.append("Departs: (" + outbound.getFlights().get(i).getDepartsAt() + ")\n");
            sb.append("Arrives: (" + outbound.getFlights().get(i).getArrivesAt() + ")\n\n");
            sb.append("Travel Class: (" + outbound.getFlights().get(i).getBookingInfo().getTravelClass() + ")\n");
            sb.append("Seats Remaining: (" + outbound.getFlights().get(i).getBookingInfo().getSeatsRemaining() + ")\n");
            sb.append("************************************************************\n");
        }
            sb.append("***[Inbound]************************************************\n");
        for(int i = 0; i < inbound.getFlights().size(); i++ ) {
            sb.append("Airline: (" + inbound.getFlights().get(i).getMarketingAirline() + ") (" + inbound.getFlights().get(i).getFlightNumber() + ")" + "\n");
            sb.append("Operated By: (" + inbound.getFlights().get(i).getOperatingAirline() + ")" + "\n");
            sb.append("(" +  inbound.getFlights().get(i).getOrigin().getAirport() + ")\t" + "--->\t(" +  inbound.getFlights().get(i).getDestination().getAirport()+ ")\t\tFlight Duration: (" + inbound.getDuration() + ")" + "\n");
            sb.append("Terminal (" + inbound.getFlights().get(i).getOrigin().getTerminal() + ")\tTerminal (" + inbound.getFlights().get(i).getDestination().getTerminal() + ")\n\n");
            sb.append("Departs: (" + inbound.getFlights().get(i).getDepartsAt() + ")\n");
            sb.append("Arrives: (" + inbound.getFlights().get(i).getArrivesAt() + ")\n\n");
            sb.append("Travel Class: (" + inbound.getFlights().get(i).getBookingInfo().getTravelClass() + ")\n");
            sb.append("Seats Remaining: (" + inbound.getFlights().get(i).getBookingInfo().getSeatsRemaining() + ")\n");
            sb.append("************************************************************\n");
        }
        sb.append("************************************************************\n");

        sb.append("Price per adult: " + fare.getPricePerAdult().toString() + " " + currency + "\n");
        if (!(pricePerChild == null)) {
            sb.append("Price per child: " + pricePerChild.toString() + " " + currency + "\n");
        }
        if(!(pricePerInfant == null)) {
            sb.append("Price per infant: " + pricePerInfant.toString() + " " + currency + "\n" );
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(results).append(additionalProperties).append(currency).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FlightSearch) == false) {
            return false;
        }
        FlightSearch rhs = ((FlightSearch) other);
        return new EqualsBuilder().append(results, rhs.results).append(additionalProperties, rhs.additionalProperties).append(currency, rhs.currency).isEquals();
    }

}
