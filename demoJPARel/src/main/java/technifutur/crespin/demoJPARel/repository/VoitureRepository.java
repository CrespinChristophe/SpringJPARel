package technifutur.crespin.demoJPARel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.demoJPARel.models.entity.Voiture;

public interface VoitureRepository extends JpaRepository <Voiture, Long> {
}
