package org.upwork.prototype.domain.response;

/**
 * @author prasadm
 * @since 14 June 2022
 */

public enum ErrorSource
{
    CLIENT_ERROR( 4 ),
    SERVER_ERROR( 5 );

    public final int code;

    ErrorSource( int code )
    {
        this.code = code;
    }
}
