package kodlama.io.Devs.business.abstracts;

import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TechnologyService {
    List<GetAllResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    void delete(CreateTechnologyRequest createTechnologyRequest) throws Exception;

}
