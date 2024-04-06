package dev.dcankayrak.earthquakeapi.controller;

import dev.dcankayrak.earthquakeapi.core.results.DataResult;
import dev.dcankayrak.earthquakeapi.core.results.Result;
import dev.dcankayrak.earthquakeapi.dto.earthquake.request.CreateEarthquakeRequest;
import dev.dcankayrak.earthquakeapi.dto.earthquake.response.EarthquakeResponse;
import dev.dcankayrak.earthquakeapi.service.EarthquakeService;
import dev.dcankayrak.earthquakeapi.utils.constants.Apis;
import dev.dcankayrak.earthquakeapi.core.results.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(Apis.Earthquake.BASE_URL)
public class EarthquakeController {
    private final EarthquakeService earthquakeService;

    @GetMapping
    public DataResult<List<EarthquakeResponse>> getAll(){
        return this.earthquakeService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<EarthquakeResponse> getWithId(@RequestParam String id){
        return this.earthquakeService.getWithId(id);
    }

    @PostMapping
    public DataResult<EarthquakeResponse> create(@RequestBody CreateEarthquakeRequest request){
        return this.earthquakeService.create(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam String id){
        return this.earthquakeService.delete(id);
    }
}
