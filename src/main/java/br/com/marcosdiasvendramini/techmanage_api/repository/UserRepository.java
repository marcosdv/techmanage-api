package br.com.marcosdiasvendramini.techmanage_api.repository;

import br.com.marcosdiasvendramini.techmanage_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
