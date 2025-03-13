package ports;

import app.domain.models.Mascot;
import java.util.List;

public interface MascotPort {
    void saveMascot(Mascot mascot);
    Mascot findMascotById(long mascotId);
    List<Mascot> findMascotsByOwnerDocument(long ownerDocument);
    void updateMascot(Mascot mascot);

}