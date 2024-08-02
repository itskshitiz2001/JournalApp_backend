package net.engineeringdigest.journalApp.api.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse{
    private Current current;
    private Location location;
    @Getter
    @Setter
    public class Current{
        @JsonProperty("temp_c")
        private double tempCelsius;
        @JsonProperty("feelslike_c")
        private double feelslikeCelsius;
    }
    @Getter
    @Setter
    public class Location{
        @JsonProperty("name")
        private String locationName;
        @JsonProperty("region")
        private String locationRegion;
        @JsonProperty("country")
        private String locationCountry;
    }


}




