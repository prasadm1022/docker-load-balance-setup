package org.upwork.prototype.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * User DTO
 *
 * @author prasadm
 * @since 14 June 2022
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO
{
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private List<String> roles = new ArrayList<>();

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;
        UserDTO userDTO = ( UserDTO ) o;
        return id == userDTO.id
                       && Objects.equals( name, userDTO.name )
                       && Objects.equals( username, userDTO.username )
                       && Objects.equals( email, userDTO.email )
                       && Objects.equals( password, userDTO.password )
                       && Objects.equals( roles, userDTO.roles );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, name, username, email, password, roles );
    }
}
