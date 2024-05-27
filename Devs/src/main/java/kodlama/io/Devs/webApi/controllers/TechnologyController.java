package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.responses.GetAllResponse;
import kodlama.io.Devs.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/technologies")
public class TechnologyController {

    private TechnologyService technologyService;
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
    @GetMapping("/getall")
    public List<GetAllResponse> getAll(){
        return technologyService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception {
        technologyService.add(createTechnologyRequest);
    }
}

