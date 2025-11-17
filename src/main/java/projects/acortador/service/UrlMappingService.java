package projects.acortador.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.acortador.model.UrlMapping;
import projects.acortador.repository.UrlMappingRepository;

import java.util.Optional;

@Service
public class UrlMappingService {

    @Autowired
    public UrlMappingRepository urlMappingRepository;

    public String shortenUrl(String url){
        String codigoGenerado;
        do {
            codigoGenerado = RandomStringUtils.randomAlphanumeric(6);

        }while(urlMappingRepository.findByShortCode(codigoGenerado).isPresent());

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setUrl(url);
        urlMapping.setShortCode(codigoGenerado);
        urlMappingRepository.save(urlMapping);

        return codigoGenerado;

    }

    public String getUrl(String shortCode){
        Optional<UrlMapping> urlMapping = urlMappingRepository.findByShortCode(shortCode);
        if(urlMapping.isPresent()){
            return urlMapping.get().getUrl();
        }else {
            return null;
        }
    }


}
