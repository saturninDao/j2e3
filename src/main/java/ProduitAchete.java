import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produits_achetes")
//@IdClass(IdproduitAchete.class)
public class ProduitAchete implements Serializable {

    @EmbeddedId
    private IdproduitAchete id;
    
    @Column(name = "remise", nullable = false)
    private double remise;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "id_achat", nullable = false, insertable = false, updatable = false)
    private Achat achat;
    
    @ManyToOne(fetch=FetchType.LAZY, cascade = {})
    @JoinColumn(name="id_produit", nullable=false, insertable = false, updatable = false)
    private Produit produit;

    public ProduitAchete() {
    }

    public ProduitAchete(IdproduitAchete id, double remise, Achat achat, Produit produit) {
        this.id = id;
        this.remise = remise;
        this.achat = achat;
        this.produit = produit;
    }

    public IdproduitAchete getId() {
        return id;
    }

    public void setId(IdproduitAchete id) {
        this.id = id;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ProduitAchete other = (ProduitAchete) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProduitAchete{" + "remise=" + remise + ", produit=" + produit + ", achat=" + achat + '}';
    }
}
