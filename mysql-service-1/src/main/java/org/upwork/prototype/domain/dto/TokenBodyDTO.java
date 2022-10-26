package org.upwork.prototype.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenBodyDTO
{
    private String token;

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;
        TokenBodyDTO that = ( TokenBodyDTO ) o;
        return Objects.equals( token, that.token );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( token );
    }
}
