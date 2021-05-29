package edu.depaul.cdm.se452.group2.campusdisconnect.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

        private static final Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

        @Autowired
        private UserRepository userRepository;

        @Transactional(readOnly = true)
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            DisconnectUser user = userRepository.getDisconnectUserByStudentId(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found.");
            }
            log.info("loadUserByUsername() : {}", username);
            return new UserDetailImpl(user);
        }
}
