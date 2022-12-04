package com.github.ameen.androidkotlintemplate.presentation.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import java.io.File

fun Context.showShortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun View.hideView() {
    this.visibility = View.GONE
}

fun View.showView() {
    this.visibility = View.VISIBLE
}

fun View.invisibleView() {
    this.visibility = View.INVISIBLE
}

fun Context.loadImage(@DrawableRes path: Int, view: ImageView) {
    Glide.with(this)
        .load(path)
        .into(view)
}

fun Context.getPicturesFile(fileName: String, subDirectory: String = ""): File {
    return File(this.cacheDir.absolutePath.plus("/$subDirectory"), fileName)
}