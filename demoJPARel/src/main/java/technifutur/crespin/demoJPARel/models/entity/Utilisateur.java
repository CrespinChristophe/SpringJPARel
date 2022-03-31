package technifutur.crespin.demoJPARel.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "num_nat", nullable = false)
    private String numNational;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 30)
    private String nom;

    @Column(nullable = false, length = 30)
    private String prenom;
//cascadetype.persist permet de sauver les voitures quand je sauve les utilisateurs
    @ManyToMany(cascade = { CascadeType.PERSIST})//Entité forte dans le contexte de la relation avec l'entité Voiture
    private List<Voiture> voitures;

}