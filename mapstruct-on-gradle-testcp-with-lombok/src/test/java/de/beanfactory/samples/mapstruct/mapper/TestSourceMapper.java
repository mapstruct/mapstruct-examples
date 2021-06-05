package de.beanfactory.samples.mapstruct.mapper;

import de.beanfactory.samples.mapstruct.model.TestSourceBean;
import de.beanfactory.samples.mapstruct.model.TestTargetBean;
import org.mapstruct.Mapper;

@Mapper
public interface TestSourceMapper {

    TestTargetBean map(TestSourceBean testSource);
}
