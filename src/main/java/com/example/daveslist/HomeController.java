package com.example.daveslist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    public static long idCounter = 0;

    ArrayList<Room> rooms = new ArrayList<>();


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/roomForm")
    public String enterRoom(Model model){
        model.addAttribute("room", new Room());
        return "roomform";
    }

    @PostMapping("/displayRoom")
    public String displayRoom(@Valid Room room, BindingResult result){
        if (result.hasErrors()){
            System.out.println("There was error");
            return "roomform";
        }else {
            rooms.add(room);
            System.out.println("There was no error");
            return "displayroom";
        }
    }
    @RequestMapping("/allRooms")
    public String showAll(Model model){
        model.addAttribute("rooms", rooms);
        return "allrooms";
    }
    @RequestMapping("/update/{id}")
    public String updateRoom(@PathVariable("id") long id, Model model){
        for(Room room: rooms){
            if(id == room.getId()){
                model.addAttribute("room", room);
                break;
            }
        }
        return "roomform";
    }
   static void idSetter(Room room){
        idCounter = idCounter + 1;
        room.setId(idCounter);
   }

}
