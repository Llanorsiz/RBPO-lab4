package kurban.softwareProducts.common.security;

import kurban.softwareProducts.common.exception.base.UnauthorizedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static CustomUserDetails getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated() || !(authentication.getPrincipal() instanceof CustomUserDetails)){
            throw new UnauthorizedException();
        }
        return (CustomUserDetails) authentication.getPrincipal();
    }
    public static Long getCurrentUserId(){
        return getCurrentUser().getId();
    }
    public static boolean isAdmin(){
        return getCurrentUser().getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

    }
}
