package dev.dcankayrak.earthquakeapi.dto.earthquake.response;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EarthquakeResponse {
    private String location;
    private double lat;
    private double lng;
    private double pow;
    private double depth;
    private LocalDateTime created_at;
}
