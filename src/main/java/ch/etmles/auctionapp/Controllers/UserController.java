package ch.etmles.auctionapp.Controllers;

import ch.etmles.auctionapp.Entities.User;
import ch.etmles.auctionapp.Repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser); //TODO unique constraint exception !!!!
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setConnected(newUser.isConnected());
                    user.setWallet(newUser.getWallet());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @PutMapping("/users/{id}/isConnected")
    User updateIsConnected(@PathVariable Long id, @RequestBody Map<String, Boolean> isConnectedMap) {
    boolean isConnected = isConnectedMap.get("isConnected");
    return userRepository.findById(id)
            .map(user -> {
                user.setConnected(isConnected);
                return userRepository.save(user);
            })
            .orElseThrow(() -> new UserNotFoundException(id));
    }


    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    //TODO We need to talk about this route !
    @PostMapping("/users/{id}/credit")
    User creditWallet(@PathVariable Long id, @RequestBody BigDecimal amount) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setWallet(user.getWallet().add(amount));
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    //TODO We need to talk about this route, too !
    @PostMapping("/users/{id}/debit")
    User debitWallet(@PathVariable Long id, @RequestBody BigDecimal amount) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setWallet(user.getWallet().subtract(amount));
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
