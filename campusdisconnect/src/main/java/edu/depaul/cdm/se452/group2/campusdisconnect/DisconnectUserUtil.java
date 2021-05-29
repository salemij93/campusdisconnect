package edu.depaul.cdm.se452.group2.campusdisconnect;

import edu.depaul.cdm.se452.group2.campusdisconnect.user.DisconnectUser;
import edu.depaul.cdm.se452.group2.campusdisconnect.user.UserDetailImpl;
import org.springframework.security.core.context.SecurityContextHolder;

public class DisconnectUserUtil {

    public static Long getDisconnectUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetailImpl ud = (UserDetailImpl) principal;
        return ud.getId();
    }

    public static String getDisconnectUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetailImpl ud = (UserDetailImpl) principal;
        return ud.getUsername();
    }


}
