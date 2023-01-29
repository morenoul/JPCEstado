package com.example.jpcestado.provider

import com.example.jpcestado.model.Task


class TaskProvider {
    companion object{
        var tareas = mutableListOf<Task>(
            Task(0,"Trabajo", "Descripcion 1", true),
            Task(1,"Estudio", "Descripcion 2", false),
            Task(2,"Gimnasio", "Descripcion 3", false),
            Task(3,"Perros", "Descripcion 4", false),
            Task(4,"Copas", "Descripcion 5", true)
        )
        var aux = mutableListOf<Task>()

    }
}