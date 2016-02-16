package com.todolist.service;

import com.todolist.domain.Action;
import com.todolist.domain.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by elena on 06.02.16.
 */
@Service
public class ActionService {
    @Autowired
    private ActionRepository actionRepository;

//    List<Action> actionsList = new ArrayList<>();//Нужно показывать список уже созданных дел
//
//    public List<Action> addActionToList(Action todoList){
//        actionsList.add(todoList);
//        return actionsList;
//    }

    public Action getAction (Long id){
        return actionRepository.findOne(id);
    }

    public Long addAction(Action action){  //добавлять новые
        //Action action = new Action(actionName, date, note);
        actionRepository.save(action);
        return action.getId();
    }

    public void editAction(Action action){  //редактировать
//        action.setAction(actionName);
//        action.setDate(date);
//        action.setIsMade(isMade);
//        action.setNote(note);
        actionRepository.save(action);
    }

    public void dellAction (Long id){   //удалять
        actionRepository.delete(id);
    }

    public Long changeIsMade(Long  id, Boolean isMade){  //отмечать как «Выполнено»
        Action action = actionRepository.findOne(id);
        action.setIsMade(isMade);
        actionRepository.save(action);
        return action.getId();
    }

    public Page<Action> findByIsMade (Pageable pegable, Boolean isMade){
        Page<Action> actionPage = actionRepository.findByIsMade(pegable, isMade);
        return actionPage;
    }

    public Page<Action> findAll(Pageable pegable){
        Page<Action> actionPage = actionRepository.findAll(pegable);
        return actionPage;
    }

//    public Page<Action> getActions(Pageable pageable){ //boolean isMade){
////
//        return actionRepository.findAll(pageable);
//    }


}


/*

Реализовать простенькое приложение todolist, для отображения списка дел.
Каждое из них можно , ,
Список можно фильтровать как
«Все дела», «Только невыполненные», «Выполненные».
Дела хранить в базе. Схему таблички для хранения нужно придумать самому (можно ограничиться одной таблицей,
можно разбить на несколько)
 */
