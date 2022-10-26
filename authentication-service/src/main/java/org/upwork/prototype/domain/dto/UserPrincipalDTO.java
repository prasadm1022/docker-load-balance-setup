package org.upwork.prototype.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * User Principal
 *
 * @author prasadm
 * @since 14 June 2022
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipalDTO
{
    private Long id;
    private String name;
    private String username;
    private String email;
    private String token;
    private Collection<? extends GrantedAuthority> authorities = new ArrayList<>();

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;
        UserPrincipalDTO that = ( UserPrincipalDTO ) o;
        return Objects.equals( id, that.id )
                       && Objects.equals( name, that.name )
                       && Objects.equals( username, that.username )
                       && Objects.equals( email, that.email )
                       && Objects.equals( token, that.token )
                       && Objects.equals( authorities, that.authorities );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, name, username, email, token, authorities );
    }
}
