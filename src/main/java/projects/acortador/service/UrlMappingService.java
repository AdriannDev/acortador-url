package projects.acortador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.acortador.repository.UrlMappingRepository;

@Service
public class UrlMappingService {

    @Autowired
    public UrlMappingRepository urlMappingRepository;
    

}
