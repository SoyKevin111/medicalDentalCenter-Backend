package com.example.project.shared.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GeneralMapper {
   private final ModelMapper modelMapper = new ModelMapper();

   //entity to domain
   public <D, E> D toDomain(E entity, Class<D> domainClass){
      return modelMapper.map(entity, domainClass);
   }

   //domain to entity
   public <D, E> D toEntity(E domainObject, Class<D> entityClass){
      return modelMapper.map(domainObject, entityClass);
   }
}
