package com.example.jpcestado

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jpcestado.model.Task
import com.example.jpcestado.view.TaskViewModel


@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModelTask: TaskViewModel = viewModel()) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Listas de Tareas", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModelTask.addTask(Task(viewModelTask.getid, "Tarea ${(viewModelTask.getid)+1}","desc")) }) {
            Text(text = "Agregar tarea")
        }
        viewModelTask.gen_id()
        taskFullListChecked(tasks = viewModelTask.tasks, modifier = modifier
            ,
            onCheckedChange = { task, checked ->
                viewModelTask.changeTaskCheked(task, checked)
                println("onCheckedChange: ${task.title} - ${checked}")
            },

            onCloseTask ={ task->
                viewModelTask.removeTask(task)
                println("onCloseTask: ${task.title}")
            })

    }


}