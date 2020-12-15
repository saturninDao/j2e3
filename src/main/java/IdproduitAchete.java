
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daoma
 */

@Embeddable
public class IdproduitAchete implements Serializable {
    
    @Column(name="id_produit", nullable=false)
    Long idProduit;
    
    @Column(name="id_achat", nullable=false)
    Long idAchat;

    public IdproduitAchete() {
    }

    public IdproduitAchete(Long idProduit, Long idAchat) {
        this.idProduit = idProduit;
        this.idAchat = idAchat;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Long getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(Long idAchat) {
        this.idAchat = idAchat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.idProduit != null ? this.idProduit.hashCode() : 0);
        hash = 37 * hash + (this.idAchat != null ? this.idAchat.hashCode() : 0);
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
        final IdproduitAchete other = (IdproduitAchete) obj;
        if (this.idProduit != other.idProduit && (this.idProduit == null || !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        if (this.idAchat != other.idAchat && (this.idAchat == null || !this.idAchat.equals(other.idAchat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IdproduitAchete{" + "idProduit=" + idProduit + ", idAchat=" + idAchat + '}';
    }
    
}
