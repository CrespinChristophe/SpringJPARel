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
@Table(name = "voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT")
    private Long id;

    @Column(name = "marque", nullable = false, length = 20)
    private String marque;

    @Column(name = "modele", nullable = false, length = 20)
    private String modele;

    @Column(name = "disponible", nullable = false)
    private boolean disponible;

    @Enumerated (EnumType.STRING)//pour les enumerations. par defaut c'est ordinal
                                    //donc on dit qu'on veut un String
    @Column(length = 20, nullable = false)
    private Carburant carburant;

/*@Transient //dit que ça ne se trouve pas dans la DB
               //Transient est l'inverse de @Basic
               //donnée non persistante*/
   /* @Basic effetcue un mapping basic
    private String maPetiteProp;*/

    @ManyToMany(mappedBy = "voitures")//mapped by de ce côté donc entité faible dans le contexte de la relation avec
                                        // l'entité Utilisateur
    private List<Utilisateur> proprietaire;



}