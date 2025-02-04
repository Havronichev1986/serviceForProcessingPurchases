package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entitties.UsersEntity;
import org.example.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = userRepository.findByUserName(username);

        if (user == null){ throw new UsernameNotFoundException("Пользователь не существует");}
        return user;
    }

    public List<UsersEntity> allUsers(){return userRepository.findAll();}

    public UsersEntity findUserById(Long userId){
        Optional<UsersEntity> userFromDataBase = userRepository.findById(userId);
        return userFromDataBase.orElse(new UsersEntity());
    }

    public boolean saveUser(UsersEntity usersEntity){
        UsersEntity userFromDb = userRepository.findByUserName(usersEntity.getUsername());
        if (userFromDb != null){
            return false;
        }
        userRepository.save(usersEntity);
        return true;
    }
    public boolean deleteUser(Long userId){
        if (userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
    public List<UsersEntity> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", UsersEntity.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
