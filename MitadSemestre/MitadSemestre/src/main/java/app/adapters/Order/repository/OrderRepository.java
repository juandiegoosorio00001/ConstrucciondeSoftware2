package app.adapters.Order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.adapters.Order.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	Optional<OrderEntity> findByPet_PetId(Long petId);
	Optional<OrderEntity> findByVeterinarian_UserId(Long veterinarianId);
	
}
