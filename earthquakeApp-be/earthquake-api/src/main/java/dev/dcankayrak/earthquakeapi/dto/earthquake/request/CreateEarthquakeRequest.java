package dev.dcankayrak.earthquakeapi.dto.earthquake.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
public class CreateEarthquakeRequest {
    private String location;
    private double lat;
    private double lng;
    private double pow;
    private double depth;
}
