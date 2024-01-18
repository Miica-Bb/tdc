package com.mycompany.mascotas.logica;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-27T18:16:27", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Perro.class)
public class Perro_ { 

    public static volatile SingularAttribute<Perro, Date> fechaNac;
    public static volatile SingularAttribute<Perro, String> raza;
    public static volatile SingularAttribute<Perro, Integer> id;
    public static volatile SingularAttribute<Perro, String> nombre;

}