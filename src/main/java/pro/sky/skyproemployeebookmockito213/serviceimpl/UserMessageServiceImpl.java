package pro.sky.skyproemployeebookmockito213.serviceimpl;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebookmockito213.service.UserMessageService;

@Service
public class UserMessageServiceImpl implements UserMessageService {
    @Override
    public String showGreeting() {
        return "Добро пожаловать!";
    }
}
