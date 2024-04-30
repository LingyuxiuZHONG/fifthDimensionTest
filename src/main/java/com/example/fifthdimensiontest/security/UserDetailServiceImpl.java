package com.example.fifthdimensiontest.security;

import com.example.fifthdimensiontest.entity.User;
import com.example.fifthdimensiontest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService 是用于加载用户详细信息的接口
 * 定义一种标准的方法，从数据源中加载用户信息
 * 并返回一个包含用户详细信息的UserDetails对象
 *
 * 通常需要实现 UserDetailsService 接口，并重写其中的 loadUserByUsername 方法，
 * 根据实际业务需求从数据源中加载用户信息并返回 UserDetails 对象
 */
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserService userService;

    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByName(username);
        return new UserDetailsImpl(user);
    }
}
