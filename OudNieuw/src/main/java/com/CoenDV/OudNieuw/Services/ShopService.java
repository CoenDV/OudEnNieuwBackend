package com.CoenDV.OudNieuw.Services;

import com.CoenDV.OudNieuw.Models.DTO.BuyRequest;
import com.CoenDV.OudNieuw.Models.ShopItem;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Repositories.ShopRepository;
import com.CoenDV.OudNieuw.Repositories.UserRepository;
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

        if (shopItem.isEmpty() || user.isEmpty()) {
            throw new IllegalArgumentException("ShopItem or User not found");
        }

        ShopItem si = shopItem.get();
        User u = user.get();

        if (u.getPoints() >= si.getPoints()) {
            u.setPoints(u.getPoints() - si.getPoints());

            template.convertAndSend("/topic/quiz-mainscreen", si);
            return userRepository.save(u);
        }

        return null;
    }

    public User buyMysteryBox(BuyRequest item) {
        Optional<User> user = userRepository.findById(item.getUserId());
        Optional<ShopItem> shopItem = shopRepository.findById(item.getItemId());

        if (user.isEmpty() || shopItem.isEmpty()) {
            throw new IllegalArgumentException("User or Shop Item not found");
        }

        User u = user.get();
        List<ShopItem> shopItems = getShopItems();
        ShopItem si = getShopItems().stream().toList().get((int) (Math.random() * shopItems.size()-1)); // Get random item from shop

        if (u.getPoints() >= shopItem.get().getPoints()) {
            u.setPoints(u.getPoints() - shopItem.get().getPoints());

            template.convertAndSend("/topic/quiz-mainscreen", si);
            return userRepository.save(u);
        }

        return null;
    }
}
