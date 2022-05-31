package docker.common.repository;

import docker.common.entity.CounterEntity;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends JpaRepository<CounterEntity, Long> {

    Optional<CounterEntity> findByDate(LocalDate date);

}
