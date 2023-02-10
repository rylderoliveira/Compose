package com.impacta.compose.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.impacta.compose.R

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                SimpleImageComponent()
                Divider(color = Color.Gray)

                RoundedImageComponent()
                Divider(color = Color.Gray)

                ComplexWebImageComponent()
                Divider(color = Color.Gray)

                RoundedPainterImageComponent()
                Divider(color = Color.Gray)

                SimpleWebImageComponent()
                Divider(color = Color.Gray)
            }
        }
    }
}

@Preview
@Composable
fun SimpleImageComponent() {
    val image = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(imageVector = image, contentDescription = "Image")
    }
}

@Preview
@Composable
fun RoundedImageComponent() {
    val image = ImageVector.vectorResource(id = R.drawable.ic_launcher_background)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            imageVector = image,
            contentDescription = "Image",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .clip(shape = RoundedCornerShape(100.dp)),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun RoundedPainterImageComponent() {
    val image = painterResource(id = R.drawable.img)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = image,
            contentDescription = "Image",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .clip(shape = RoundedCornerShape(100.dp)),
            contentScale = ContentScale.None
        )
    }
}

@Preview
@Composable
fun SimpleWebImageComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://www.pontotel.com.br/wp-content/uploads/2022/05/imagem-corporativa.jpg",
            contentDescription = "Image"
        )
    }
}

@Preview
@Composable
fun ComplexWebImageComponent() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data("https://www.adobe.com/br/express/feature/image/media_142f9cf5285c2cdcda8375c1041d273a3f0383e5f.png?width=750&format=png&optimize=medium")
                .placeholder(R.drawable.baseline_adb_24)
                .crossfade(true)
                .crossfade(3000)
                .error(R.drawable.ic_launcher_background)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "Image"
        )
    }
}