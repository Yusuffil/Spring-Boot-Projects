package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllResponse;
import kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository technologyRepository;

    @Override
    public List<GetAllResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllResponse> techResponse = new ArrayList<>();
        for (Technology technology : technologies) {
            var x = new GetAllResponse();
            x.setId(technology.getId());
            x.setName(technology.getName());
            techResponse.add(x);
        }
        return techResponse;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        if (createTechnologyRequest.getName() == null) {
            throw new Exception("Teknoloji ismi boş bırakılamaz.");
        } else if (!createTechnologyRequest.getName().isBlank()) {
            var technology = technologyRepository.findByName(createTechnologyRequest.getName());
            if (technology != null) {
                System.out.println(createTechnologyRequest.getName() + "isminde teknoloji ismi listede mevcuttur.");
            } else {
                technology = new Technology();
                technology.setName(createTechnologyRequest.getName());
                this.technologyRepository.save(technology);
            }
        }
    }

    @Override
    public void delete(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        if (createTechnologyRequest.getName() == null) {
            throw new Exception("Programlama dili boş geçilemez");
        } else if (!createTechnologyRequest.getName().isBlank()) {
            var technology = technologyRepository.findByName(createTechnologyRequest.getName());
            if (technology != null) {
                this.technologyRepository.delete(technology);
            } else {
                throw new Exception(createTechnologyRequest.getName() + "tabloda mevcut değildir.");
            }
        }

    }
}
