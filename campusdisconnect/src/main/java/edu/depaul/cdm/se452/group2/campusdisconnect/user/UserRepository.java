package edu.depaul.cdm.se452.group2.campusdisconnect.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<DisconnectUser, Long> {
    DisconnectUser getDisconnectUserByStudentId(String studentId);
}
