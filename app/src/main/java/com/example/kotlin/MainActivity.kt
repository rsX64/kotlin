package com.example.kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.ui.theme.KotlinTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTheme {
                // Задание 1
                //Hello("Александр")
                //Hello(null)

                //Задание 2
                //HelloPreviewRound()
                //HelloPreviewLandscape()
                //HelloPreviewPortrait()

                // Задание 3
                //StyledText()

                // Задание 4
                //CustomButton()

                // Задание 5
                //InitialsContainer()

                // Задание 6
                //CircleTopRight()
                CircleStretchedPurple()

                // Задание 7
                //ContactColumnPreview()
                //ContactRowPreview()

                // Задание 8
                //WaterTracker()

                // Задание 10
                //ShoppingCartScreen()
            }
        }
    }
}

// Задание 1
@Composable
fun Hello(name: String?) {
    val displayName = if (name == null) "Имя не задано" else "Привет, $name!"
    Text(text = displayName)
}

// Задание 2
@Preview(name = "portrait", showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Composable
fun HelloPreviewPortrait() { KotlinTheme { Hello("Портрет") } }

@Preview(name = "landscape", showSystemUi = true, device = "spec:width=891dp,height=411dp")
@Composable
fun HelloPreviewLandscape() { KotlinTheme { Hello("Ландшафт") } }

@Preview(name = "round", showSystemUi = true, device = "spec:width=200dp,height=200dp,isRound=true")
@Composable
fun HelloPreviewRound() {
    KotlinTheme {
        Surface(color = Color.Yellow, modifier = Modifier.fillMaxSize()) { Hello("Круг") }
    }
}

// Задание 3
@Composable
fun StyledText() {
    Column {
        Text(
            text = stringResource(id = R.string.long_text),
            modifier = Modifier.padding(top = 48.dp).background(Color.Green),
            color = Color.Black,
            fontSize = 24.sp,
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = stringResource(id = R.string.long_text),
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

// Задание 4
@Composable
fun CustomButton() {
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Black)
    ) {
        Text(text = "Нажми на меня")
    }
}

// Задание 5
@Composable
fun InitialsContainer() {
    Row(
        modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Gray),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.fillMaxHeight().padding(vertical = 16.dp).aspectRatio(1f).background(Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "A5", color = Color.Black)
        }
    }
}

// Задание 6
@Composable
fun CircleTopRight() {
    Box(modifier = Modifier.size(width = 240.dp, height = 120.dp).background(Color.Black)) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = null,
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

@Composable
fun CircleStretchedPurple() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = null,
            modifier = Modifier
                .width(240.dp)
                .height(120.dp),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}

// Задание 7
@Composable
fun ContactCard(name: String, phone: String, address: String, isRow: Boolean = false, showStar: Boolean = false) {
    val content = @Composable {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp)) {
            Text("Имя: $name", fontWeight = FontWeight.Bold)
            Text("Телефон: $phone")
            Text("Адрес: $address", textAlign = TextAlign.Center)
        }
    }

    if (isRow) {
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            content()
            if (showStar) {
                Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(8.dp)) {
            content()
        }
    }
}

@Composable
fun ContactColumnPreview() {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        ContactCard("Евгений", "+7 495...", "Москва...")
        ContactCard("Иван", "+7 495...", "Москва...")
        ContactCard("Петр", "+7 495...", "Москва...")
    }
}

@Composable
fun ContactRowPreview() {
    ContactCard("Евгений", "+7 495...", "Москва...", isRow = true, showStar = true)
}

// Задание 8
@Composable
fun WaterTracker() {
    var waterCount by remember { mutableIntStateOf(0) }
    var streakDays by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Трекер воды", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(48.dp))
        Text("$waterCount мл", fontSize = 48.sp, fontWeight = FontWeight.Bold)
        Text("Дней подряд (1500+ мл): $streakDays", fontSize = 20.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { waterCount += 250 }) {
            Text("+250 мл")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (waterCount >= 1500) streakDays++ else streakDays = 0
            waterCount = 0
        }) {
            Text("Завершить день")
        }
    }
}

// Задание 10
data class Product(val id: Int, val name: String, val price: Int)

@Composable
fun ShoppingCartScreen() {
    var cartProducts by remember { mutableStateOf(emptyList<Product>()) }
    val context = LocalContext.current

    val totalSum = cartProducts.sumOf { it.price }
    val productSize = cartProducts.size

    LaunchedEffect(totalSum) {
        if (totalSum > 500) {
            Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        cartProducts.forEach { product ->
            Text(text = "${product.name} - ${product.price} рублей")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")

        Button(onClick = {
            val newProduct = Product(
                id = productSize,
                name = "Товар #${productSize + 1}",
                price = Random.nextInt(50, 200)
            )
            cartProducts = cartProducts + newProduct
        }) {
            Text(text = "Добавить товар")
        }

        if (productSize > 0) {
            Button(onClick = { cartProducts = cartProducts.dropLast(1) }) {
                Text(text = "Удалить товар")
            }
        }
    }
}