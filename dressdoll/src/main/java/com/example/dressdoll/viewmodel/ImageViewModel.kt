package com.example.dressdoll.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dressdoll.model.ImageData
import com.example.dressdoll.model.ImageListFactory

class ImageViewModel : ViewModel(){
    private val _imageList = ImageListFactory.makeImageList()
    val imageList:MutableList<ImageData>
        get() = _imageList
}