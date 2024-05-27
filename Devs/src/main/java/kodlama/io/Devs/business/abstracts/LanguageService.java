package kodlama.io.Devs.business.abstracts;

import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllResponse;
import kodlama.io.Devs.entities.concretes.Language;

import java.util.ArrayList;
import java.util.List;

public interface LanguageService {
    List<GetAllResponse> getAll();
    void add(CreateLanguageRequest createLanguageRequest);
    void delete(CreateLanguageRequest createLanguageRequest) throws Exception;

}
