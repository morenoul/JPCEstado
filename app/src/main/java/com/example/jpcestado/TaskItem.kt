package com.example.jpcestado


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jpcestado.model.Task


@Composable
fun AnticTaskItem(task: Task, onClose: (Task) -> Unit, modifier: Modifier =Modifier){
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(modifier = Modifier
            .weight(1f)
            .padding(start = 16.dp), text = task.title)

        IconButton(onClick = { onClose }) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}
@Composable
fun taskList(count:Int, onIncrement: () -> Unit, modifier: Modifier = Modifier){
    Column (modifier = Modifier.padding(16.dp)){
        if (count> 0) {
            Text(text = "tienes ${count} tareas", modifier = modifier)

        }
        Button(onClick = { onIncrement() }, modifier = Modifier.padding(8.dp), enabled = count < 10) {
            Text(text = "añadir")
        }
    }
}

@Composable
fun taskFullList(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableStateOf(0) }
    taskList(count = count, onIncrement = { count++ }, modifier = modifier)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun taskItem(
    task: Task,
    modifier: Modifier = Modifier,
    onClose: (Task) -> Unit,
    onCheckedChange: (Boolean) -> Unit
){
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        Text(modifier = Modifier
            .weight(1f)
            .padding(start = 16.dp), text = task.title)

        Checkbox(checked = task.isDone, onCheckedChange = onCheckedChange)
        IconButton(onClick = { onClose(task) } ) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }

}

@Composable
fun taskCheckedContainer(task:Task, modifier: Modifier = Modifier, onClose: (Task) -> Unit, onCheckedChange: (Task, Boolean) -> Unit){


    taskItem(task = task, onClose = {
        onClose(task)
    }, onCheckedChange = {checked ->
        onCheckedChange(task, checked)})
}


@Composable
fun taskFullListChecked(
    modifier: Modifier = Modifier,
    tasks: List<Task>,
    onCloseTask: (Task) -> Unit,
    onCheckedChange: (Task, Boolean) -> Unit) {


    LazyColumn(modifier = modifier){
        items(tasks.size, key = {index -> tasks[index].id}) { index ->
            taskCheckedContainer(task = tasks[index],
                onClose = { task ->
                    onCloseTask(task)
                },

                onCheckedChange = {
                        task, checked ->
                    onCheckedChange(task, checked)
                })
        }
    }
}


