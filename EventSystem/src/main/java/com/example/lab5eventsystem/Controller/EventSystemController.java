package com.example.lab5eventsystem.Controller;

import com.example.lab5eventsystem.ApiResponse.ApiResponse;
import com.example.lab5eventsystem.Model.EventSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event-tracker")
public class EventSystemController {
    ArrayList<EventSystem> events = new ArrayList<>();

    @PostMapping("/create")
    public ApiResponse createEvent(@RequestBody EventSystem event){
        events.add(event);
        return new ApiResponse("event added");
    }
    @GetMapping("/events")
    public ArrayList<EventSystem> displayAll(){
        return events;
    }


    @GetMapping("/{id}/get")
    public EventSystem getEventByID(@PathVariable String id){
        for(EventSystem e:events){
            if(e.getID().equalsIgnoreCase(id)){
                return e;
            }
        }
        return null;
    }
    @PutMapping("/{id}/update")
    public ApiResponse updateEvent(@PathVariable String id,@RequestBody EventSystem event){
        for(int i=0; i<events.size();i++){
            if(events.get(i).getID().equalsIgnoreCase(id)){
                events.set(i,event);
                return new ApiResponse("event updated");
            }
        }
        return new ApiResponse("there is no event by that id");
    }

    @DeleteMapping("/{id}/delete")
    public ApiResponse deleteEvent(@PathVariable String id){
        for(int i = 0; i<events.size(); i++){
            if(events.get(i).getID().equalsIgnoreCase(id)){
                events.remove(i);
                return new ApiResponse("event removed");
            }
        }
        return new ApiResponse("there is no event with given id");
    }

    @PutMapping("/{id}/{capacity}/change-capacity")
    public ApiResponse changeCapacity(@PathVariable String id, @PathVariable int capacity){
        for (EventSystem event : events) {
            if (event.getID().equalsIgnoreCase(id)) {
                event.setCapacity(capacity);
                return new ApiResponse("capacity changed");
            }
        }
        return new ApiResponse("there is no event by that id");
    }
}
