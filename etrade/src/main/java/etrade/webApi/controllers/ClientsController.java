package etrade.webApi.controllers;

import etrade.business.abstracts.ClientService;
import etrade.business.requests.Client.CreateClientRequest;
import etrade.business.requests.Client.UpdateClientRequest;
import etrade.business.responses.Clients.CreateClientResponse;
import etrade.business.responses.Clients.GetAllClientsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/clients")
@AllArgsConstructor
public class ClientsController {

    private ClientService clientService;

    @GetMapping()
    public Page<GetAllClientsResponse> getAll(Pageable pageable){
        return clientService.getAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateClientResponse add(@RequestBody @Valid CreateClientRequest createClientRequest){

        return clientService.add(createClientRequest);
    }

    @PutMapping
    public void a(@RequestBody @Valid UpdateClientRequest updateClientRequest){

        clientService.update(updateClientRequest);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        clientService.delete(id);
    }
}
