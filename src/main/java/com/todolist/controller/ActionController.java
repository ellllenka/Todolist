package com.todolist.controller;

import com.todolist.domain.Action;
import com.todolist.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by elena on 06.02.16.
 */
@Controller
public class ActionController {
    @Autowired
    ActionService actionService;

    @RequestMapping(value = "/action", method = RequestMethod.GET)
    @ResponseBody
    public Action getAction (Long id){
        return actionService.getAction(id);
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    @ResponseBody
    public Long addAction(@RequestBody Action action){
        return actionService.addAction(action);
    }

    @RequestMapping(value = "/action", method = RequestMethod.PUT)
    @ResponseBody
    public void editAction(Action action) {
        actionService.editAction(action);
    }

    @RequestMapping(value = "/action/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void dellAction (@PathVariable Long id) {
        actionService.dellAction(id);
    }

    @RequestMapping(value = "/action/isMade/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void changeIsMade(@PathVariable Long id) {
        actionService.changeIsMade(id, true);
    }

//    @RequestMapping(value = "/actions", method = RequestMethod.GET)
//    @ResponseBody
//    public Page<Action> getActions(Pageable pageable) {
//        return actionService.getActions(pageable);
//    }



    @RequestMapping(value = "/actions", method = RequestMethod.GET)
    @ResponseBody
    public Page<Action> getActions(Pageable pageable, Boolean isMade){
        if (isMade == null)
            return  actionService.findAll(pageable);
        else
            return actionService.findByIsMade(pageable, isMade);
    }



}
