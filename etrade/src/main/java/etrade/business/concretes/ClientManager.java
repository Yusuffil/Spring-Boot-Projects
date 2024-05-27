package etrade.business.concretes;

import etrade.Entities.concretes.Client;
import etrade.business.abstracts.ClientService;
import etrade.business.core.utilities.mappers.ModelMapperService;
import etrade.business.requests.Client.CreateClientRequest;
import etrade.business.requests.Client.UpdateClientRequest;
import etrade.business.responses.Clients.CreateClientResponse;
import etrade.business.responses.Clients.GetAllClientsResponse;
import etrade.business.rules.ClientBusinessRules;
import etrade.dataAccess.abstracts.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ClientManager implements ClientService {

    private ClientRepository clientRepository;
    private ModelMapperService modelMapperService;
    private ClientBusinessRules clientBusinessRules;

    public ClientManager(ClientRepository clientRepository) {

    }

    @Override
    public Page<GetAllClientsResponse> getAll(Pageable pageable) {
        Page<Client> clients = this.clientRepository.findAll(pageable);
        Page<GetAllClientsResponse> clientResponses = clients.map(client -> this.modelMapperService.forResponse().
                        map(client, GetAllClientsResponse.class));
        return clientResponses;
    }

    public CreateClientResponse add(CreateClientRequest createClientRequest) {
        clientBusinessRules.checkIfClientIdentityNumberExists(createClientRequest.getIdentityNumber());
        Client client = this.modelMapperService.forRequest().map(createClientRequest, Client.class);
        this.clientRepository.save(client);
        CreateClientResponse clientResponse = new CreateClientResponse();
        clientResponse.setFullname(createClientRequest.getFullname());
        clientResponse.setIdentityNumber(createClientRequest.getIdentityNumber());

        return clientResponse;
    }

    @Override
    public void update(UpdateClientRequest updateClientRequest) {
        var client = modelMapperService.forRequest().map(updateClientRequest,Client.class);
        clientRepository.save(client);
    }

    @Override
    public boolean delete(int id) {

        var client = clientRepository.findById(id);
        if(client.isPresent()){
            clientRepository.delete(client.get());
            return true;
        }
        return false;
    }

}
