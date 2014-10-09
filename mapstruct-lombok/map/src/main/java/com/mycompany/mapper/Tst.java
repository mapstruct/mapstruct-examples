package com.mycompany.mapper;

import com.mycompany.dto.Source;
import com.mycompany.entities.Target;

public class Tst {

    public static void main( String[] args ) {
        Source s = new Source();
        s.setTest( "5" );

        Target t = STMapper.MAPPER.toTarget( s );
        System.out.println( t.getTesting() );
    }
}
