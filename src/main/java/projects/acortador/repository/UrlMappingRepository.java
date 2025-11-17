package projects.acortador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.acortador.model.UrlMapping;

import java.util.Optional;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, String> {
    Optional<UrlMapping> findByShortCode(String shortCode);
}
