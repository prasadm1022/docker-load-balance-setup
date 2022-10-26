package org.upwork.prototype.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse
{
    private String token;
    private Long tokenExpireTime;
    private String refreshToken;
    private Long refreshTokenExpireTime;

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;
        JwtResponse that = ( JwtResponse ) o;
        return Objects.equals( token, that.token )
                       && Objects.equals( tokenExpireTime, that.tokenExpireTime )
                       && Objects.equals( refreshToken, that.refreshToken )
                       && Objects.equals( refreshTokenExpireTime, that.refreshTokenExpireTime );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( token, tokenExpireTime, refreshToken, refreshTokenExpireTime );
    }
}
