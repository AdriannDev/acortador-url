package projects.acortador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.acortador.model.UrlMapping;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, String> {
}
