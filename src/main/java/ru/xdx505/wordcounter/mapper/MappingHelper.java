package ru.xdx505.wordcounter.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MappingHelper {
    @Autowired
    private ModelMapper mapper;

    /**
     * Мапит объект в Destination
     *
     * @param source          Объект.
     * @param destinationType Тип в который мапим.
     * @param <D>             Тип в который мапим.
     * @return Конечная сущность.
     */
    public <D, S> D map(S source, Class<D> destinationType) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(destinationType);
        return this.mapper.map(source, destinationType);
    }

    /**
     * Мапит коллекцию в Destination
     *
     * @param source          Коллекция объектов.
     * @param destinationType Тип в который мапим.
     * @param <D>             Тип в который мапим.
     * @return Коллекция сущностей.
     */
    public <D, S> List<D> map(Collection<S> source, Class<D> destinationType) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(destinationType);
        return source.stream()
                .map(element -> this.map(element, destinationType))
                .collect(Collectors.toList());
    }
}
