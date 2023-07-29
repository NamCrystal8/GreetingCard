package com.example.mybirthdaycard

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybirthdaycard.ui.theme.MyBirthDayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBirthDayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthDayGreetingWithImage(message = "Chúc mừng sinh nhật", from = "Nam")
                }
            }
        }
    }
}

@Composable
fun BirthDayGreetingWithImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.bg_image1)
    val shiroko = painterResource(id = R.drawable.shiroko)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.FillBounds
        )
        BirthDayGreetingWithText(message = message, from = from)
        Image(painter = shiroko, contentDescription = "shiroko emoji",
            modifier =  Modifier.align(Alignment.Center)
            )

    }

}

@Composable
fun BirthDayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        content = {
            Text(
                text = message,
                fontSize = 32.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.Start)
                    .padding(start = 36.dp, top = 48.dp)
            );
            Text(
                text = "-từ " + from,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.End)
                    .padding(end = 16.dp)
            )

        }
    )


}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    MyBirthDayCardTheme {
        BirthDayGreetingWithImage(message = stringResource(R.string.happy_birthday_text), from = "Nam")
    }
}