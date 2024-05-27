package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;


    @Override
    public List<GetAllResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<GetAllResponse> languageResponse = new ArrayList<>();
        for (Language language : languages) {
            GetAllResponse responseItem = new GetAllResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());
            languageResponse.add(responseItem);
        }
        return languageResponse;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {

        if (createLanguageRequest.getName() == null) {
            System.out.println("Programlama dili boş geçilemez");
        } else if (!createLanguageRequest.getName().isBlank()) {
            var language = languageRepository.findByName(createLanguageRequest.getName());
            if (language != null) {
                System.out.println(createLanguageRequest.getName() + "isminde programlama dili listede mevcuttur.");
            } else {
                language = new Language();
                language.setName(createLanguageRequest.getName());
                this.languageRepository.save(language);

            }
        }

    }

    @Override
    public void delete(CreateLanguageRequest createLanguageRequest) throws Exception {
        if (createLanguageRequest.getName() == null) {
            throw new Exception("Programlama dili boş geçilemez");
        } else if (!createLanguageRequest.getName().isBlank()) {
            var language = languageRepository.findByName(createLanguageRequest.getName());
            if (language != null) {
                this.languageRepository.delete(language);
            } else {
                throw new Exception(createLanguageRequest.getName() + "tabloda mevcut değildir.");
            }

        }

    }


}
