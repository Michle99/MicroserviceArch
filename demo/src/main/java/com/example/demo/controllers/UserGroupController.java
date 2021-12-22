// package com.example.demo.controllers;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.demo.repository.UserGroupRepository;
// import com.example.demo.entity.UserGroup;
// import java.util.List;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import com.example.demo.repository.UserRepository;
// import javax.validation.Valid;

// @RestController
// public class UserGroupController {
    
//     @Autowired
//     private UserGroupRepository usergroupRepository;

//     @Autowired
//     private UserRepository userRepository;

//     @GetMapping("/groups")
//     public List<UserGroup> getGroupDetails() {
//         List<UserGroup> groupResponse = (List<UserGroup>) usergroupRepository.findAll();

//         return groupResponse;
//     }

//     // @PostMapping("/groups")
//     // public List<UserGroup> addGroups() {
//     //     List<UserGroup> addingGroups = (List<UserGroup>) usergroupRepository.saveAll();

//     //     return addingGroups;
//     // }
// }
