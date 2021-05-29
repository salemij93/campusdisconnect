package edu.depaul.cdm.se452.group2.campusdisconnect.task;

import edu.depaul.cdm.se452.group2.campusdisconnect.DisconnectUserUtil;
import edu.depaul.cdm.se452.group2.campusdisconnect.user.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskNoSQLRepository taskNoSQLRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/create")
    public TaskNoSQL newTask(@RequestBody TaskNoSQL newTask) {
        return taskNoSQLRepository.save(newTask);


    }

    @GetMapping("/getTaskInfo")
    public String getTaskInfo(Model model) {
        Long disconnectUserId = DisconnectUserUtil.getDisconnectUserId();

        TaskNoSQL task = Optional.ofNullable(taskNoSQLRepository.findBysid(disconnectUserId)).orElse(new TaskNoSQL());
        model.addAttribute("id", disconnectUserId);
        model.addAttribute("task", task);
        return "mytask";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/updateTask/{id}")
    public void updateTask(@RequestBody TaskNoSQL newTask) {

        taskNoSQLRepository.save(newTask);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/deleteTask/{id}/{cid}")
    public void deleteTask(@PathVariable Long id, @PathVariable String taskid) {
        TaskNoSQL taskNoSQL = taskNoSQLRepository.findBysid(id);
        taskNoSQL.getTaskList().remove(taskid);


    }


}
