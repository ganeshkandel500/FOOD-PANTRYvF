package com.example.food;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recipe extends AppCompatActivity {

    Button GotoHome, inventoryDisplay;
    private ListView listView;
    private List<String> recipeList;
    private List<String> recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        GotoHome=findViewById(R.id.homepage);
        inventoryDisplay=findViewById(R.id.inventoryaddbtn);
        listView=findViewById(R.id.listView);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        GotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        inventoryDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Inventory.class));
                finish();
            }
        });

        recipeList = new ArrayList<>();
        recipeList.add("Pizza");
        recipeList.add("Cobb Salad");
        recipeList.add("Fajitas");
        recipeList.add("French fries");
        recipeList.add("Banana Split");
        recipeList.add("Jambalaya");
        recipeList.add("Chicken curry");
        recipeList.add("Macatoni and Cheese");
        recipeList.add("Peanut Butter Sandwich");
        recipeList.add("Baked Beans");
        recipeList.add("Chicken Dumplings");
        recipeList.add("Biryani");

        recipe = new ArrayList<>();
        recipe.add("Ingredients:\n\n" +
                "1 package (1/4 ounce) active dry yeast\n" +
                "1 teaspoon sugar\n" +
                "1-1/4 cups warm water (110° to 115°)\n" +
                "1/4 cup canola oil\n" +
                "1 teaspoon salt\n" +
                "3-1/2 to 4 cups all-purpose flour\n" +
                "1/2 pound ground beef\n" +
                "1 small onion, chopped\n" +
                "1 can (15 ounces) tomato sauce\n" +
                "3 teaspoons dried oregano\n" +
                "1 teaspoon dried basil\n" +
                "1 medium green pepper, diced\n" +
                "2 cups shredded part-skim mozzarella cheese" +
                "\n\nDirections\n\n" +
                "In large bowl, dissolve yeast and sugar in water; let stand for 5 minutes. Add oil and salt. Stir in flour, 1 cup at a time, until a soft dough forms.\n\n" +
                "\nTurn onto a floured surface; knead until smooth and elastic, 2-3 minutes. Place in a greased bowl, turning once to grease the top. Cover and let rise in a warm place until doubled, about 45 minutes. Meanwhile, cook beef and onion over medium heat until beef is no longer pink, breaking meat into crumbles; drain.\n" +
                "\nPunch down dough; divide in half. Press each half into a greased 12-in. pizza pan. Combine the tomato sauce, oregano and basil; spread over each crust. Top with beef mixture, green pepper and cheese.\n" +
                "\nBake at 400° for 25-30 minutes or until crust is lightly browned.");
        recipe.add("INGREDIENTS:\n\n" +
                "1/3 c. red wine vinegar\n" +
                "1 tbsp. Dijon mustard\n" +
                "2/3 c. extra-virgin olive oil\n" +
                "Kosher salt\n" +
                "Freshly ground black pepper\n" +
                "1 head romaine lettuce, coarsely chopped\n" +
                "4 hard-boiled eggs, peeled and quartered\n" +
                "12 oz. cooked chicken, diced\n" +
                "8 slices bacon, cooked and crumbled\n" +
                "1 avocado, thinly sliced\n" +
                "4 oz. crumbled blue cheese\n" +
                "5 oz. cherry tomatoes, halved\n" +
                "2 tbsp. finely chopped chives \n\n DIRECTIONS\n" +
                "\nIn a jar, shake together vinegar, mustard, and oil and season with salt and pepper.\n" +
                "\nOn a large platter, spread out lettuce, then add rows of hard-boiled egg, chicken, bacon, avocado, blue cheese, and cherry tomatoes.\n" +
                "\nSeason with salt and pepper, drizzle with dressing, and garnish with chives.");
        recipe.add("Hot oil and put meat and cooked.");
        recipe.add("Cut potatoes and put in hot oil");
        recipe.add("Put all vegies and mix it.");

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                recipeList);
        listView.setAdapter(arr);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                alertDialogBuilder.setTitle("Recipe for: " + selectedItem);
                alertDialogBuilder.setMessage(recipe.get(position));

                alertDialogBuilder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }
}