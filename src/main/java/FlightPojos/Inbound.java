
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
    "duration",
    "flights"
})
public class Inbound {

    @JsonProperty("duration")
    private String duration;
    @JsonProperty("flights")
    private List<Flight> flights = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Inbound() {
    }

    /**
     * 
     * @param duration
     * @param flights
     */
    public Inbound(String duration, List<Flight> flights) {
        super();
        this.duration = duration;
        this.flights = flights;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("flights")
    public List<Flight> getFlights() {
        return flights;
    }

    @JsonProperty("flights")
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
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
        return new ToStringBuilder(this).append("duration", duration).append("flights", flights).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(duration).append(flights).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Inbound) == false) {
            return false;
        }
        Inbound rhs = ((Inbound) other);
        return new EqualsBuilder().append(duration, rhs.duration).append(flights, rhs.flights).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
