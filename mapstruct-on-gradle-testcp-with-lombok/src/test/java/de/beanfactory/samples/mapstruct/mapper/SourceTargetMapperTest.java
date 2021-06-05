package de.beanfactory.samples.mapstruct.mapper;

import de.beanfactory.samples.mapstruct.model.SourceBean;
import de.beanfactory.samples.mapstruct.model.TargetBean;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class SourceTargetMapperTest {

    @Test
    void itShouldMapSourceToTargetBean() {
        SourceTargetMapper mapper = Mappers.getMapper(SourceTargetMapper.class);

        SourceBean sourceBean = new SourceBean(0, "datastring");
        TargetBean targetBean = mapper.map(sourceBean);

        assertEquals(sourceBean.getId(), targetBean.getId());
        assertEquals(sourceBean.getData(), targetBean.getData());
    }

}