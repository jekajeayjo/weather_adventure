package md.weatherAdventure.service;

public interface ModelMapperService<T,E> {
    T entityToDto (E entity);
    E dtoToEntity(T dto);
}
