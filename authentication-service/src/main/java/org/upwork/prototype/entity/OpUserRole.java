package org.upwork.prototype.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * User Role Entity
 *
 * @author prasadm
 * @since 14 June 2022
 */

@Entity
@Getter
@Setter
@Table( name = "OP_USER_ROLE" )
public class OpUserRole implements Serializable
{
    @EmbeddedId
    private OpUserRolePK opUserRolePK = new OpUserRolePK();

    @MapsId( "userId" )
    @ManyToOne( fetch = FetchType.LAZY, cascade = { CascadeType.ALL } )
    @JoinColumn( name = "USER_ID", referencedColumnName = "ID" )
    private OpUser opUser;

    @MapsId( "roleId" )
    @ManyToOne( fetch = FetchType.LAZY, cascade = { CascadeType.ALL } )
    @JoinColumn( name = "ROLE_ID", referencedColumnName = "ID" )
    private OpRole opRole;

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;
        OpUserRole that = ( OpUserRole ) o;
        return Objects.equals( opUserRolePK, that.opUserRolePK )
                       && Objects.equals( opUser, that.opUser )
                       && Objects.equals( opRole, that.opRole );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( opUserRolePK, opUser, opRole );
    }
}
