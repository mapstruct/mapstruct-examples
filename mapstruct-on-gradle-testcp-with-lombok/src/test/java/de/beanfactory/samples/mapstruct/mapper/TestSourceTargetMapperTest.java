package de.beanfactory.samples.mapstruct.mapper;

import de.beanfactory.samples.mapstruct.model.SourceBean;
import de.beanfactory.samples.mapstruct.model.TargetBean;
import de.beanfactory.samples.mapstruct.model.TestSourceBean;
import de.beanfactory.samples.mapstruct.model.TestTargetBean;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSourceTargetMapperTest {

    @Test
    void itShouldMapTestSourceToTestTargetBean() {
        TestSourceMapper mapper = Mappers.getMapper(TestSourceMapper.class);

        TestSourceBean sourceBean = new TestSourceBean(0, "datastring");
        TestTargetBean targetBean = mapper.map(sourceBean);

        assertEquals(sourceBean.getId(), targetBean.getId());
        assertEquals(sourceBean.getData(), targetBean.getData());
    }

}