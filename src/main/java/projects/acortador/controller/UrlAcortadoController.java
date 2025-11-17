package projects.acortador.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.acortador.dto.AcortarUrlRequest;
import projects.acortador.service.UrlMappingService;

import java.io.IOException;

@RestController
@RequestMapping("/api/url")
public class UrlAcortadoController {

    @Autowired
    public UrlMappingService urlMappingService;

    @PostMapping("/shorten")
    public String createShortUrl(@RequestBody AcortarUrlRequest acortarUrlRequest) {
        return urlMappingService.shortenUrl(acortarUrlRequest.getUrl());
    }

    @GetMapping("/{shortCode}")
    public void redireccionarUrlLarga(@PathVariable String shortCode, HttpServletResponse response) throws IOException {
        String longUrl = urlMappingService.getUrl(shortCode);
        if (longUrl != null) {
            response.sendRedirect(longUrl);
        }else  {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
