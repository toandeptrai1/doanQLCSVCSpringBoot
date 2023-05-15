package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.dto.ApiResponse;
import com.doan.QLCSVC.dto.UserRequest;
import com.doan.QLCSVC.dto.UserResponse;
import com.doan.QLCSVC.model.ChucVu;
import com.doan.QLCSVC.model.Role;
import com.doan.QLCSVC.model.User;
import com.doan.QLCSVC.service.ChucVuServiceImpl;
import com.doan.QLCSVC.service.UserServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("/QLCSVC/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    private final ChucVuServiceImpl chucVuService;


    @PostMapping("/getAll")
    public ResponseEntity<ApiResponse> getUsers(@RequestBody UserRequest userRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",userService.getUsers(userRequest)) )
                .build();

        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteUser(@RequestBody Long id){
        return ResponseEntity.ok().body(userService.deleteUser(id));

    }
    @PostMapping("/role/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        return ResponseEntity.ok().body(userService.saveRole(role));
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getUser/{username}")
    public ResponseEntity<UserResponse> getUserByUserName( @PathVariable String username){

        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updateUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.updateUser(user));
    }
    @PostMapping("changePassword")
    public ResponseEntity<Boolean> changePassword(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(userService.changePassword(userRequest));
    }
    @PostMapping("/addPhongToUser")
    public ResponseEntity<Boolean> addPhongToUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(userService.addPhongToUser(userRequest.getUserID(), userRequest.getMaPhong()));
    }
    @PostMapping("/removePhongFromUser")
    public ResponseEntity<Boolean> removePhongFromUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(userService.removePhongFromUser(userRequest.getUserID(), userRequest.getMaPhong()));
    }
    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles(){

        return ResponseEntity.ok().body(userService.getRoles());
    }
    @GetMapping("/chucvus")
    public ResponseEntity<List<ChucVu>> getChucVus(){
        return ResponseEntity.ok().body(chucVuService.getChucVus());
    }






}
@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
