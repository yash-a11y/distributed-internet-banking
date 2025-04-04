package com.yas.Banking_user_service.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class mapper<E,D> {

    public abstract E convertToEntity(D dto, Object... args);

    public abstract D convertToDto(E entity, Object... args);

    public Collection<E> convertToEntity(Collection<D> dto, Object... args){
        return dto.stream().map(
                d-> convertToEntity(d,args)
        ).collect(Collectors.toList());
    }
}
