package kz.djunglestones.speechrecognizer

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kz.djunglestones.speechrecognizer.network.Animal
import kz.djunglestones.speechrecognizer.viewModel.AnimalApiStatus

@BindingAdapter("animalApiStatus")
fun bindStatus(statusImageView: ImageView,status:AnimalApiStatus){
    when(status){
        AnimalApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        AnimalApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        AnimalApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, animal: Animal?) {
    animal?.let {
        val imgUri = animal.file_url.toUri()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

