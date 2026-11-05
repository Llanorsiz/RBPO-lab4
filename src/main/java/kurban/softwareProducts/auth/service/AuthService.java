package kurban.softwareProducts.auth.service;

import kurban.softwareProducts.auth.web.request.RegisterRequest;
import kurban.softwareProducts.common.exception.base.BadRequestException;
import kurban.softwareProducts.common.exception.base.ConflictException;
import kurban.softwareProducts.user.mapper.UserMapper;
import kurban.softwareProducts.user.model.User;
import kurban.softwareProducts.user.repository.UserRepository;
import kurban.softwareProducts.user.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    @Transactional
    public UserResponse register(RegisterRequest request){
        if(!StringUtils.hasText(request.getUsername())){
            throw new BadRequestException("Имя пользователя пустое");
        }
        if(!StringUtils.hasText((request.getPassword()))){
            throw new BadRequestException("Пароль пустой");
        }
        if(userRepository.existsByUsername(request.getUsername())){
            throw new ConflictException("Имя уже существует");
        }
        if(request.getPassword().length()<8){
            throw new BadRequestException("Длина пароля не подходит");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}
