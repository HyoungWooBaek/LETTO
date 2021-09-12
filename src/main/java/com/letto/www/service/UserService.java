package com.letto.www.service;

import com.letto.www.domain.entity.UserInfo;
import com.letto.www.domain.repository.UserRepository;
import com.letto.www.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public Long save(UserInfoDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(UserInfo.builder().userID(infoDto.getUserID())
        .auth(infoDto.getAuth())
        .password(infoDto.getPassword()).build()).getCode();
    }

    @Override
    public UserInfo loadUserByUsername(String userID) throws UsernameNotFoundException {
        return userRepository.findByUserID(userID)
                .orElseThrow(() -> new UsernameNotFoundException((userID)));
    }
}
