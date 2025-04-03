package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var switchOn by remember { mutableStateOf(false) } //기본 false
    val todoList = remember{
        //mutableStateListOf<Item()>
        TodoItemFactory.makeTodoList()
    }
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        ){
        TodoListTitle(
            switchOn = switchOn,
            switchChange = { switchOn = it }
        )
        Spacer(modifier = Modifier.height(8.dp)) //공백
        Box( //vertical scroll을 사용하면 column에서 1f가 안된다고 해서 Box 이용
            modifier = Modifier
                .weight(1f) // 가능한 공간 다 차지
                .fillMaxWidth()
        ) {
            TodoList(
                todoList = todoList,
                switchOn = switchOn
            )
        }
        Spacer(modifier = Modifier.height(8.dp)) //공백
        TodoItemInput(todolist = todoList,
            modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}