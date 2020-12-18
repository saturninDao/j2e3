import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="achats")
public class Achat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    
    @Column(name="date_Achat", nullable = false)
    private LocalDate dateAchat;
    
    @Column(name="remise", nullable = false)
    private double remise;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name="id_employe", nullable = false)
    private Employe employe;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;
    
    @OneToMany(mappedBy = "achat", fetch = FetchType.LAZY, cascade={})
    private List<ProduitAchete> produitsAchetes;

    public Achat() {
    }

    public Achat(long id, LocalDate dateAchat, double remise, Employe employe, Client client, List<ProduitAchete> produitAchetes) {
        this.id = id;
        this.dateAchat = dateAchat;
        this.remise = remise;
        this.employe = employe;
        this.client = client;
        this.produitsAchetes = produitAchetes;
    }
    
    public double getRemiseTotale() {
        double remiseTotale = 0;
        for(int i = 0; i < produitsAchetes.size(); i++){
            remiseTotale = remiseTotale + produitsAchetes.get(i).getRemise();
        }
        return remiseTotale;
    }
    
    public double getTotalAPayer() {
        double prixTotal = 0;
        for(int i = 0; i < produitsAchetes.size(); i++){
            prixTotal = prixTotal + produitsAchetes.get(i).getProduit().getPrixUnitaire();
        }
        prixTotal = prixTotal - getRemiseTotale();
        return prixTotal;
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
        final Achat other = (Achat) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Achat{" +
                "id=" + id +
                ", dateAchat=" + dateAchat +
                ", remise=" + remise +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProduitAchete> getProduitAchetes() {
        return produitsAchetes;
    }

    public void setProduitAchetes(List<ProduitAchete> produitAchetes) {
        this.produitsAchetes = produitAchetes;
    }
    
    public void addProduitAchete(ProduitAchete produitAchete){
        this.produitsAchetes.add(produitAchete);
        produitAchete.setAchat(this);
    }
    
    
}
