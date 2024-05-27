package etrade.business.rules;

import etrade.business.core.utilities.exceptions.BusinessException;
import etrade.dataAccess.abstracts.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientBusinessRules {
    private ClientRepository clientRepository;

    public void checkIfClientIdentityNumberExists(String identityNumber){


        if (!this.clientRepository.existsByIdentityNumber(identityNumber)) {
            return;
        }
        throw new BusinessException("Client already exists");
    }
}
