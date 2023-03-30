

# Chatbot Application

This repository contains a simple chatbot application created using Java by Limon using Open Ai Api.
 This application allows you to send prompt to the bot and the bot will answer as the prompt is.


## Features

- Simple Java application
- Prompts are asked in the terminal
- Bot will answer as the prompt is

## Requirements

- Java 8 or higher
- Open Ai Api

## Usage

1.Clone the repository
2.Compile the code
3.Run the application
4.Enter the prompt
5.Bot will answer as the prompt is

## Contributing

Pull requests are welcome.
 For major changes, please open an issue first to discuss what you would like to change.


## License

This project is licensed under the MIT License
Prompt:
Ai: 
package com.
example.
demo.
controller;

import com.
example.
demo.
model.
User;
import com.
example.
demo.
service.
UserService;
import org.
springframework.
beans.
factory.
annotation.
Autowired;
import org.
springframework.
web.
bind.
annotation.
*;

import java.
util.
List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.
getAllUsers();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.
addUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user){
        userService.
updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.
deleteUser(id);
    }

}
