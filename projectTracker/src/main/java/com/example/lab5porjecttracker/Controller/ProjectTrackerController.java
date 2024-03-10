package com.example.lab5porjecttracker.Controller;

import com.example.lab5porjecttracker.ApiResponse.ApiResponse;
import com.example.lab5porjecttracker.Model.ProjectTracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project-tracker")
public class ProjectTrackerController {
    ArrayList<ProjectTracker> projects = new ArrayList<>();

    @PostMapping("/create")
    public ApiResponse create(@RequestBody ProjectTracker project){
        projects.add(project);
        return new ApiResponse("project added");
    }
    @GetMapping("/projects")
    public ArrayList<ProjectTracker> displayAll(){
        return projects;
    }
    @PutMapping("/{id}/update")
    public ApiResponse update(@PathVariable String id, @RequestBody ProjectTracker project){
        for(int i=0; i<projects.size();i++){
            if(projects.get(i).getID().equalsIgnoreCase(id)){
                projects.set(i,project);
                return new ApiResponse("project updated");
            }
        }
        return new ApiResponse("there is no project by that id");
    }
    @DeleteMapping("/{index}/remove")
    public ApiResponse remove(@PathVariable int index){
        projects.remove(index);
        return new ApiResponse("project removed");
    }
    @PutMapping("/{id}/change-status")
    public ApiResponse changeStatus(@PathVariable String id){

            for(ProjectTracker p:projects){
                if(p.getID().equalsIgnoreCase(id)){
                    p.setStatus("done");
                    return new ApiResponse("status changed to done");
                }
            }
        return new ApiResponse("status already done");
    }
    @GetMapping("/{title}/search")
    public ProjectTracker searchProject(@PathVariable String title){
        for(ProjectTracker p:projects){
            if(p.getTitle().equalsIgnoreCase(title)){
                return p;
            }
        }
        return null;
    }
    @GetMapping("/{company}/search-by-company")
    public ArrayList<ProjectTracker> searchByCompany(@PathVariable String company){
        ArrayList<ProjectTracker> projectsByCompany = new ArrayList<>();
        for(ProjectTracker p:projects){
            if(p.getCompanyName().equalsIgnoreCase(company)){
                projectsByCompany.add(p);
            }
        }
        return projectsByCompany;
    }

}
