Steps to create and issue a token
    1- Used JWT to create token (it's a fake token at this step)
    2- When a token gets decoded, its actually needs to get decoded into some UserPrincipal
        2.1 We created a UserPrincipal class for this
    3- Spring wraps UserPrincipal into a AuthenticationToken
        3.1 We created a custom UserPrincipalAuthenticationToken class for this
    4- Next decoding the token string into actual decoded token
        4.1 We created JwtDecoder class for this
    5- Next convert this decoded-token into user-principal
        5.1 We created JwtToPrincipalConverter class for this
    6- Finally needs to bring all these stuff together
        6.1 We created JwtAuthenticationFilter class
            6.1.1 Extract the token from authorization header from requests
            6.1.2 extracting token from request header
            6.1.3 decoding string token in jwt
            6.1.4 converting decoded token into a principal
            6.1.5 principal wrapped into a AuthenticationToken
            6.1.6 Check if its present
    7- Inject this JwtAuthenticationFilter into your WebSecurityConfig class (This will spring aware of this filter)
    -------------------- Fake token done ----------------------
    8- CustomUserDetailService which implement UserDetailsService
        8.1 (UserDetailsService) used by spring security to lead user specific data into framework
    9- Next need to connect this CustomUserDetailService to your WebSecurityConfig