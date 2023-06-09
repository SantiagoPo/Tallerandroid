package com.example.myapplicationotraves

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.tooling.preview.Preview
    import com.example.myapplicationotraves.ui.theme.MyApplicationOtraVesTheme
    import androidx.compose.ui.unit.dp
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.unit.dp
    import androidx.compose.foundation.border
    import androidx.compose.material.MaterialTheme
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.runtime.mutableStateListOf

    import androidx.compose.foundation.clickable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationOtraVesTheme() {
                Conversation(SampleData.conversationSample)
            }

        }
        }
    }




@Composable
fun MessageCard(name:String){
    Text("Hello $name!")
}
/*
@Preview(showBackground = true)
@Composable
fun MessageCardPreview(){
    MessageCard(name = "Android")
*/


data class Message(val author: String, val body: String)
@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.luna),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(
                    1.5.dp,
                    androidx.compose.material3.MaterialTheme.colorScheme.secondary,
                    CircleShape
                )
        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded })   {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
            ) {
            Text(text = msg.body,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.body2)
        } }
    }
}



@Preview
@Composable
fun PreviewMessageCard() {
    MyApplicationOtraVesTheme{
        Surface {
            MessageCard(
                msg = Message("Santiago", "Take a look at Jetpack Compose, it's great!")
            )
        }
    }
}


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConversation() {
    MyApplicationOtraVesTheme() {
        Conversation(SampleData.conversationSample)
    }
}



