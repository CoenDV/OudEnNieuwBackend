package com.CoenDV.OudNieuw.Services;

import com.CoenDV.OudNieuw.Models.DTO.BuyRequest;
import com.CoenDV.OudNieuw.Models.ShopItem;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Repositories.ShopRepository;
import com.CoenDV.OudNieuw.Repositories.UserRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    ShopRepository shopRepository;
    UserRepository userRepository;

    private SimpMessagingTemplate template;

    public ShopService(ShopRepository shopRepository, UserRepository userRepository, SimpMessagingTemplate template) {
        this.shopRepository = shopRepository;
        this.userRepository = userRepository;
        this.template = template;
    }

    public List<ShopItem> getShopItems() {
        return shopRepository.findAll();
    }

    @SendTo("/topic/quiz-mainscreen")
    public User buyItem(BuyRequest item) {
        Optional<ShopItem> shopItem = shopRepository.findById(item.getItemId());
        Optional<User> user = userRepository.findById(item.getUserId());

        if (shopItem.isPresent() && user.isPresent()) {
            ShopItem si = shopItem.get();
            User u = user.get();

            if (u.getPoints() >= si.getPoints()) {
                u.setPoints(u.getPoints() - si.getPoints());

                template.convertAndSend("/topic/quiz-mainscreen", si);
                return userRepository.save(u);
            }
        }

        return null;
    }
}
