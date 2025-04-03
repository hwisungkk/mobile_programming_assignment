package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eweek04a.R

@Composable
fun TodoListTitle(
    modifier: Modifier = Modifier,
    switchOn: Boolean,
    switchChange: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = stringResource(R.string.todolist_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = stringResource(R.string.my_number), //학번 string에 따로 저장
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Blue
            )
        }
        Spacer(modifier = Modifier.weight(1f)) // 왼쪽 요소와 Switch 사이 간격을 최대로

        Text(
            text = "미완료 항목만 보기",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp) // Switch와 간격 조정
        )

        Switch(
            checked = switchOn,
            onCheckedChange = switchChange
        )
    }
}

@Preview
@Composable
private fun TodoListTitlePreview() {
    var switchOn by remember { mutableStateOf(false) }
    TodoListTitle(
        switchOn = switchOn,
        switchChange = { switchOn = it }
    )
}