
package models.flight;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "outbound",
    "inbound"
})
public class Itinerary {

    @JsonProperty("outbound")
    private Outbound outbound;
    @JsonProperty("inbound")
    private Inbound inbound;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Itinerary() {
    }

    /**
     *
     * @param outbound
     * @param inbound
     */
    public Itinerary(Outbound outbound, Inbound inbound) {
        super();
        this.outbound = outbound;
        this.inbound = inbound;
    }

    @JsonProperty("outbound")
    public Outbound getOutbound() {
        return outbound;
    }

    @JsonProperty("outbound")
    public void setOutbound(Outbound outbound) {
        this.outbound = outbound;
    }

    @JsonProperty("inbound")
    public Inbound getInbound() {
        return inbound;
    }

    @JsonProperty("inbound")
    public void setInbound(Inbound inbound) {
        this.inbound = inbound;
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
        return new ToStringBuilder(this).append("outbound", outbound).append("inbound", inbound).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(outbound).append(inbound).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Itinerary) == false) {
            return false;
        }
        Itinerary rhs = ((Itinerary) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(outbound, rhs.outbound).append(inbound, rhs.inbound).isEquals();
    }

}
