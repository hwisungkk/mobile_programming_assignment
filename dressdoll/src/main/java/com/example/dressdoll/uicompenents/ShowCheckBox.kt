package com.example.dressdoll.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dressdoll.model.ImageData
import com.example.dressdoll.uicomponents.PartCheckBox

@Composable
fun ShowCheckBox(imageList: MutableList<ImageData>, modifier: Modifier = Modifier) {
    val chunkedList = imageList.chunked((imageList.size) / 2) // 항상 2열로 나누기 위해 반으로

    Row(
        modifier = modifier.padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        chunkedList.forEach { subList ->
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.Start
            ) {
                subList.forEach { imageData ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        PartCheckBox(imageData.checked) { isChecked ->
                            val idx = imageList.indexOf(imageData)
                            if (idx >= 0) {
                                imageList[idx] = imageData.copy(checked = isChecked)
                            }
                        }
                        Text(imageData.imgName)
                    }
                }
            }
        }
    }
}
