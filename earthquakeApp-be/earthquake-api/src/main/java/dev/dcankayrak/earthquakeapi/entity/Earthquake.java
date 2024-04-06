package dev.dcankayrak.earthquakeapi.entity;

import jdk.jfr.Timestamp;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "earthquakes")
public class Earthquake {
    @Id
    private String id;
    private String location;
    private double lat;
    private double lng;
    private double pow;
    private double depth;
    private LocalDateTime created_at;
}
