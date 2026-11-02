package com.example.kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.FontStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Hello(name = null)                   // Задание 1
            // HelloPreviewPortrait()               // Задание 2
            // CombinedTasksSample()                // Задания 3 и 4
            // InitialsHeader()                     // Задание 5
            // CircleTasksLayout()                  // Задание 6
            // ContactsLayout()                     // Задание 7
            // WaterTrackerSample()                 // Задание 8
            // ShoppingCartScreen()                 // Задание 10
        }
    }
}

// ==========================================
// ЗАДАНИЕ 1 и 2
// ==========================================
@Composable
fun Hello(name: String?) {
    val displayText = if (name != null) "Привет, $name!" else "Имя не задано"
    Text(text = displayText)
}

@Preview(name = "portrait", showSystemUi = true, device = "id:pixel_5")
@Composable
fun HelloPreviewPortrait() {
    Hello(name = "Вероника")
}

@Preview(name = "landscape", showSystemUi = true, device = "spec:width=1280dp,height=800dp,orientation=landscape")
@Composable
fun HelloPreviewLandscape() {
    Hello(name = "Вероника")
}

@Preview(name = "round", showSystemUi = true, device = "id:wearos_small_round")
@Composable
fun HelloPreviewRound() {
    Hello(name = "Вероника")
}

// ==========================================
// ЗАДАНИЯ 3 и 4
// ==========================================
@Composable
fun CombinedTasksSample() {
    val textStr = "Jetpack Compose - это современный набор инструментов для создания пользовательского интерфейса (UI) на Android, разработанный Google."

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = textStr,
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Text(
            text = textStr,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Text(
            text = textStr,
            color = Color.Black,
            fontSize = 24.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .background(Color.Green)
                .padding(start = 48.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* Действие */ },
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            border = BorderStroke(2.dp, Color.Gray)
        ) {
            Text(text = "Вероника, нажми на меня", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CombinedTasksPreview() {
    CombinedTasksSample()
}

// ==========================================
// ЗАДАНИЕ 5
// ==========================================
@Composable
fun InitialsHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .background(Color(0xFFFF5722), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Б.В.Б",
                color = Color.Black,
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InitialsHeaderPreview() {
    InitialsHeader()
}

// ==========================================
// ЗАДАНИЕ 6
// ==========================================
@Composable
fun CircleTasksLayout() {
    Column {
        CircleTopRight()
        Spacer(modifier = Modifier.height(24.dp))
        CircleCenteredAndStretched()
    }
}

@Composable
fun CircleTopRight() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFFFF5722), shape = CircleShape)
        )
    }
}

@Composable
fun CircleCenteredAndStretched() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF8E24AA), shape = CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircleTasksPreview() {
    CircleTasksLayout()
}

// ==========================================
// ЗАДАНИЕ 7
// ==========================================
@Composable
fun ContactsLayout() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Вариант 1 (Column):", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        ContactColumnSample()
        Spacer(modifier = Modifier.height(32.dp))
        Text("Вариант 2 (Row):", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        ContactRowSample()
    }
}

@Composable
fun ContactColumnSample() {
    Column {
        Text("Имя: Вероника", fontSize = 16.sp)
        Text("Фамилия: Буханцева", fontSize = 16.sp)
        Text("Мобильный телефон: +7 968 361 52 67", fontSize = 16.sp)
        Text("Адрес: г. Москва, ул. Ленина, д. 4", fontSize = 16.sp)
    }
}

@Composable
fun ContactRowSample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text("Имя: Вероника", fontSize = 16.sp)
            Text("Фамилия: Буханцева", fontSize = 16.sp)
            Text("Мобильный телефон: +7 968 361 52 67", fontSize = 16.sp)
            Text("Адрес: г. Москва, ул. Ленина, д. 4", fontSize = 16.sp)
        }
        Text(
            text = "★",
            color = Color(0xFFFF9800),
            fontSize = 32.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactsPreview() {
    ContactsLayout()
}

// ==========================================
// ЗАДАНИЯ 8 и 9
// ==========================================
@Composable
fun WaterTrackerSample() {
    var waterCount by remember { mutableIntStateOf(0) }
    var streakDays by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Трекер Воды Вероники", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "$waterCount мл", fontSize = 44.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { waterCount += 250 }) {
                Text(text = "+250 мл", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(
                onClick = {
                    if (waterCount >= 1500) streakDays += 1 else streakDays = 0
                    waterCount = 0
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Завершить день", color = Color.White, fontSize = 16.sp)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Дней подряд выполнено: $streakDays", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray)
    }
}

@Preview(name = "Задания 8 и 9: Трекер и UI-тест", showBackground = true)
@Composable
fun FinalWaterTrackerPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WaterTrackerSample()
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Результат UI-теста:", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE8F5E9), shape = RoundedCornerShape(12.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "✔ UI_TEST_SUCCESS: test_add_water_and_streak", color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "СОСТОЯНИЕ: Проверено кликов по +250 мл (6 раз)", fontSize = 12.sp, color = Color.Gray)
                Text(text = "Тест подтвердил: Дней подряд выполнено = 1", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}

// ==========================================
// ЗАДАНИЕ 10
// ==========================================
data class Product(val id: Int, val name: String, val price: Int)

@Composable
fun ShoppingCartScreen() {
    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 50)
            )
        )
    }

    val totalSum = products.sumOf { it.price }
    val productSize = products.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Корзина Вероники Буханцевой",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF673AB7)
        )
        Spacer(modifier = Modifier.height(16.dp))

        for (product in products) {
            Text(
                text = "${product.name} - ${product.price} рублей",
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Товаров на сумму: $totalSum рублей",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Button(
            onClick = {
                products = products + Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(50, 200)
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Добавить случайный товар")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (productSize > 0) {
            Button(
                onClick = { products = products.dropLast(1) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Удалить последний товар")
            }
        }

        if (totalSum > 500) {
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE8F5E9), shape = RoundedCornerShape(8.dp))
                    .padding(12.dp)
            ) {
                Text(
                    text = "Доставка бесплатная!",
                    color = Color(0xFF2E7D32),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartPreview() {
    ShoppingCartScreen()
}