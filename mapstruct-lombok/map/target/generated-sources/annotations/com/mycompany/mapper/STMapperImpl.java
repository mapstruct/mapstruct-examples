package com.mycompany.mapper;

import com.mycompany.dto.Source;
import com.mycompany.entities.Target;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2014-10-08T22:05:04+0200"
)
public class STMapperImpl implements STMapper {

    @Override
    public Target toTarget(Source s)  {
        if ( s == null ) {
            return null;
        }

        Target target = new Target();
        if ( s.getTest() != null ) {
            target.setTesting( Long.parseLong( s.getTest() ) );
        }

        return target;
    }

}
