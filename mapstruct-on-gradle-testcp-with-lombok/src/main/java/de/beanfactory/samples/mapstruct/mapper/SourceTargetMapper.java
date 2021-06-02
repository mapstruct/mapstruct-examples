package de.beanfactory.samples.mapstruct.mapper;

import de.beanfactory.samples.mapstruct.model.SourceBean;
import de.beanfactory.samples.mapstruct.model.TargetBean;
import org.mapstruct.Mapper;

@Mapper
public interface SourceTargetMapper {

    public TargetBean map(SourceBean source);
}
