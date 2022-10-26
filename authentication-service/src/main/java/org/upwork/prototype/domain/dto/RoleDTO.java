package org.upwork.prototype.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * Role DTO
 *
 * @author prasadm
 * @since 14 June 2022
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO
{
    private Long id;
    private String name;

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;
        RoleDTO roleDTO = ( RoleDTO ) o;
        return id == roleDTO.id
                       && Objects.equals( name, roleDTO.name );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, name );
    }
}
