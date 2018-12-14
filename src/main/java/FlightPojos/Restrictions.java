
package FlightPojos;

import java.util.HashMap;
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
    "refundable",
    "change_penalties"
})
public class Restrictions {

    @JsonProperty("refundable")
    private Boolean refundable;
    @JsonProperty("change_penalties")
    private Boolean changePenalties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Restrictions() {
    }

    /**
     * 
     * @param refundable
     * @param changePenalties
     */
    public Restrictions(Boolean refundable, Boolean changePenalties) {
        super();
        this.refundable = refundable;
        this.changePenalties = changePenalties;
    }

    @JsonProperty("refundable")
    public Boolean getRefundable() {
        return refundable;
    }

    @JsonProperty("refundable")
    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    @JsonProperty("change_penalties")
    public Boolean getChangePenalties() {
        return changePenalties;
    }

    @JsonProperty("change_penalties")
    public void setChangePenalties(Boolean changePenalties) {
        this.changePenalties = changePenalties;
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
        return new ToStringBuilder(this).append("refundable", refundable).append("changePenalties", changePenalties).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(refundable).append(additionalProperties).append(changePenalties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Restrictions) == false) {
            return false;
        }
        Restrictions rhs = ((Restrictions) other);
        return new EqualsBuilder().append(refundable, rhs.refundable).append(additionalProperties, rhs.additionalProperties).append(changePenalties, rhs.changePenalties).isEquals();
    }

}
