
package models.carrental;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acriss_code",
    "transmission",
    "fuel",
    "air_conditioning",
    "category",
    "type"
})
public class VehicleInfo {

    @JsonProperty("acriss_code")
    private String acrissCode;
    @JsonProperty("transmission")
    private String transmission;
    @JsonProperty("fuel")
    private String fuel;
    @JsonProperty("air_conditioning")
    private Boolean airConditioning;
    @JsonProperty("category")
    private String category;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("acriss_code")
    public String getAcrissCode() {
        return acrissCode;
    }

    @JsonProperty("acriss_code")
    public void setAcrissCode(String acrissCode) {
        this.acrissCode = acrissCode;
    }

    @JsonProperty("transmission")
    public String getTransmission() {
        return transmission;
    }

    @JsonProperty("transmission")
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @JsonProperty("fuel")
    public String getFuel() {
        return fuel;
    }

    @JsonProperty("fuel")
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @JsonProperty("air_conditioning")
    public Boolean getAirConditioning() {
        return airConditioning;
    }

    @JsonProperty("air_conditioning")
    public void setAirConditioning(Boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
        return new ToStringBuilder(this).append("acrissCode", acrissCode).append("transmission", transmission).append("fuel", fuel).append("airConditioning", airConditioning).append("category", category).append("type", type).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(category).append(acrissCode).append(additionalProperties).append(fuel).append(airConditioning).append(type).append(transmission).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VehicleInfo) == false) {
            return false;
        }
        VehicleInfo rhs = ((VehicleInfo) other);
        return new EqualsBuilder().append(category, rhs.category).append(acrissCode, rhs.acrissCode).append(additionalProperties, rhs.additionalProperties).append(fuel, rhs.fuel).append(airConditioning, rhs.airConditioning).append(type, rhs.type).append(transmission, rhs.transmission).isEquals();
    }

}
