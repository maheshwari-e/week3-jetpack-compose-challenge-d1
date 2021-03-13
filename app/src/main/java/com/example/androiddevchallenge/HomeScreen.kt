package com.example.androiddevchallenge

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
 Scaffold( bottomBar = { bottomAppBar() }) {
  Column(
   Modifier
    .verticalScroll(rememberScrollState())
    .fillMaxSize()
    .padding(bottom = 56.dp)) {
   val search = rememberSaveable{ mutableStateOf("")}
   OutlinedTextField(modifier = Modifier
    .padding(start = 16.dp, end = 16.dp, top = 40.dp)
    .fillMaxWidth()
    .height(56.dp),value =search.value ,
    onValueChange = {search.value = it},
    label = {Text("Search", style = MaterialTheme.typography.body1,
     color = MaterialTheme.colors.onPrimary)},
    leadingIcon = { Icon(Icons.Filled.Search, null,modifier = Modifier.size(18.dp))},
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Search)
   )
   Text("Browse themes", style = MaterialTheme.typography.h1, color = MaterialTheme.colors.onPrimary,
    modifier = Modifier
     .padding(start = 16.dp, end = 16.dp, top = 14.dp)
     .height(32.dp))
   LazyRow(modifier = Modifier
    .padding(top = 16.dp)
    .fillMaxWidth()){
    items(themes){CardThemes(it)}
   }
   Row(Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp)) {
    Text("Design your home garden", style = MaterialTheme.typography.h1, color = MaterialTheme.colors.onPrimary,
     modifier = Modifier
      .weight(1f)
      .height(40.dp))
    Icon(Icons.Filled.FilterList, null, modifier = Modifier.size(24.dp))
   }
   Column(modifier = Modifier
    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    .fillMaxSize()) {
    themes.forEach { ListThemeItems(it) }
   }
  }
 }

}

@Composable
fun bottomAppBar() {
 val selected = rememberSaveable{ mutableStateOf(BottomMenu.HOME)}
 BottomAppBar(Modifier.background(color = MaterialTheme.colors.primary)) {
  BottomNavigationItem(selected = selected.value == BottomMenu.HOME,
   onClick = { selected.value = BottomMenu.HOME }, label = { Text(
    "Home", style = MaterialTheme.typography.caption,
    color = MaterialTheme.colors.onPrimary) },
   icon = { Icon( if(selected.value == BottomMenu.HOME)Icons.Filled.Home else Icons.Outlined.Home, null) }
  )
  BottomNavigationItem(selected =selected.value == BottomMenu.FAVOURITES ,
   onClick = {selected.value = BottomMenu.FAVOURITES}, label = {
    Text("Favourites", style = MaterialTheme.typography.caption,
     color = MaterialTheme.colors.onPrimary) },
   icon = { Icon(if(selected.value == BottomMenu.FAVOURITES)Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder, null) })
  BottomNavigationItem(selected = selected.value == BottomMenu.PROFILE,
   onClick = {selected.value = BottomMenu.PROFILE}, label = {
    Text("Profile", style = MaterialTheme.typography.caption,
     color = MaterialTheme.colors.onPrimary) },
   icon = { Icon(if(selected.value == BottomMenu.PROFILE)Icons.Filled.AccountCircle else Icons.Outlined.AccountCircle, null) })
  BottomNavigationItem(selected = selected.value == BottomMenu.CART,
   onClick = {selected.value = BottomMenu.CART}, label = {
    Text("Cart", style = MaterialTheme.typography.caption,
     color = MaterialTheme.colors.onPrimary) },
   icon = { Icon(if(selected.value == BottomMenu.CART)Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart, null) })
 }
}

@Composable
fun ListThemeItems(theme: Theme) {
 val checked = rememberSaveable{ mutableStateOf(false)}
 Row(modifier = Modifier
  .padding(bottom = 8.dp)
  .height(64.dp)
  .fillMaxWidth()) {
  Image(painter = painterResource(id = theme.image), null ,
   modifier = Modifier
    .size(64.dp)
    .clip(shape = RoundedCornerShape(4.dp)),
   contentScale = ContentScale.Crop)
  Column{
   Row{
    Column(modifier = Modifier.weight(1f)) {
     Text(
      theme.name, modifier = Modifier.padding(start = 16.dp, top = 10.dp),
      style = MaterialTheme.typography.h2,
      color = MaterialTheme.colors.onPrimary
     )
     Text(
      "This is description",
      style = MaterialTheme.typography.body1,
      color = MaterialTheme.colors.onPrimary,
      modifier = Modifier.padding(start = 16.dp)
     )
    }
    Checkbox(checked = checked.value, onCheckedChange = { checked.value = it}, modifier = Modifier.align(
     Alignment.CenterVertically))
   }
   Divider(color = MaterialTheme.colors.onPrimary, modifier = Modifier.padding(start = 8.dp, top = 12.dp))
  }
 }
}

@Composable
fun CardThemes(theme: Theme) {
 Card(modifier = Modifier
  .padding(start = 4.dp, end = 4.dp, bottom = 10.dp)
  .size(136.dp),shape = RoundedCornerShape(4.dp)) {
  Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
   Image(painterResource(theme.image), null,
    Modifier
     .height(96.dp),
    contentScale = ContentScale.Crop)
   Text(theme.name,
    Modifier
     .fillMaxSize()
     .background(MaterialTheme.colors.onSecondary)
     .padding(vertical = 8.dp),
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.h2,
    color = MaterialTheme.colors.onPrimary)
  }
 }

}

data class Theme(
 val name: String,
 @DrawableRes
 val image: Int
)

val themes = listOf<Theme>(
 Theme(name="Jungle vibes", R.drawable.pexels_volkan_vardar),
 Theme(name="Statements", R.drawable.pexels_sidnei_maia),
 Theme(name="Desert chic", R.drawable.pexels_quang_nguyen_vinh),
 Theme(name="Tiny terrariums", R.drawable.pexels_katarzyna_modrzejewska),
 Theme(name="Peace lily", R.drawable.pexels_melvin_vito),
 Theme(name="Aglaonema", R.drawable.pexels_karolina_grabowska),
 Theme(name="Monstera", R.drawable.pexels_huy_phan),
 Theme(name="Pothos", R.drawable.pexels_faraz_ahmad_1084199),
 Theme(name="Snake plant", R.drawable.pexels_fabian_stroobants),
 Theme(name="Fiddle leaf tree", R.drawable.pexels),
 Theme(name="Easy care", R.drawable.pexels_6208087)
)

enum class BottomMenu {
 HOME,
 FAVOURITES,
 PROFILE,
 CART
}