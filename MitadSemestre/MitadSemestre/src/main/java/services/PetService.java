package services;

import app.domain.models.Mascot;
import ports.MascotPort;
import java.util.List;

public class PetService {

    private MascotPort mascotPort;

    public PetService(MascotPort mascotPort) {
        this.mascotPort = mascotPort;
    }

    public void registerPet(Mascot newMascot) throws Exception {

        mascotPort.saveMascot(newMascot);
        
        System.out.println("La mascota ha sido registrada exitosamente.");
    }

    public Mascot getMascotById(long mascotId) throws Exception {
        Mascot mascot = mascotPort.findMascotById(mascotId);
        if (mascot == null) {
            throw new Exception("Mascota no encontrada");
        }
        return mascot;
    }

    public List<Mascot> getPetsByOwner(long ownerDocument) throws Exception {
        List<Mascot> mascots = mascotPort.findMascotsByOwnerDocument(ownerDocument);
        if (mascots == null || mascots.isEmpty()) {
            throw new Exception("No se encontraron mascotas para este dueño");
        }
        return mascots;
    }
}