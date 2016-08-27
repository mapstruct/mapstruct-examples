package org.mapstruct.example.mapper;

import javax.annotation.Generated;
import org.mapstruct.example.dto.MammalDto;
import org.mapstruct.example.dto.MammalEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2016-02-09T23:06:02+0100",
    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_05 (Oracle Corporation)"
)
public class SourceTargetMapperImpl implements SourceTargetMapper {

    @Override
    public void toTarget(MammalDto source, Long numberOfStomachs, MammalEntity target) {
        if ( source == null && numberOfStomachs == null ) {
            return;
        }

        if ( source != null ) {
            if ( source.getNumberOfLegs() != null ) {
                target.setNumberOfLegs( source.getNumberOfLegs().longValue() );
            }
        }
        if ( numberOfStomachs != null ) {
            target.setNumberOfStomachs( numberOfStomachs );
        }
    }
}
