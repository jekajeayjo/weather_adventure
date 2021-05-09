package md.weatherAdventure.service;

import java.util.List;
import java.util.Map;

public interface ModelMapperService<D,E> {
    D entityToDto (E entity);
    E dtoToEntity(D dto);
    E FromMapToEntity(Map map);
}
