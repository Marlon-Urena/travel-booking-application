
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
    "total_fare",
    "tax"
})
public class PricePerInfant {

    @JsonProperty("total_fare")
    private String totalFare;
    @JsonProperty("tax")
    private String tax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PricePerInfant() {
    }

    /**
     * 
     * @param totalFare
     * @param tax
     */
    public PricePerInfant(String totalFare, String tax) {
        super();
        this.totalFare = totalFare;
        this.tax = tax;
    }

    @JsonProperty("total_fare")
    public String getTotalFare() {
        return totalFare;
    }

    @JsonProperty("total_fare")
    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
    }

    @JsonProperty("tax")
    public String getTax() {
        return tax;
    }

    @JsonProperty("tax")
    public void setTax(String tax) {
        this.tax = tax;
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
        StringBuilder sb = new StringBuilder();
        sb.append(totalFare);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalFare).append(tax).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PricePerInfant) == false) {
            return false;
        }
        PricePerInfant rhs = ((PricePerInfant) other);
        return new EqualsBuilder().append(totalFare, rhs.totalFare).append(tax, rhs.tax).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
