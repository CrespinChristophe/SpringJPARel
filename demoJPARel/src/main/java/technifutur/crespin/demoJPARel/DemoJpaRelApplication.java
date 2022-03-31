package technifutur.crespin.demoJPARel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import technifutur.crespin.demoJPARel.models.entity.Carburant;
import technifutur.crespin.demoJPARel.models.entity.Utilisateur;
import technifutur.crespin.demoJPARel.models.entity.Voiture;
import technifutur.crespin.demoJPARel.repository.UtilisateurRepository;
import technifutur.crespin.demoJPARel.repository.VoitureRepository;

import java.util.List;

@SpringBootApplication
public class DemoJpaRelApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoJpaRelApplication.class, args);

		VoitureRepository vRepo = ctx.getBean(VoitureRepository.class);
		UtilisateurRepository uRepo = ctx.getBean(UtilisateurRepository.class);

		Voiture v = new Voiture(
				0L,
				"marque",
				"modele",
				true,
					Carburant.ELECTRIQUE,
					null

		);

		Utilisateur u = new Utilisateur(
				10L,
				"numnat",
				"username",
				"password",
				"nom",
				"prenom",
				null
		);

		v = vRepo.save(v); //id présent ==> update, id pas present==> insert
		u = uRepo.save(u);

		u.setVoitures(List.of(v));//En RAM
		u = uRepo.save(u);//Ecrit ds la DB


	}

}
