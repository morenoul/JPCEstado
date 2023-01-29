package com.example.jpcestado.view

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import com.example.jpcestado.model.Task
import com.example.jpcestado.provider.TaskProvider


class TaskViewModel: ViewModel() {
    private var _taskList = TaskProvider.tareas.toMutableStateList()

    private var count_id = 0

    fun gen_id(){
        var _aux = TaskProvider.aux.toMutableStateList()
        _aux.clear()

        _taskList.forEach {

            it.id = count_id
            _aux.add(it)
            count_id++
        }
        _taskList = _aux
    }



    val tasks: List<Task>
        get()= _taskList

    val getid: Int
        get() = count_id


    fun addTask(task: Task){
        _taskList.add(task)
        count_id++
    }
    fun removeTask(task: Task){
        println("removeTask")
        _taskList.remove(task)
        if (_taskList.size == 0){
            count_id= 0
        }
    }
    fun updateTask(task: Task){
        val index = _taskList.indexOfFirst { it.id == task.id }
        if (index != -1){
            _taskList[index] = task
        }
    }

    // hola?
    fun changeTaskCheked(task: Task, checked:Boolean){
        tasks.find { it.id == task.id }?.let {
            task.isDone = checked
        }

    }


}