package docker.common.service;

import docker.common.entity.CounterEntity;
import docker.common.mapper.CounterMapper;
import docker.common.repository.CounterRepository;
import java.time.LocalDate;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounterService {

    private final CounterRepository counterRepository;
    private final CounterMapper mapper = Mappers.getMapper(CounterMapper.class);

    @Transactional
    public String getCounter() {
        var today = LocalDate.now();
        var counter = counterRepository.findByDate(today);
        long count = 1;
        CounterEntity entity;
        if (counter.isPresent()) {
            entity = mapper.toEntity(counter.get());
            count = entity.getCount();
        } else {
            entity = CounterEntity.builder()
                    .count(count)
                    .date(today)
                    .build();
        }
        counterRepository.save(entity);
        return String.format("Hello the counter is %s for %s", count, today);
    }


}
