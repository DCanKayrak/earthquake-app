package dev.dcankayrak.earthquakeapi.service;

import dev.dcankayrak.earthquakeapi.core.converter.GeneralConverter;
import dev.dcankayrak.earthquakeapi.core.results.DataResult;
import dev.dcankayrak.earthquakeapi.core.results.Result;
import dev.dcankayrak.earthquakeapi.core.results.SuccessDataResult;
import dev.dcankayrak.earthquakeapi.core.results.SuccessResult;
import dev.dcankayrak.earthquakeapi.dto.earthquake.request.CreateEarthquakeRequest;
import dev.dcankayrak.earthquakeapi.dto.earthquake.response.EarthquakeResponse;
import dev.dcankayrak.earthquakeapi.entity.Earthquake;
import dev.dcankayrak.earthquakeapi.entity.enums.ErrorEnum;
import dev.dcankayrak.earthquakeapi.exception.GenericException;
import dev.dcankayrak.earthquakeapi.repository.EarthquakeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EarthquakeService {
    private final EarthquakeRepository earthquakeRepository;
    private final GeneralConverter converter;

    public DataResult<List<EarthquakeResponse>> getAll(){
        return new SuccessDataResult<>(this.earthquakeRepository.findAll(),"Depremler başarıyla getirildi");
    }
    public DataResult<EarthquakeResponse> getWithId(String id){
        Earthquake earthquake = this.earthquakeRepository.findById(id).orElseThrow(() -> new GenericException(ErrorEnum.EARTHQUAKE_NOT_FOUND));
        return new SuccessDataResult<>(earthquake,"Deprem başarıyla getirildi");
    }
    public DataResult<EarthquakeResponse> create(CreateEarthquakeRequest request){
        Earthquake tempEarthquake = this.converter.map(request,Earthquake.class);
        tempEarthquake.setCreated_at(LocalDateTime.now());
        earthquakeRepository.save(tempEarthquake);
        EarthquakeResponse response = this.converter.map(tempEarthquake,EarthquakeResponse.class);

        return new SuccessDataResult<EarthquakeResponse>(response);
    }

    public Result delete(String id){
        earthquakeRepository.deleteById(id);
        return new SuccessResult("Başarıyla Silindi");
    }
}
