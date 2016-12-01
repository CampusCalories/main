package com.example.austin.campuscalories;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.app.ExpandableListActivity;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;
import android.widget.ImageView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayInfoActivity extends ExpandableListActivity {

    private ExpandableListAdapter mAdapterView;
    android.widget.ExpandableListView expandableListView;
    Toolbar toolbar;
    private Toolbar supportActionBar;
    ImageView img;
    DishClass sampledish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        LocationClass newLocation = (LocationClass) i.getSerializableExtra("Object");

        if (newLocation.getName().equals("The Fresh Food Company")) {
            setContentView(R.layout.activity_display_info_fresh);
        } else if (newLocation.getName().equals("Burke Dining")) {
            setContentView(R.layout.activity_display_info_burke);
        } else {
            setContentView(R.layout.activity_display_info_lakeside);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(newLocation.getName());
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);

        //adding sample data
        newLocation.addDishToBreakfast(new DishClass("Scrambled Eggs and Toast"));
        newLocation.addDishToBreakfast(new DishClass("Biscuits and Gravy"));
        newLocation.addDishToBreakfast(new DishClass("Bagels and Cream Cheese"));

        newLocation.addDishToLunch(new DishClass("Steak Panini with Chips"));
        newLocation.addDishToLunch(new DishClass("Turkey on Rye with Pasta Salad"));
        newLocation.addDishToLunch(new DishClass("Grilled Chicken Casear Salad"));

        newLocation.addDishToDinner(new DishClass("Sirloin Steak with Potatoes"));
        newLocation.addDishToDinner(new DishClass("Chicken Fajitas and Queso"));
        newLocation.addDishToDinner(new DishClass("Grilled Salmon and Green Beans"));

        sampledish = new DishClass("Scrambled Eggs");
        sampledish.setCalories("143");
        sampledish.setCaloriesFromFat("89");
        sampledish.setSaturatedFat("2.3");
        sampledish.setTransFat("0.6");
        sampledish.setCholesterol("186");
        sampledish.setSodium("241");
        sampledish.setDietaryFiber("2.2");
        sampledish.setSugars("4.4");
        sampledish.setProtein("7.6");

        List<Map<String, String>> groupListItem = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childListItem = new ArrayList<List<Map<String, String>>>();

                /* ******************** Group item 0 ********************* */
        Map<String, String> group0 = new HashMap<String, String>();
        groupListItem.add(group0);
        group0.put("parentItem", "Hours of Operation");

        List<Map<String, String>> children0 = new ArrayList<Map<String, String>>();
        Map<String, String> hoursitem1 = new HashMap<String, String>();
        children0.add(hoursitem1);
        hoursitem1.put("childItem", "Monday: 7am - 6pm");

        Map<String, String> hoursitem2 = new HashMap<String, String>();
        children0.add(hoursitem2);
        hoursitem2.put("childItem", "Tuesday: 7am - 6pm");

        Map<String, String> hoursitem3 = new HashMap<String, String>();
        children0.add(hoursitem3);
        hoursitem3.put("childItem", "Wednesday: 7am - 6pm");

        Map<String, String> hoursitem4 = new HashMap<String, String>();
        children0.add(hoursitem4);
        hoursitem4.put("childItem", "Thursday: 7am - 6pm");

        Map<String, String> hoursitem5 = new HashMap<String, String>();
        children0.add(hoursitem5);
        hoursitem5.put("childItem", "Friday: 7am - 4pm");

        Map<String, String> hoursitem6 = new HashMap<String, String>();
        children0.add(hoursitem6);
        hoursitem6.put("childItem", "Saturday: CLOSED");

        Map<String, String> hoursitem7 = new HashMap<String, String>();
        children0.add(hoursitem7);
        hoursitem7.put("childItem", "Sunday: CLOSED");
        childListItem.add(children0);


	/* ******************** Group item 1 ********************* */
        Map<String, String> group1 = new HashMap<String, String>();
        groupListItem.add(group1);
        group1.put("parentItem", "Breakfast Menu");

        List<Map<String, String>> children1 = new ArrayList<Map<String, String>>();
        Map<String, String> childrenitem1 = new HashMap<String, String>();
        children1.add(childrenitem1);
        childrenitem1.put("childItem", newLocation.getBreakfast(0).getName());

        Map<String, String> childrenitem2 = new HashMap<String, String>();
        children1.add(childrenitem2);
        childrenitem2.put("childItem", newLocation.getBreakfast(1).getName());

        Map<String, String> childrenitem3 = new HashMap<String, String>();
        children1.add(childrenitem3);
        childrenitem3.put("childItem", newLocation.getBreakfast(2).getName());
        childListItem.add(children1);

	/* ******************** Group Item 2  ********************* */
        Map<String, String> childrenitem6 = new HashMap<String, String>();
        groupListItem.add(childrenitem6);
        childrenitem6.put("parentItem", "Lunch Menu");
        List<Map<String, String>> children2 = new ArrayList<Map<String, String>>();

        Map<String, String> childrenitem7 = new HashMap<String, String>();
        children2.add(childrenitem7);
        childrenitem7.put("childItem", newLocation.getLunch(0).getName());

        Map<String, String> childrenitem8 = new HashMap<String, String>();
        children2.add(childrenitem8);
        childrenitem8.put("childItem", newLocation.getLunch(1).getName());

        Map<String, String> child8 = new HashMap<String, String>();
        children2.add(child8);
        child8.put("childItem", newLocation.getLunch(2).getName());
        childListItem.add(children2);


        	/* ******************** Group Item 3  ********************* */
        Map<String, String> childrenitem9 = new HashMap<String, String>();
        groupListItem.add(childrenitem9);
        childrenitem9.put("parentItem", "Dinner Menu");
        List<Map<String, String>> children3 = new ArrayList<Map<String, String>>();

        Map<String, String> childrenitem10 = new HashMap<String, String>();
        children3.add(childrenitem10);
        childrenitem10.put("childItem", newLocation.getDinner(0).getName());

        Map<String, String> childrenitem11 = new HashMap<String, String>();
        children3.add(childrenitem11);
        childrenitem11.put("childItem", newLocation.getDinner(1).getName());

        Map<String, String> childrenitem12 = new HashMap<String, String>();
        children3.add(childrenitem12);
        childrenitem12.put("childItem", newLocation.getDinner(2).getName());
        childListItem.add(children3);

        mAdapterView = new SimpleExpandableListAdapter(
                this,
                groupListItem,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"parentItem"},
                new int[]{android.R.id.text1, android.R.id.text2},
                childListItem,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"childItem"},
                new int[]{android.R.id.text1}
        );

        setListAdapter(mAdapterView);
        expandableListView = getExpandableListView();
        expandableListView.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(android.widget.ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 1:
                        switch (childPosition) {
                            case 0:
                                displayDish(sampledish);
                                break;
                            case 1:
                                displayDish(sampledish);
                                break;
                            case 2:
                                displayDish(sampledish);
                                break;
                        }
                        break;
                    case 2:
                        switch (childPosition) {
                            case 0:
                                displayDish(sampledish);
                                break;
                            case 1:
                                displayDish(sampledish);
                                break;
                            case 2:
                                displayDish(sampledish);
                                break;
                        }
                        break;
                    case 3:
                        switch (childPosition) {
                            case 0:
                                displayDish(sampledish);
                                break;
                            case 1:
                                displayDish(sampledish);
                                break;
                            case 2:
                                displayDish(sampledish);
                                break;
                        }
                        break;
                }
                return false;
            }
        });
    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

    public void displayDish(DishClass dish) {
        DishClass newDish = dish;
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this); //Read Update
        alertDialog.setTitle("Nutritional Information");
        alertDialog.setMessage(newDish.getName()
                        + "\n\nCalories: " + newDish.getCalories()
                        + "\nCalories From Fat: " + newDish.getCaloriesFromFat()
                        + "\nSaturated Fat: " + newDish.getSaturatedFat() + "g"
                        + "\nTrans Fat: " + newDish.getTransfat() + "g"
                        + "\nSaturated Fat: " + newDish.getSaturatedFat() + "g"
                        + "\nCholesterol: " + newDish.getCholesterol() + "mg"
                        + "\nSodium: " + newDish.getSodium() + "mg"
                        + "\nDietary Fiber: " + newDish.getDietaryFiber() + "g"
                        + "\nSugars: " + newDish.getSugars() + "g"
                        + "\nProtein: " + newDish.getProtein() + "g");

        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("OK", null);
        alertDialog.show();
    }


}
