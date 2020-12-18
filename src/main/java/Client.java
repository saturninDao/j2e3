
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("C")
@Table(name="client")
public class Client extends Personne implements Serializable{

    public Client() {
    }
    
    public Client(Long id, String nom, String prenom) {
        super(id, nom, prenom);
    }

}
