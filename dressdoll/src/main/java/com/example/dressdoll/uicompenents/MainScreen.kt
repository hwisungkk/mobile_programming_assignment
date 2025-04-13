package com.example.dressdoll.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dressdoll.viewmodel.ImageViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, imageViewModel: ImageViewModel = viewModel()) {
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    Text("202111279 김휘성",modifier= modifier.padding(30.dp))
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp)) // 공백 조금 두기
            DressPart(imageList = imageList, modifier = Modifier.size(400.dp))
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DressPart(imageList = imageList, modifier = Modifier.size(400.dp))
        }
    }
}