package technifutur.crespin.demoJPARel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.demoJPARel.models.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
