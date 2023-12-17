package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.OnItemClickListener {

    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set the title for the activity
            setTitle("Recycler View");
        // Create a list of recipes
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Mango Tango Quinoa Salad", "This vibrant salad combines the sweetness of ripe mangoes with the nutty goodness of quinoa. The addition of colorful bell peppers and a zesty lime dressing makes it a refreshing and satisfying dish."));
        recipeList.add(new Recipe("Roasted Veggie Medley with Balsamic Glaze", "Experience the flavors of perfectly roasted vegetables drizzled with a tangy balsamic glaze. This medley includes a mix of hearty root vegetables and tender greens, creating a visually stunning and delicious side dish."));
        recipeList.add(new Recipe("Coconut Curry Lentil Soup", "Warm up with a bowl of this aromatic coconut curry lentil soup. The blend of spices, creamy coconut milk, and red lentils creates a comforting and flavorful soup that's perfect for chilly days."));
        recipeList.add(new Recipe("Pineapple Mint Green Smoothie", "Start your day with a burst of freshness! This green smoothie features the tropical sweetness of pineapple, the crispness of cucumber, and a hint of mint for a revitalizing and invigorating drink."));
        recipeList.add(new Recipe("Herb-Crusted Salmon with Dijon Mustard Glaze", "Elevate your seafood game with this herb-crusted salmon topped with a tangy Dijon mustard glaze. The combination of fresh herbs and savory mustard creates a mouthwatering crust that enhances the natural flavors of the salmon."));
        recipeList.add(new Recipe("Chia Seed Pudding Parfait", "Satisfy your sweet tooth with a wholesome chia seed pudding parfait. Layered with creamy coconut yogurt, fresh berries, and crunchy granola, this dessert is not only delicious but also packed with nutrients."));
        recipeList.add(new Recipe("Sweet Potato and Black Bean Tacos", "Spice up your taco night with these flavorful sweet potato and black bean tacos. The natural sweetness of roasted sweet potatoes pairs perfectly with the smokiness of black beans, creating a satisfying and hearty taco filling."));


        // Add more recipes as needed

        // Create RecyclerView and set adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecipeAdapter adapter = new RecipeAdapter(recipeList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        // Handle item click, start RecipeActivity
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("title", recipeList.get(position).getTitle());
        intent.putExtra("description", recipeList.get(position).getDescription());
        startActivity(intent);
    }
}
