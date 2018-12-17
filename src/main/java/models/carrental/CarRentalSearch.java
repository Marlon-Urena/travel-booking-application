
package models.carrental;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "results"
})
public class CarRentalSearch {

    @JsonProperty("results")
    private List<Result> results = null;

    @JsonProperty("result")
    private Result result = null;

    @JsonProperty("car")
    private Car car = null;

    @JsonProperty
    public void setCar(Car car) {this.car = car;}

    @JsonProperty
    public void setResult(Result result) {this.result = result;}

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


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
        StringBuilder sb = new StringBuilder();

            sb.append("******************** Car Rental Result *********************\n");
            sb.append("***[Car Rental]*********************************************\n");
            sb.append("Car Category: (" + car.getVehicleInfo().getCategory() + ")\n\n");
            sb.append("Vehicle Type: (" + car.getVehicleInfo().getType() + ")\n");
            sb.append("Fuel Type: (" + car.getVehicleInfo().getType() + ")\n");
            sb.append("Air Conditioning: (" + car.getVehicleInfo().getAirConditioning() + ")\n\n");
            sb.append("Pick Up Location: (" + result.getAirport() + ")\n");
            sb.append("Company Name: (" + result.getProvider().getCompanyName() + ")\n");
            sb.append("Company Code: (" + result.getProvider().getCompanyCode() + ")\n");
            sb.append("************************************************************\n");
            sb.append("(" + car.getRates().get(0).getType() + ") Price: (" + car.getRates().get(0).getPrice().getAmount() + ") (" + car.getRates().get(0).getPrice().getCurrency() + ")\n");
            sb.append("Estimated Total Price: (" + car.getEstimatedTotal().getAmount() + ") (" + car.getEstimatedTotal().getCurrency() + ")\n");
            sb.append("************************************************************\n");

            return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRentalSearch that = (CarRentalSearch) o;
        return Objects.equals(results, that.results) &&
                Objects.equals(result, that.result) &&
                Objects.equals(car, that.car) &&
                Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, result, car, additionalProperties);
    }
}
