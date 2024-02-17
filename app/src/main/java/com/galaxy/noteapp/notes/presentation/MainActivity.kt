package com.galaxy.noteapp.notes.presentation

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.galaxy.noteapp.notes.domain.model.Note
import com.galaxy.noteapp.ui.theme.MyTypography
import com.galaxy.noteapp.ui.theme.NoteAppTheme
import com.galaxy.noteapp.ui.theme.NoteColor
import com.galaxy.noteapp.ui.theme.PurpleGrey40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NoteItem()
                }
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFF000000)
fun NoteItem(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 15.dp
){
    Box(
        modifier = modifier,
    ){
        Card(
            modifier = Modifier
                .size(128.dp),
            colors = CardDefaults.cardColors(
                containerColor = NoteColor
            ),
            shape = RoundedCornerShape(cornerRadius)

        ) {
            Text(
                text = "jahfajfjahfjahfjafahfhafhahhhhhhhhhhhhhhhhhh",
                style = MyTypography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

