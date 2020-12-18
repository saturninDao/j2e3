import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="produits")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    
    @Column(name="libelle", nullable=false, length=63)
    private String libelle;
    
    @Column(name="prix_unitaire", nullable=false)
    private double prixUnitaire;
    
    @Column(name = "date_peremption", nullable = false)
    private LocalDate datePremption;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name="id_categorie", nullable=false)
    private Categorie categorie;

    public Produit() {
    }

    public Produit(String libelle, double prixUnitaire, LocalDate datePremption, Categorie categorie) {
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePremption = datePremption;
        this.categorie = categorie;
    }

    public Produit(long id, String libelle, double prixUnitaire, LocalDate datePremption, Categorie categorie) {
        this.id = id;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePremption = datePremption;
        this.categorie = categorie;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public LocalDate getDatePremption() {
        return datePremption;
    }

    public void setDatePremption(LocalDate datePremption) {
        this.datePremption = datePremption;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire + ", datePremption=" + datePremption + ", categorie=" + categorie + '}';
    }

    boolean estPerime(){
        if(this.datePremption.isAfter(LocalDate.now())){
            return false;
        }
        return true;
    }

    boolean estPerime(LocalDate dateReference ){
        if(this.datePremption.isAfter(dateReference)){
            return false;
    }
        return true;
    }
}
