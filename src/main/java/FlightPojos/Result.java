
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
    "itineraries",
    "fare"
})
public class Result {

    @JsonProperty("itineraries")
    private List<Itinerary> itineraries = null;
    @JsonProperty("fare")
    private Fare fare;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param fare
     * @param itineraries
     */
    public Result(List<Itinerary> itineraries, Fare fare) {
        super();
        this.itineraries = itineraries;
        this.fare = fare;
    }

    @JsonProperty("itineraries")
    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    @JsonProperty("itineraries")
    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    @JsonProperty("fare")
    public Fare getFare() {
        return fare;
    }

    @JsonProperty("fare")
    public void setFare(Fare fare) {
        this.fare = fare;
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
        return new ToStringBuilder(this).append("itineraries", itineraries).append("fare", fare).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(fare).append(itineraries).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(fare, rhs.fare).append(itineraries, rhs.itineraries).isEquals();
    }

}
