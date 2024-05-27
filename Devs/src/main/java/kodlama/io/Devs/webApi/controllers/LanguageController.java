package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("/getall")
    public List<GetAllResponse> getAll(){
        return languageService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest){
        languageService.add(createLanguageRequest);
    }
}
