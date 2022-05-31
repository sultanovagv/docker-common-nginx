package docker.common.mapper;

import docker.common.entity.CounterEntity;
import java.time.LocalDate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        imports = LocalDate.class)
public interface CounterMapper {

    @Mapping(target = "date", expression = "java(LocalDate.now())")
    @Mapping(target = "count", expression = "java(source.getCount()+1)")
    CounterEntity toEntity(CounterEntity source);
}
