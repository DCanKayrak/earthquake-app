package dev.dcankayrak.earthquakeapi.repository;

import dev.dcankayrak.earthquakeapi.entity.Earthquake;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarthquakeRepository extends MongoRepository<Earthquake,String> {

}
