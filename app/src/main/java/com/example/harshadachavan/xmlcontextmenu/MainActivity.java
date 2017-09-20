package com.example.harshadachavan.xmlcontextmenu;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();
        // Get the activity
        mActivity = MainActivity.this;

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mTextView = (TextView) findViewById(R.id.tv);

        /*
            public void registerForContextMenu (View view)
                Registers a context menu to be shown for the given view (multiple views can show the
                context menu). This method will set the View.OnCreateContextMenuListener on the view
                to this activity, so onCreateContextMenu(ContextMenu, View, ContextMenuInfo) will be
                called when it is time to show the context menu.

            Parameters
                view : The view that should show a context menu.

        */
        // First step to show a custom context menu on text view
        registerForContextMenu(mTextView);

    }


    /*
        public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
            Called when a context menu for the view is about to be shown.
            Unlike onCreateOptionsMenu(Menu), this will be called every time the context menu is
            about to be shown and should be populated for the view (or item inside the view for
            AdapterView subclasses, this can be found in the menuInfo)).

            Use onContextItemSelected(android.view.MenuItem) to know when an item has been selected.

            It is not safe to hold onto the context menu after this method returns.

        Parameters
            menu : The context menu that is being built
            v : The view for which the context menu is being built
            menuInfo : Extra information about the item for which the context menu should be shown.
                       This information will vary depending on the class of v.
    */
    @Override
    public void onCreateContextMenu(
            ContextMenu menu,
            View v,
            ContextMenu.ContextMenuInfo menuInfo
    ){
        super.onCreateContextMenu(menu, v, menuInfo);

        /*
            MenuInflater
                This class is used to instantiate menu XML files into Menu objects.

                For performance reasons, menu inflation relies heavily on pre-processing of XML
                files that is done at build time.
        */
        /*
            public MenuInflater getMenuInflater ()
                Returns a MenuInflater with this context.
        */
        MenuInflater inflater = getMenuInflater();

        /*
            public void inflate (int menuRes, Menu menu)
                Inflate a menu hierarchy from the specified XML resource. Throws InflateException if there is an error.

            Parameters
                menuRes : Resource ID for an XML layout resource to load (e.g., R.menu.main_activity)
                menu : The Menu to inflate into. The items and submenus will be added to this Menu.

        */
        inflater.inflate(R.menu.context_menu, menu);

        /*
            public abstract ContextMenu setHeaderTitle (CharSequence title)
                Sets the context menu header's title to the title given in title.

            Parameters
                title : The character sequence used for the title.
            Returns
                This ContextMenu so additional setters can be called.
        */
        // Set a title for context menu
        menu.setHeaderTitle("Context Menu");
    }


    /*
        public boolean onContextItemSelected (MenuItem item)
            This hook is called whenever an item in a context menu is selected. The default
            implementation simply returns false to have the normal processing happen (calling the
            item's Runnable or sending a message to its Handler as appropriate). You can use this
            method for any items for which you would like to do processing without
            those other facilities.

            Use getMenuInfo() to get extra information set by the View that added this menu item.

            Derived classes should call through to the base class for it to perform the
            default menu handling.

        Parameters
            item : The context menu item that was selected.
        Returns
            boolean : Return false to allow normal context menu processing to proceed,
                      true to consume it here.
    */
    @Override
    public boolean onContextItemSelected(MenuItem item){
        // Handle the menu item selection
        switch(item.getItemId()){
            case R.id.red:
                Toast.makeText(mContext,"Action 1 Selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.green:
                Toast.makeText(mContext,"Action 2 Selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.blue:
                Toast.makeText(mContext,"Action 3 Selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
