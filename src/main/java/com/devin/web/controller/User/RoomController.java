package com.devin.web.controller.User;

import com.devin.repository.dao.ChatRoomDao;
import com.devin.repository.dao.RoomsUserDao;
import com.devin.repository.dao.UserRoomsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author: simpl
 * @date: 2020/2/25
 * @time: 16:55
 * @description: 
 */


//解决跨域的注解
@CrossOrigin
@Controller
public class RoomController {


    @Autowired
    private ChatRoomDao chatRoomDao;

    @Autowired
    private UserRoomsDao userRoomsDao;

    @Autowired
    private RoomsUserDao roomsUserDao;


    @CrossOrigin
    @GetMapping
    @RequestMapping(value = "/all/room/list")
    public ResponseEntity<Map<String, String>> roomList() {
        return new ResponseEntity<Map<String, String>>(chatRoomDao.roomList(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping
    @RequestMapping(value = "/user/room/list")
    public ResponseEntity<List<String>> userRoomList(@RequestParam("username") String username) {
        return new ResponseEntity<List<String>>(userRoomsDao.userChatRooms(username), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping
    @RequestMapping(value = "/room/user/list")
    public ResponseEntity<List<String>> roomUserList(@RequestParam("chatroom") String chatroom) {
        return new ResponseEntity<List<String>>(roomsUserDao.chatRoomsUsers(chatroom), HttpStatus.OK);
    }

}
