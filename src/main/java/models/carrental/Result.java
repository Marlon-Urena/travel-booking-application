
package models.carrental;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "provider",
    "branch_id",
    "location",
    "airport",
    "address",
    "cars"
})
public class Result {

    @JsonProperty("provider")
    private Provider provider;
    @JsonProperty("branch_id")
    private String branchId;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("airport")
    private String airport;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("cars")
    private List<Car> cars = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("provider")
    public Provider getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @JsonProperty("branch_id")
    public String getBranchId() {
        return branchId;
    }

    @JsonProperty("branch_id")
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("airport")
    public String getAirport() {
        return airport;
    }

    @JsonProperty("airport")
    public void setAirport(String airport) {
        this.airport = airport;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("cars")
    public List<Car> getCars() {
        return cars;
    }

    @JsonProperty("cars")
    public void setCars(List<Car> cars) {
        this.cars = cars;
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
        return new ToStringBuilder(this).append("provider", provider).append("branchId", branchId).append("location", location).append("airport", airport).append("address", address).append("cars", cars).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(airport).append(address).append(location).append(branchId).append(additionalProperties).append(cars).append(provider).toHashCode();
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
        return new EqualsBuilder().append(airport, rhs.airport).append(address, rhs.address).append(location, rhs.location).append(branchId, rhs.branchId).append(additionalProperties, rhs.additionalProperties).append(cars, rhs.cars).append(provider, rhs.provider).isEquals();
    }

}
