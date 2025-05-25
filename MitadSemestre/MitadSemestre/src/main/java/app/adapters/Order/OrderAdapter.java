package app.adapters.Order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.MedicalHistory.entity.MedicalHistoryEntity;
import app.adapters.MedicalHistory.repository.MedicalHistoryRepository;
import app.adapters.Order.entity.OrderEntity;
import app.adapters.Order.repository.OrderRepository;
import app.adapters.person.entity.PersonEntity;
import app.adapters.person.repository.PersonRepository;
import app.adapters.pet.entity.PetEntity;
import app.adapters.pet.repository.PetRepository;
import app.adapters.user.entity.UserEntity;
import app.adapters.user.repository.UserRepository;
import app.domain.models.MedicalHistory;
import app.domain.models.Order;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.OrderPort;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderAdapter implements OrderPort {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserRepository userRepository; 
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository; 

    @Override
    public void saveOrder(Order order) {
        OrderEntity orderEntity = toEntity(order);
        orderRepository.save(orderEntity);
        order.setOrderId(orderEntity.getOrderId());
    }

    @Override
    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(this::toDomain)
                .orElse(null);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findOrdersByPetId(Long petId) {
        return orderRepository.findByPet_PetId(petId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findOrdersByVeterinarianId(Long veterinarianId) {
        return orderRepository.findByVeterinarian_UserId(veterinarianId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    @Override
    public void updateOrder(Order order) {
        OrderEntity existingOrder = orderRepository.findById(order.getOrderId())
                .orElseThrow(() -> new EntityNotFoundException("Orden no encontrada con ID: " + order.getOrderId()));
        existingOrder.setMedicationName(order.getMedicationName());
        existingOrder.setMedicationDosage(order.getMedicationDosage());
        existingOrder.setOrderStatus(order.getOrderStatus());
        existingOrder.setCancellationReason(order.getCancellationReason());
        existingOrder.setCancellationDate(order.getCancellationDate());

        orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new EntityNotFoundException("Orden no encontrada con ID: " + orderId);
        }
        orderRepository.deleteById(orderId);
    }
    private OrderEntity toEntity(Order domain) {
        OrderEntity entity = new OrderEntity();
        if (domain.getOrderId() != null) {
            entity.setOrderId(domain.getOrderId());
        }
        PetEntity petEntity = petRepository.findById(domain.getPet().getPetId())
                .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada con ID: " + domain.getPet().getPetId()));
        PersonEntity ownerEntity = personRepository.findById(domain.getOwner().getPersonId())
                .orElseThrow(() -> new EntityNotFoundException("Dueño no encontrado con ID: " + domain.getOwner().getPersonId()));
        UserEntity veterinarianEntity = userRepository.findById(domain.getVeterinarian().getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Veterinario no encontrado con ID: " + domain.getVeterinarian().getUserId()));
        MedicalHistoryEntity medicalHistoryEntity = medicalHistoryRepository.findById(domain.getMedicalHistory().getId())
                .orElseThrow(() -> new EntityNotFoundException("Historia médica no encontrada con ID: " + domain.getMedicalHistory().getId()));

        entity.setPet(petEntity);
        entity.setOwner(ownerEntity);
        entity.setVeterinarian(veterinarianEntity);
        entity.setMedicalHistory(medicalHistoryEntity);

        entity.setMedicationName(domain.getMedicationName());
        entity.setMedicationDosage(domain.getMedicationDosage());
        entity.setGenerationDate(domain.getGenerationDate());
        entity.setOrderStatus(domain.getOrderStatus());
        entity.setCancellationReason(domain.getCancellationReason());
        entity.setCancellationDate(domain.getCancellationDate());

        return entity;
    }
    private Order toDomain(OrderEntity entity) {
        Order domain = new Order();
        domain.setOrderId(entity.getOrderId());
        if (entity.getPet() != null) {
            Pet petDomain = new Pet();
            petDomain.setPetId(entity.getPet().getPetId());
            petDomain.setPetName(entity.getPet().getPetName());
            domain.setPet(petDomain);
        }
        if (entity.getOwner() != null) {
            Person ownerDomain = new Person();
            ownerDomain.setPersonId(entity.getOwner().getPersonId());
            ownerDomain.setDocument(entity.getOwner().getDocument());
            ownerDomain.setName(entity.getOwner().getName());
            domain.setOwner(ownerDomain);
        }
        if (entity.getVeterinarian() != null) {
            User veterinarianDomain = new User();
            veterinarianDomain.setUserId(entity.getVeterinarian().getUserId());
            veterinarianDomain.setUserName(entity.getVeterinarian().getUserName());
            // Map more user fields if needed
            domain.setVeterinarian(veterinarianDomain);
        }
        if (entity.getMedicalHistory() != null) {
            MedicalHistory medicalHistoryDomain = new MedicalHistory();
            medicalHistoryDomain.setId(entity.getMedicalHistory().getId());
            domain.setMedicalHistory(medicalHistoryDomain);
        }

        domain.setMedicationName(entity.getMedicationName());
        domain.setMedicationDosage(entity.getMedicationDosage());
        domain.setGenerationDate(entity.getGenerationDate());
        domain.setOrderStatus(entity.getOrderStatus());
        domain.setCancellationReason(entity.getCancellationReason());
        domain.setCancellationDate(entity.getCancellationDate());

        return domain;
    }
}