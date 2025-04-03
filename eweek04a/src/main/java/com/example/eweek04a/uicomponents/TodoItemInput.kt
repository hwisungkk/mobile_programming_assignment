package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodoItemInput(todolist:MutableList<Item>, modifier: Modifier = Modifier) {
    var textFieldState by remember { mutableStateOf("") }

    fun addContent(content: String) {
        val currentTime = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
        todolist.add(Item(content, currentTime))
    }
    Row(
        modifier = modifier.fillMaxWidth(),  // 부모의 modifier
        horizontalArrangement = Arrangement.spacedBy(6.dp) // 버튼과 입력 간격 추가
    ){
        TextField(
            value = textFieldState,
            onValueChange = {text:String -> textFieldState = text},
            placeholder = {Text("할 일을 입력하세요.")}
        )
        Button(onClick = {
            if (textFieldState.isNotBlank()) {
                addContent(textFieldState)
                textFieldState = ""
            }
        },
            modifier = Modifier // 추가 버튼 크기 조절
                .width(150.dp) // 가로 크기 조절
                .height(60.dp) // 세로 크기 조절
        ) {
            Text("추가")
        }
    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList())
}