package org.upwork.prototype.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Role Entity
 *
 * @author prasadm
 * @since 14 June 2022
 */

@Entity
@Getter
@Setter
@Table( name = "OP_ROLE" )
public class OpRole implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "id_seq_role" )
    @SequenceGenerator( name = "id_seq_role", sequenceName = "ROLE_ID_SEQ", allocationSize = 1 )
    @Column( name = "ID" )
    private Long id;

    @Column( name = "NAME" )
    @Size( max = 128 )
    private String name;

    @OneToMany( mappedBy = "opRole", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER )
    private List<OpUserRole> opUserRoles = new ArrayList<>();

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;
        OpRole role = ( OpRole ) o;
        return Objects.equals( id, role.id )
                       && name == role.name
                       && Objects.equals( opUserRoles, role.opUserRoles );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, name, opUserRoles );
    }
}
